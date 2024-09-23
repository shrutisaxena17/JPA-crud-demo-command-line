package com.example.jpacruddemo.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="employee_id")
    private int  employee_id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String  last_name;

    @Column(name="email")
    private String email;

    @Column(name="date_of_birth")
    private Date date_of_birth;

    @Column(name="phone")
    private long phone;

    @Column(name="gender")
    private String gender;

   @Column(name="job_role")
   private String job_role;

   @Column(name="salary")
   private double salary;

   @Column(name="department_id")
   private int department_id;

    public Employee() {
    }

    public Employee(int employee_id, String first_name, String last_name, String email, Date date_of_birth, long phone, String gender, String job_role, double salary, int department_id) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.phone = phone;
        this.gender = gender;
        this.job_role = job_role;
        this.salary = salary;
        this.department_id = department_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob_role() {
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", phone=" + phone +
                ", gender='" + gender + '\'' +
                ", job_role='" + job_role + '\'' +
                ", salary=" + salary +
                ", department_id=" + department_id +
                '}';
    }
}

