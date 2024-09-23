package com.example.jpacruddemo.dao;

import com.example.jpacruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAO implements GenricDAO<Employee, Integer> {

    EntityManager entityManager;

    @Autowired
    EmployeeDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
     entityManager.persist(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employeeList=theQuery.getResultList();
        return employeeList;
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }
}
