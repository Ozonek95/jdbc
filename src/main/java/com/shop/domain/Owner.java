package com.shop.domain;

import javax.persistence.*;

@Entity
@Table
public class Owner {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    public Owner(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    private Owner() {}

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
