package com.model.repository;

import com.model.entity.QuestionType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionTypeRepository extends PagingAndSortingRepository<QuestionType,Long> {
}
