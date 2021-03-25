package com.sample_spring_api.demo.entity;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="payment_value")
    private int paymentValue;

    @Column(name="payment_type")
    private String paymentType;

    public PaymentEntity (){

    }

    public PaymentEntity(int paymentValue, String paymentType) {
        this.paymentValue = paymentValue;
        this.paymentType = paymentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(int paymentValue) {
        this.paymentValue = paymentValue;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", paymentValue=" + paymentValue +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
