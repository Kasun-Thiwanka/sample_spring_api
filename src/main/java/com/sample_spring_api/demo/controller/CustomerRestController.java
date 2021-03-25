package com.sample_spring_api.demo.controller;

import com.sample_spring_api.demo.entity.CustomerEntity;
import com.sample_spring_api.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService theCustomerService){
        customerService = theCustomerService;
    }

    @GetMapping("/customer")
    public List<CustomerEntity> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/customer/{customerId}")
    public CustomerEntity getCustomer(@PathVariable int customerId){

        CustomerEntity theCustomer = customerService.findById(customerId);

        if(theCustomer == null){
            throw new RuntimeException("Customer id not found - " + customerId);
        }

        return theCustomer;
    }

    @PostMapping("/customer")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity theCustomer) {


        theCustomer.setId(0);

        customerService.save(theCustomer);

        return theCustomer;
    }

    @PutMapping("/customer")
    public CustomerEntity updateEmployee(@RequestBody CustomerEntity theCustomer){

        customerService.save(theCustomer);
        return theCustomer;
    }

    @DeleteMapping("/customer/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){

        CustomerEntity theCustomer = customerService.findById(customerId);

        if(theCustomer == null) {
            throw new RuntimeException("Customer id not found - " + customerId);
        }
        customerService.deleteById(customerId);
        return "Delete employee id - " + customerId;
    }



}