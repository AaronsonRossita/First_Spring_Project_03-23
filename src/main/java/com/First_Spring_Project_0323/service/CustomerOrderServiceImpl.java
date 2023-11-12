package com.First_Spring_Project_0323.service;

import com.First_Spring_Project_0323.model.Customer;
import com.First_Spring_Project_0323.model.CustomerOrder;
import com.First_Spring_Project_0323.model.CustomerOrderRequest;
import com.First_Spring_Project_0323.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private CustomerService customerService;


    @Override
    public void createOrder(CustomerOrderRequest customerOrderRequest) {
        Customer customer = customerOrderRequest.getCustomer();
        CustomerOrder customerOrder = customerOrderRequest.getOrder();
        if(customerService.getCustomerById(customer.getId()) != null){
            customerOrder.setCustomerId(customer.getId());
            customerOrderRepository.createOrder(customerOrder);
        }else{
            customerService.createCustomer(customer);

        }
    }

    @Override
    public void updateOrder(CustomerOrder customerOrder) {
        customerOrderRepository.updateOrder(customerOrder);
    }

    @Override
    public void deleteOrder(Integer id) {
        customerOrderRepository.deleteOrder(id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Integer id) {
        return customerOrderRepository.getCustomerOrderById(id);
    }
}
