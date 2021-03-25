package com.sample_spring_api.demo.repository;

import com.sample_spring_api.demo.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepo {

    public List<CustomerEntity> findAll();

    public CustomerEntity findById(int theId);

    public void save(CustomerEntity theCustomer);

    public void deleteById(int theId);
}