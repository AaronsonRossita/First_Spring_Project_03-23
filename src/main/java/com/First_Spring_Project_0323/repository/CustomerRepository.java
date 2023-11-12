package com.First_Spring_Project_0323.repository;

import com.First_Spring_Project_0323.model.Customer;
import com.First_Spring_Project_0323.model.CustomerStatus;

import java.util.List;

public interface CustomerRepository {

    void createCustomer(Customer customer);
    void deleteCustomerById(Integer id);
    void updateCustomer(Customer customer);
    void updateCustomerFirstName(Integer id, String firstName);
    void updateCustomerLastName(Integer id, String lastName);
    void updateCustomerEmail(Integer id, String email);
    void updateCustomerStatus(Integer id, CustomerStatus customerStatus);

    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomers();
    List<Integer> getAllCustomerIds();
    List<String> getAllCustomerEmails();
    List<Customer> getAllCustomersByName(String name);

    List<Customer> getCustomersByStatus(CustomerStatus customerStatus);

}
