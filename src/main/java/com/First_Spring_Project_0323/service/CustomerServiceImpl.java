package com.First_Spring_Project_0323.service;

import com.First_Spring_Project_0323.model.Customer;
import com.First_Spring_Project_0323.model.CustomerStatus;
import com.First_Spring_Project_0323.repository.CustomerRepositoryImpl;
import com.First_Spring_Project_0323.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepositoryImpl customerRepository;

    @Override
    public Integer createCustomer(Customer customer) {
        if(customer.getFirstName() != null && customer.getLastName() != null && customer.getCustomerStatus() != null){
            if(customer.getCustomerStatus() == CustomerStatus.REGULAR){
                return customerRepository.createCustomer(customer);
            }else{
                Integer vipCustomersCreated = customerRepository.getCustomersByStatus(CustomerStatus.VIP).size();
                if(vipCustomersCreated < Constants.VIP_ALLOWED){
                    return customerRepository.createCustomer(customer);
                }else{
                    customer.setCustomerStatus(CustomerStatus.REGULAR);
                    return customerRepository.createCustomer(customer);
                }
            }
        }else{
            System.out.println("can't create customer without name and lastname");
            return -1;
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
    public void updateCustomerStatus(Integer id, CustomerStatus customerStatus) {
        if(customerStatus != CustomerStatus.VIP){
            customerRepository.updateCustomerStatus(id,customerStatus);
        }else{
            Integer countVipCustomers = customerRepository.getCustomersByStatus(CustomerStatus.VIP).size();
            if(countVipCustomers < Constants.VIP_ALLOWED){
                customerRepository.updateCustomerStatus(id,customerStatus);
            }else{
                System.out.println("No vip available, stay regular id = " + id);
            }
        }
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
