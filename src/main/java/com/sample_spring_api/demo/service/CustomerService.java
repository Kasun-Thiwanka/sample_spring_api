package com.sample_spring_api.demo.service;

import com.sample_spring_api.demo.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {

    public List<CustomerEntity> findAll();

    public CustomerEntity findById(int theId);

    public void save(CustomerEntity theCustomer);

    public void deleteById(int theId);

}
