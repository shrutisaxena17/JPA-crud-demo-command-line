package com.example.jpacruddemo.service;

import com.example.jpacruddemo.dao.GenricDAO;
import com.example.jpacruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
   private GenricDAO<Employee,Integer> employeeDao;

   @Autowired
    EmployeeService(GenricDAO<Employee,Integer> employeeDao){
       this.employeeDao=employeeDao;
   }

   public void saveEmployee(Employee employee){
       employeeDao.save(employee);
   }

   public Employee findEmployeeById(Integer id){
       return employeeDao.findById(id);
   }

   public List<Employee> findAllEmployee(){
       return  employeeDao.findAll();
   }

   public void updateEmployee(Employee employee){
       employeeDao.update(employee);
   }

   public void deleteEmployee(Integer id){
       employeeDao.delete(id);
   }
}
