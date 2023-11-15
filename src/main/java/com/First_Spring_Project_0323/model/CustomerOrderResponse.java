package com.First_Spring_Project_0323.model;

import java.util.List;

public class CustomerOrderResponse {

    private Customer customer;
    private List<CustomerOrder> orders;

    public CustomerOrderResponse(Customer customer, List<CustomerOrder> orders) {
        this.customer = customer;
        this.orders = orders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }
}
