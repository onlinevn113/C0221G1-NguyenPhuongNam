package com.model.service.impl;

import com.model.entity.Question;
import com.model.repository.IQuestionRepository;
import com.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    IQuestionRepository questionRepository;

    @Override
    public Page<Question> findAllQuestion(String title, Pageable pageable) {
        return questionRepository.findAllQuestion(title,pageable);
    }
    @Override
    public Page<Question> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Question o) {
        questionRepository.save(o);
    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);
    }
}
