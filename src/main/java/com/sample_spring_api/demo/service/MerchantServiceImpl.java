package com.sample_spring_api.demo.service;

import com.sample_spring_api.demo.entity.MerchantEntity;
import com.sample_spring_api.demo.repository.MerchantRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService{

    private MerchantRepo merchantRepo;

    public  MerchantServiceImpl(MerchantRepo theMerchantRepo){

        merchantRepo = theMerchantRepo;
    }

    @Override
    @Transactional
    public List<MerchantEntity> findAll() {
        return merchantRepo.findAll();
    }

    @Override
    @Transactional
    public MerchantEntity findById(int theId) {

        return merchantRepo.findById(theId);
    }

    @Override
    @Transactional
    public void save(MerchantEntity theMerchant) {

        merchantRepo.save(theMerchant);
    }

    @Override
    public void deleteById(int theId) {
        merchantRepo.deleteById(theId);
    }
}
