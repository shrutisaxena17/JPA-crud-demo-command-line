package com.example.jpacruddemo.service;

import com.example.jpacruddemo.dao.GenricDAO;
import com.example.jpacruddemo.entity.Address;
import com.example.jpacruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private GenricDAO<Address,Integer> addressDAO;

    @Autowired
    AddressService(GenricDAO<Address,Integer> addressDAO){
        this.addressDAO=addressDAO;
    }

    public void saveAddress(Address address){
        addressDAO.save(address);
    }

    public Address findAddressById(Integer id){
        return addressDAO.findById(id);
    }

    public List<Address> findAllAddress(){
        return  addressDAO.findAll();
    }

    public void updateAddress(Address address){
        addressDAO.update(address);
    }

    public void deleteAddress(Integer id){
        addressDAO.delete(id);
    }
}
