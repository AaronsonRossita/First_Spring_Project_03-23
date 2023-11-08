package com.First_Spring_Project_0323.controller;

import com.First_Spring_Project_0323.model.Customer;
import com.First_Spring_Project_0323.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping(value = "/create")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @PutMapping(value = "/update_first_name")
    public void updateCustomerFirstName(@RequestParam Integer id,@RequestParam(value = "first_name") String firstName){
        customerService.updateCustomerFirstName(id,firstName);
    }
    @PutMapping(value = "/update_last_name")
    public void updateCustomerLastName(@RequestParam Integer id,@RequestParam(value = "last_name") String lastName){
        customerService.updateCustomerLastName(id,lastName);
    }
    @PutMapping(value = "/update_email")
    public void updateCustomerEmail(@RequestParam Integer id,@RequestParam String email){
        customerService.updateCustomerEmail(id,email);
    }

//    @DeleteMapping(value = "/delete/{id}")
//    public void deleteCustomer(@PathVariable Integer id){
//        // delete customer through repository
//    }

    @DeleteMapping(value = "/delete")
    public void deleteCustomerById(@RequestParam Integer id){
        customerService.deleteCustomerById(id);
    }

    @GetMapping(value = "/by_id")
    public Customer getCustomerById(@RequestParam Integer id){
        return customerService.getCustomerById(id);
    }

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/all_ids")
    public List<Integer> getAllCustomerIds(){
        return customerService.getAllCustomerIds();
    }

    @GetMapping(value = "/all_emails")
    public List<String> getAllCustomerEmails(){
        return customerService.getAllCustomerEmails();
    }

    @GetMapping(value = "/customers_by_name")
    public List<Customer> getAllCustomersByName(@RequestParam String name){
        return customerService.getAllCustomersByName(name);
    }

}
