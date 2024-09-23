package com.example.jpacruddemo.dao;

import com.example.jpacruddemo.entity.Address;
import com.example.jpacruddemo.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAO implements GenricDAO<Department,Integer>{

    EntityManager entityManager;

    @Autowired
    DepartmentDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Department department) {
        entityManager.persist(department);
    }

    @Override
    public Department findById(Integer id) {
        return entityManager.find(Department.class,id);
    }

    @Override
    public List<Department> findAll() {
        TypedQuery<Department> theQuery=entityManager.createQuery("FROM Department", Department.class);
        List<Department> departmentList=theQuery.getResultList();
        return departmentList;
    }

    @Override
    @Transactional
    public void update(Department department) {
        entityManager.merge(department);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Department department=entityManager.find(Department.class,id);
        if(department!=null){
            entityManager.remove(department);
        }
    }
}
