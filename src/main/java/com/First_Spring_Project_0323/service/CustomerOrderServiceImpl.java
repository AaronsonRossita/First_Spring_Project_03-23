package com.First_Spring_Project_0323.service;

import com.First_Spring_Project_0323.model.Customer;
import com.First_Spring_Project_0323.model.CustomerOrder;
import com.First_Spring_Project_0323.model.CustomerOrderRequest;
import com.First_Spring_Project_0323.model.CustomerOrderResponse;
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
    public CustomerOrderResponse createOrder(CustomerOrderRequest customerOrderRequest) {
        Customer customer = customerOrderRequest.getCustomer();
        CustomerOrder order = customerOrderRequest.getOrder();
        CustomerOrderResponse customerOrderResponse = null;
        if(customer.getId() != null && customerService.getCustomerById(customer.getId()) != null){
            order.setCustomerId(customer.getId());
            customerOrderRepository.createOrder(order);
            customerOrderResponse = new CustomerOrderResponse(
                    customerService.getCustomerById(customer.getId()),
                    customerOrderRepository.getCustomerOrdersByCustomerId(customer.getId())
            );
        }else{
            int result = customerService.createCustomer(customer);
            if(result == -1){
                System.out.println("customer was not created and the order was not created too");
            }else{
                order.setCustomerId(result);
                customerOrderRepository.createOrder(order);
                customerOrderResponse = new CustomerOrderResponse(
                        customerService.getCustomerById(result),
                        customerOrderRepository.getCustomerOrdersByCustomerId(result)
                );
            }
        }
        return customerOrderResponse;
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
