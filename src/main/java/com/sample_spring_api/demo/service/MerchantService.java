package com.sample_spring_api.demo.service;

import com.sample_spring_api.demo.entity.MerchantEntity;

import java.util.List;

public interface MerchantService {

    public List<MerchantEntity> findAll();

    public MerchantEntity findById(int theId);

    public void save(MerchantEntity theMerchant);

    public void deleteById(int theId);
}
