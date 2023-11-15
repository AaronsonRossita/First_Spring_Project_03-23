package com.First_Spring_Project_0323.service;

import com.First_Spring_Project_0323.model.CustomerOrder;
import com.First_Spring_Project_0323.model.CustomerOrderRequest;
import com.First_Spring_Project_0323.model.CustomerOrderResponse;

public interface CustomerOrderService {

    CustomerOrderResponse createOrder(CustomerOrderRequest customerOrderRequest);
    void updateOrder(CustomerOrder customerOrder);
    void deleteOrder(Integer id);

    CustomerOrder getCustomerOrderById(Integer id);
}
