package com.example.jpacruddemo.service;

import com.example.jpacruddemo.dao.GenricDAO;
import com.example.jpacruddemo.entity.Department;
import com.example.jpacruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private GenricDAO<Department,Integer> departmentDAO;

    @Autowired
    DepartmentService(GenricDAO<Department,Integer> departmentDAO){
        this.departmentDAO=departmentDAO;
    }

    public void saveDepartment(Department department){
        departmentDAO.save(department);
    }

    public Department findDepartmentById(Integer id){
        return departmentDAO.findById(id);
    }

    public List<Department> findAllDepartment(){
        return  departmentDAO.findAll();
    }

    public void updateDepartment(Department department){
        departmentDAO.update(department);
    }

    public void deleteDepartment(Integer id){
        departmentDAO.delete(id);
    }
}
