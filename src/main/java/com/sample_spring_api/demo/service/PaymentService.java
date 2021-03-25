package com.sample_spring_api.demo.service;

import com.sample_spring_api.demo.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    public List<PaymentEntity> findAll();

    public PaymentEntity findById(int theId);

    public void save(PaymentEntity thePayment);
}
