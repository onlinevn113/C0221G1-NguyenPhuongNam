package com.controller;

import com.model.dto.QuestionDto;
import com.model.entity.Question;
import com.model.entity.QuestionType;
import com.model.service.IQuestionService;
import com.model.service.IQuestionTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    IQuestionService questionService;
    @Autowired
    IQuestionTypeService questionTypeService;

    @ModelAttribute("questionTypes")
    private List<QuestionType> questionTypes() {
        return questionTypeService.findAllQuestionType();
    }
    @GetMapping({"", "/search"})
    public ModelAndView showList(@RequestParam("search") Optional<String> search, @PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("/list", "questions", questionService.findAllQuestion(search.orElse(""), pageable))
                .addObject("search", search.orElse(""));
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("/create", "questionDto", new QuestionDto());
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Valid QuestionDto questionDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/create", "msg", "Something wrong!! Try again");
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto, question);
        questionService.save(question);
        redirectAttributes.addFlashAttribute("msg", "Create is successful!!");
        return new ModelAndView("redirect:/question");
    }
    @GetMapping("/edit/{idc}")
    public ModelAndView showEdit(@PathVariable Long idc) {
        if (questionService.findById(idc) == null) {
            return new ModelAndView("error-404");
        }
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(questionService.findById(idc), questionDto);
        return new ModelAndView("/edit", "questionDto", questionDto);
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Valid QuestionDto questionDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/edit", "msg", "Something wrong!! Try again");
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto, question);
        question.setStatus("Đã phản hồi");
        questionService.save(question);
        redirectAttributes.addFlashAttribute("msg", "Edit is successful!!");
        return new ModelAndView("redirect:/question");
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        Question question = questionService.findById(id);
        if (question == null) {
            return new ModelAndView("error-404");
        }
        question.setFlag(true);
        questionService.save(question);
        redirectAttributes.addFlashAttribute("msg", "Delete is successful!!");
        return new ModelAndView("redirect:/question");
    }
}
