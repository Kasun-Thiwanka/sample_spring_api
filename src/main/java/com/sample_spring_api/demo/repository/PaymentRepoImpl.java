package com.sample_spring_api.demo.repository;

import com.sample_spring_api.demo.entity.PaymentEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PaymentRepoImpl implements PaymentRepo{

    private EntityManager entityManager;

    public PaymentRepoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<PaymentEntity> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<PaymentEntity> theQuery = currentSession.createQuery("from PaymentEntity", PaymentEntity.class);
        List<PaymentEntity> payments = theQuery.getResultList();
        return payments;
    }

    @Override
    public PaymentEntity findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        PaymentEntity thePayment = currentSession.get(PaymentEntity.class, theId);
        return thePayment;
    }

    @Override
    public void save(PaymentEntity thePayment) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(thePayment);
    }


}
