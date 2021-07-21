package com.model.service;

import com.model.entity.QuestionType;

import java.util.List;

public interface IQuestionTypeService extends IGeneralService<QuestionType> {
    List<QuestionType> findAllQuestionType();
}
