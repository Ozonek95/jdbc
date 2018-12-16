package com.shop.domain;

import javax.persistence.*;

@Entity
@Table
public class Price {
    @Id
    @GeneratedValue
    @Column(name = "price_id")
    private int priceId;
    private float value;
    private String currency;

    public Price(float value, String currency) {
        this.value = value;
        this.currency = currency;
    }
    private Price(){}

    @Override
    public String toString() {
        return "Price{" +
                "priceId=" + priceId +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
