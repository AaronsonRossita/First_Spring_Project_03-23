package com.First_Spring_Project_0323.repository;

import com.First_Spring_Project_0323.model.CustomerOrder;

public interface CustomerOrderRepository {

    void createOrder(CustomerOrder customerOrder);
    void updateOrder(CustomerOrder customerOrder);
    void deleteOrder(Integer id);

    CustomerOrder getCustomerOrderById(Integer id);

}
