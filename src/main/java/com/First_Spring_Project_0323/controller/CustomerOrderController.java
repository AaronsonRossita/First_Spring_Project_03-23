package com.First_Spring_Project_0323.controller;

import com.First_Spring_Project_0323.model.CustomerOrder;
import com.First_Spring_Project_0323.model.CustomerOrderRequest;
import com.First_Spring_Project_0323.model.CustomerOrderResponse;
import com.First_Spring_Project_0323.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping
    public CustomerOrderResponse createOrder(@RequestBody CustomerOrderRequest customerOrderRequest){
        return customerOrderService.createOrder(customerOrderRequest);
    }
    @PutMapping
    public void updateOrder(@RequestBody CustomerOrder customerOrder){
        customerOrderService.updateOrder(customerOrder);
    }
    @DeleteMapping(value = "/delete")
    public void deleteOrder(@RequestParam Integer id){
        customerOrderService.deleteOrder(id);
    }

    @GetMapping(value = "/by_id")
    public CustomerOrder getCustomerOrderById(@RequestParam Integer id){
        return customerOrderService.getCustomerOrderById(id);
    }
}
