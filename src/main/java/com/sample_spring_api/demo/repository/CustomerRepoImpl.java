package com.sample_spring_api.demo.repository;

import com.sample_spring_api.demo.entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerRepoImpl implements CustomerRepo{

    private EntityManager entityManager;

    @Autowired
    public CustomerRepoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<CustomerEntity> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<CustomerEntity> theQuery = currentSession.createQuery("from CustomerEntity", CustomerEntity.class);
        List<CustomerEntity> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    public CustomerEntity findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        CustomerEntity theCustomer = currentSession.get(CustomerEntity.class, theId);
        return theCustomer;
    }

    @Override
    public void save(CustomerEntity theCustomer) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from CustomerEntity where id=:customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();
    }
}
