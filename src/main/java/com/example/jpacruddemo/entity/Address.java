package com.example.jpacruddemo.entity;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    int address_id;

    @Column(name="employee_id")
    int employee_id;

    @Column(name="street")
    String street;

    @Column(name="city")
    String city;

    @Column(name="state")
    String state;

    @Column(name="pin_code")
    String pin_code;

    public Address() {
    }

    public Address(int address_id, int employee_id, String street, String city, String state, String pin_code) {
        this.address_id = address_id;
        this.employee_id = employee_id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pin_code = pin_code;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }
}

