package com.example.jpacruddemo.dao;

import com.example.jpacruddemo.entity.Address;
import com.example.jpacruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAO implements GenricDAO<Address,Integer> {

    EntityManager entityManager;

    @Autowired
    AddressDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Address address) {
     entityManager.persist(address);
    }

    @Override
    public Address findById(Integer id) {
        return entityManager.find(Address.class,id);
    }

    @Override
    public List<Address> findAll() {
        TypedQuery<Address> theQuery=entityManager.createQuery("FROM Address", Address.class);
        List<Address> addressList=theQuery.getResultList();
        return addressList;
    }

    @Override
    @Transactional
    public void update(Address address) {
        entityManager.merge(address);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Address address=entityManager.find(Address.class,id);
        if(address!=null){
            entityManager.remove(address);
        }
    }
}
