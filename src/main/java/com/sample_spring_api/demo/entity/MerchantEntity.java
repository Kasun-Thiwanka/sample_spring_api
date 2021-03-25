package com.sample_spring_api.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="merchant")
public class MerchantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="merchant_name")
    private String merchantName;

    @Column(name="merchant_address")
    private String merchantAddress;

    @Column(name="merchant_type")
    private String merchantType;

    public MerchantEntity() {

    }

    public MerchantEntity(String merchantName, String merchantAddress, String merchantType) {
        this.merchantName = merchantName;
        this.merchantAddress = merchantAddress;
        this.merchantType = merchantType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    @Override
    public String toString() {
        return "MerchantEntity{" +
                "id=" + id +
                ", merchantName='" + merchantName + '\'' +
                ", merchantAddress='" + merchantAddress + '\'' +
                ", merchantType='" + merchantType + '\'' +
                '}';
    }
}
