package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

// This is a POJO ("Plain Old Java Object")
@Entity
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roast;
    private String origin;
    private String brand;

    @ManyToOne
    private Supplier supplier;

    @ManyToMany(mappedBy = "coffeeList")
    private List<Customer> customers;

    public Coffee() {
    }
    public Coffee(String brand) {
        this.brand = brand;
    }

    public Coffee(String roast, String brand) {
        this.roast = roast;
        this.origin = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    // GETTER
    public String getBrand() {
        return brand;
    }
    // SETTER
    public void setBrand(String brand) {
        this.brand = brand;
    }


} // End of Coffee
