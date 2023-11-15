package com.First_Spring_Project_0323.repository;

import com.First_Spring_Project_0323.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderRepository {

    void createOrder(CustomerOrder customerOrder);
    void updateOrder(CustomerOrder customerOrder);
    void deleteOrder(Integer id);

    CustomerOrder getCustomerOrderById(Integer id);
    List<CustomerOrder> getCustomerOrdersByCustomerId(Integer customerId);

}
