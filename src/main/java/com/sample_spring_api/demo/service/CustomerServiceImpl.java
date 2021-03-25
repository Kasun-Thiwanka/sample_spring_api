package com.sample_spring_api.demo.service;

import com.sample_spring_api.demo.entity.CustomerEntity;
import com.sample_spring_api.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo theCustomerRepo){
        customerRepo =theCustomerRepo;
    }
    @Override
    @Transactional
    public List<CustomerEntity> findAll() {
        return customerRepo.findAll();
    }

    @Override
    @Transactional
    public CustomerEntity findById(int theId) {
        return customerRepo.findById(theId);
    }

    @Override
    @Transactional
    public void save(CustomerEntity theCustomer) {
        customerRepo.save(theCustomer);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerRepo.deleteById(theId);
    }
}
