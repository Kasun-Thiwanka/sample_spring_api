package com.sample_spring_api.demo.repository;

import com.sample_spring_api.demo.entity.MerchantEntity;

import java.util.List;

public interface MerchantRepo {

    public List<MerchantEntity> findAll();

    public MerchantEntity findById(int theId);

   public void save(MerchantEntity theMerchant);

    public void deleteById(int merchantId);
}
