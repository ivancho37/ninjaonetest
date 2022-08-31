package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CustomerDevice {

    @Id
    private String id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Device device;

    private Integer quantity;

    public CustomerDevice() {
    }

    public CustomerDevice(String id, Customer customer, Device device, Integer quantity) {
        this.id = id;
        this.customer = customer;
        this.device = device;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Device getDevice() {
        return device;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
