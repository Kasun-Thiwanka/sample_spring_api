package com.sample_spring_api.demo.repository;

import com.sample_spring_api.demo.entity.MerchantEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MerchantRepoImpl implements MerchantRepo{

    private EntityManager entityManager;

    public MerchantRepoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<MerchantEntity> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<MerchantEntity> theQuery = currentSession.createQuery("from MerchantEntity", MerchantEntity.class);
        List<MerchantEntity> merchants = theQuery.getResultList();
        return merchants;
    }

    @Override
    public MerchantEntity findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        MerchantEntity theMerchant = currentSession.get(MerchantEntity.class, theId);
        return theMerchant;
    }

    @Override
    public void save(MerchantEntity theMerchant) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theMerchant);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from MerchantEntity where id=:merchantId");
        theQuery.setParameter("merchantId", theId);
        theQuery.executeUpdate();
    }
}
