package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IDictionaryService;

@Controller
public class DictionaryController {
    @Autowired()
    IDictionaryService iDictionaryService;

    @GetMapping()
    public String home(){
        return "home";
    }
    @PostMapping()
    public String translate(@RequestParam String input, Model model){
        model.addAttribute("result", iDictionaryService.check(input.toLowerCase()));
        return home();
    }

}
