package com.sample_spring_api.demo.repository;

import com.sample_spring_api.demo.entity.PaymentEntity;

import java.util.List;

public interface PaymentRepo {

    public List<PaymentEntity> findAll();

    public PaymentEntity findById(int theId);

    public void save(PaymentEntity thePayment);
}
