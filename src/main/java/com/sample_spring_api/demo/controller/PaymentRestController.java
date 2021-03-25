package com.sample_spring_api.demo.controller;

import com.sample_spring_api.demo.entity.MerchantEntity;
import com.sample_spring_api.demo.entity.PaymentEntity;
import com.sample_spring_api.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentRestController {

    private PaymentService paymentService;

    @Autowired
    public PaymentRestController(PaymentService thePaymentService){

        paymentService = thePaymentService;
    }

    @GetMapping("/payment")
    public List<PaymentEntity> findAll(){

        return paymentService.findAll();
    }

    @GetMapping("/payment/{paymentId}")
    public PaymentEntity getMerchant(@PathVariable int paymentId){

        PaymentEntity thePayment = paymentService.findById(paymentId);

        if(thePayment == null){
            throw new RuntimeException("Payment id not found - " + paymentId);
        }

        return thePayment;
    }

    @PostMapping("/payment")
    public PaymentEntity addPayment(@RequestBody PaymentEntity thePayment) {


        thePayment.setId(0);

        paymentService.save(thePayment);

        return thePayment;
    }



}
