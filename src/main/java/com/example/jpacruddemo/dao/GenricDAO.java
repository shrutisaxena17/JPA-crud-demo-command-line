package com.example.jpacruddemo.dao;

import com.example.jpacruddemo.entity.Employee;

import java.util.List;

public interface GenricDAO<T,ID> {

    void save(T entity);

    T findById(ID id);

    List<T> findAll();

    void update(T entity);

    void delete(ID id);
}
