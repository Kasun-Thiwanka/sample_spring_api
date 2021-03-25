package com.sample_spring_api.demo.controller;

import com.sample_spring_api.demo.entity.CustomerEntity;
import com.sample_spring_api.demo.entity.MerchantEntity;
import com.sample_spring_api.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MerchantRestController {

    private MerchantService merchantService;

    @Autowired
    public MerchantRestController(MerchantService theMerchantService){

        merchantService = theMerchantService;
    }

    @GetMapping("/merchant")
    public List<MerchantEntity> findAll(){

        return merchantService.findAll();
    }

    @GetMapping("/merchant/{merchantId}")
    public MerchantEntity getMerchant(@PathVariable int merchantId){

        MerchantEntity theMerchant = merchantService.findById(merchantId);

        if(theMerchant == null){
            throw new RuntimeException("Customer id not found - " + merchantId);
        }

        return theMerchant;
    }

    @PostMapping("/merchant")
    public MerchantEntity addCustomer(@RequestBody MerchantEntity theMerchant) {


        theMerchant.setId(0);

        merchantService.save(theMerchant);

        return theMerchant;
    }

    @PutMapping("/merchant")
    public MerchantEntity updateMerchant(@RequestBody MerchantEntity theMerchant){

        merchantService.save(theMerchant);
        return theMerchant;
    }

    @DeleteMapping("/merchant/{merchantId}")
    public String deleteCustomer(@PathVariable int merchantId){

        MerchantEntity theMerchant = merchantService.findById(merchantId);

        if(theMerchant == null) {
            throw new RuntimeException("Customer id not found - " + merchantId);
        }
        merchantService.deleteById(merchantId);
        return "Delete employee id - " + merchantId;
    }

}
