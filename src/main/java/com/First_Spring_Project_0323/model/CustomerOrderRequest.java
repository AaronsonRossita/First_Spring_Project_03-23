package com.First_Spring_Project_0323.model;

public class CustomerOrderRequest {

    private CustomerOrder order;
    private Customer customer;

    public CustomerOrderRequest(CustomerOrder order, Customer customer) {
        this.order = order;
        this.customer = customer;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
