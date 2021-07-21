package com.model.service.impl;

import com.model.entity.QuestionType;
import com.model.repository.IQuestionTypeRepository;
import com.model.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    IQuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAllQuestionType() {
        return (List<QuestionType>) questionTypeRepository.findAll();
    }

    @Override
    public Page<QuestionType> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public QuestionType findById(Long id) {
        return questionTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(QuestionType o) {
        questionTypeRepository.save(o);
    }

    @Override
    public void remove(Long id) {
        questionTypeRepository.deleteById(id);
    }

}
