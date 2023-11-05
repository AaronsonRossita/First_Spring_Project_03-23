package com.First_Spring_Project_0323.controller;

import com.First_Spring_Project_0323.model.Customer;
import com.First_Spring_Project_0323.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(value = "/create")
    public void createCustomer(@RequestBody Customer customer){
        customerRepository.createCustomer(customer);
    }

    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerRepository.updateCustomer(customer);
    }

    @PutMapping(value = "/update_first_name")
    public void updateCustomerFirstName(@RequestParam Integer id,@RequestParam(value = "first_name") String firstName){
        customerRepository.updateCustomerFirstName(id,firstName);
    }
    @PutMapping(value = "/update_last_name")
    public void updateCustomerLastName(@RequestParam Integer id,@RequestParam(value = "last_name") String lastname){
        customerRepository.updateCustomerLastName(id,lastname);
    }
    @PutMapping(value = "/update_email")
    public void updateCustomerEmail(@RequestParam Integer id,@RequestParam String email){
        customerRepository.updateCustomerEmail(id,email);
    }

//    @DeleteMapping(value = "/delete/{id}")
//    public void deleteCustomer(@PathVariable Integer id){
//        // delete customer through repository
//    }

    @DeleteMapping(value = "/delete")
    public void deleteCustomerById(@RequestParam Integer id){
        customerRepository.deleteCustomerById(id);
    }

    @GetMapping(value = "/by_id")
    public Customer getCustomerById(@RequestParam Integer id){
        return customerRepository.getCustomerById(id);
    }

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    @GetMapping(value = "/all_ids")
    public List<Integer> getAllCustomerIds(){
        return customerRepository.getAllCustomerIds();
    }

    @GetMapping(value = "/all_emails")
    public List<String> getAllCustomerEmails(){
        return customerRepository.getAllCustomerEmails();
    }

}
