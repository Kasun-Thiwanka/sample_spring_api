package com.sample_spring_api.demo.service;

import com.sample_spring_api.demo.entity.PaymentEntity;
import com.sample_spring_api.demo.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentRepo paymentRepo;

    @Autowired
    public PaymentServiceImpl(PaymentRepo thePaymentRepo){
        paymentRepo = thePaymentRepo;
    }

    @Override
    @Transactional
    public List<PaymentEntity> findAll() {
        return paymentRepo.findAll();
    }

    @Override
    @Transactional
    public PaymentEntity findById(int theId) {
        return paymentRepo.findById(theId);
    }

    @Override
    public void save(PaymentEntity thePayment) {
        paymentRepo.save(thePayment);
    }
}
