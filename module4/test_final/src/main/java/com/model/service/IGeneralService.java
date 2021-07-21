package com.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneralService<T> {
    Page<T> findAll(String name,Pageable pageable);
    T findById(Long id);
    void save(T o);
    void remove(Long id);
}
