package com.model.repository;

import com.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends PagingAndSortingRepository<Question,Long> {
    @Query(value = "select * from question where title like %?1% and flag=0  order by date_create",nativeQuery = true)
    Page<Question> findAllQuestion(String title, Pageable pageable);
}
