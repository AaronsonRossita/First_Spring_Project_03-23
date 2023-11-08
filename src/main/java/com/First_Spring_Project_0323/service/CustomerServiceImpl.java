package com.First_Spring_Project_0323.service;

import com.First_Spring_Project_0323.model.Customer;
import com.First_Spring_Project_0323.model.CustomerStatus;
import com.First_Spring_Project_0323.repository.CustomerRepositoryImpl;
import com.First_Spring_Project_0323.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepositoryImpl customerRepository;

    @Override
    public void createCustomer(Customer customer) {
        if(customer.getCustomerStatus() == CustomerStatus.REGULAR){
            customerRepository.createCustomer(customer);
        }else{
            Integer vipCustomersCreated = customerRepository.getCustomersByStatus(CustomerStatus.VIP).size();
            if(vipCustomersCreated < Constants.VIP_ALLOWED){
                customerRepository.createCustomer(customer);
            }else{
                System.out.println("can not create customer");
            }
        }
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public void updateCustomerFirstName(Integer id, String firstName) {
        customerRepository.updateCustomerFirstName(id,firstName);
    }

    @Override
    public void updateCustomerLastName(Integer id, String lastName) {
        customerRepository.updateCustomerLastName(id,lastName);
    }

    @Override
    public void updateCustomerEmail(Integer id, String email) {
        customerRepository.updateCustomerEmail(id,email);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public List<Integer> getAllCustomerIds() {
        return customerRepository.getAllCustomerIds();
    }

    @Override
    public List<String> getAllCustomerEmails() {
        return customerRepository.getAllCustomerEmails();
    }

    @Override
    public List<Customer> getAllCustomersByName(String name) {
        return customerRepository.getAllCustomersByName(name);
    }
}
