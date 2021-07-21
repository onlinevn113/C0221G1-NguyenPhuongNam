package com.model.service;

import com.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService extends IGeneralService<Question> {
    Page<Question> findAllQuestion(String title, Pageable pageable);
}
