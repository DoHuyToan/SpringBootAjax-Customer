package com.example.springbootajaxcustomer.model;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "provinces_id")
    private Provinces provinces;

    public Customer() {
    }
    public Customer(String name, String phone, Provinces provinces) {
        this.name = name;
        this.phone = phone;
        this.provinces = provinces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Provinces getProvinces() {
        return provinces;
    }

    public void setProvinces(Provinces provinces) {
        this.provinces = provinces;
    }
}
