package com.ibm.quarkus.data.activerecord.entity;


import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

//Active Record Pattern
@Entity
public class Customer extends PanacheEntity {
    @Column
    public String name;
    @Column
    public String city;

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Customer() {
    }
}
