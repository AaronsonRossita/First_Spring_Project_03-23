package com.First_Spring_Project_0323.repository;

import com.First_Spring_Project_0323.model.Customer;
import com.First_Spring_Project_0323.model.CustomerStatus;
import com.First_Spring_Project_0323.repository.cache.CacheRepository;
import com.First_Spring_Project_0323.repository.mapper.CustomerMapper;
import com.First_Spring_Project_0323.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    // update(), query(), queryForObject(), queryForList()

    @Autowired
    private CacheRepository cacheRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Integer createCustomer(Customer customer) {
//        System.out.println("Customer " + customer + " was created");
//        String sql = "INSERT INTO customer (first_name,last_name,email) VALUES ( '" + customer.getFirstName() + "','" + customer.getLastName() + "','" + customer.getEmail() + "')";
//        String sql = String.format("INSERT INTO customer (first_name,last_name,email) VALUES ( '%s','%s','%s')",customer.getFirstName(),customer.getLastName(),customer.getEmail());
//        String sql = Constants.insertInto(
//                Constants.CUSTOMER_TABLE_NAME,
//                new String[]{"first_name","last_name","email"},
//                new String[]{customer.getFirstName(),customer.getLastName(),customer.getEmail()});
//        jdbcTemplate.update(sql);
        String sql = "INSERT INTO "+ Constants.CUSTOMER_TABLE_NAME +" (first_name,last_name,email,customer_status) VALUES (?,?,?,?)";
        int result = jdbcTemplate.update(sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getCustomerStatus().toString());
        if(result == 1){
            sql = "SELECT max(id) FROM " + Constants.CUSTOMER_TABLE_NAME;
            return jdbcTemplate.queryForObject(sql,Integer.class);
        }else{
            return -1;
        }
    }

    @Override
    public void deleteCustomerById(Integer id) {
        System.out.println("Customer with id = " + id + " was deleted");
        String sql = "DELETE FROM "+ Constants.CUSTOMER_TABLE_NAME +" WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        System.out.println("Customer " + customer + " was updated");
        String sql;
        if(customer.getFirstName() != null && customer.getLastName() == null && customer.getEmail() == null){
            sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET first_name = ? WHERE id = ?";
            jdbcTemplate.update(sql,customer.getFirstName(),customer.getId());
        }else if (customer.getFirstName() == null && customer.getLastName() != null && customer.getEmail() == null){
            sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET last_name = ? WHERE id = ?";
            jdbcTemplate.update(sql,customer.getLastName(),customer.getId());
        }else if(customer.getFirstName() == null && customer.getLastName() == null && customer.getEmail() != null){
            sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET email = ? WHERE id = ?";
            jdbcTemplate.update(sql,customer.getEmail(),customer.getId());
        }else if(customer.getFirstName() != null && customer.getLastName() != null && customer.getEmail() == null){
            sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET first_name = ?,last_name = ? WHERE id = ?";
            jdbcTemplate.update(sql,customer.getFirstName(),customer.getLastName(),customer.getId());
        }else if(customer.getFirstName() != null && customer.getLastName() == null && customer.getEmail() != null){
            sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET first_name = ?,email = ? WHERE id = ?";
            jdbcTemplate.update(sql,customer.getFirstName(),customer.getEmail(),customer.getId());
        }else if(customer.getFirstName() == null && customer.getLastName() != null && customer.getEmail() != null){
            sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET last_name = ?, email = ? WHERE id = ?";
            jdbcTemplate.update(sql,customer.getLastName(),customer.getEmail(),customer.getId());
        }else{
            sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
            jdbcTemplate.update(sql,customer.getFirstName(),customer.getLastName(),customer.getEmail(),customer.getId());
        }
    }

    @Override
    public void updateCustomerFirstName(Integer id, String firstName) {
        String sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET first_name = ? WHERE id = ?";
        jdbcTemplate.update(sql,firstName,id);
    }

    @Override
    public void updateCustomerLastName(Integer id, String lastName) {
        String sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET last_name = ? WHERE id = ?";
        jdbcTemplate.update(sql,lastName,id);
    }

    @Override
    public void updateCustomerEmail(Integer id, String email) {
        String sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET email = ? WHERE id = ?";
        jdbcTemplate.update(sql,email,id);
    }

    @Override
    public void updateCustomerStatus(Integer id, CustomerStatus customerStatus) {
        String sql = "UPDATE "+ Constants.CUSTOMER_TABLE_NAME +" SET customer_status = ? WHERE id = ?";
        jdbcTemplate.update(sql,customerStatus.toString(),id);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        String sql = "SELECT * FROM "+ Constants.CUSTOMER_TABLE_NAME +" WHERE id = ?";
        try{
            if(cacheRepository.isKeyExist(id.toString())){
                System.out.println("got the customer with id " + id + " from cache");
                return objectMapper.readValue(cacheRepository.getCacheEntity(id.toString()), Customer.class);
            }else{
                System.out.println("got the customer with id " + id + " from db");
                Customer customer = jdbcTemplate.queryForObject(sql,new CustomerMapper(),id);
                cacheRepository.createCacheEntity(id.toString(),objectMapper.writeValueAsString(customer));
                return customer;
            }
        }catch(EmptyResultDataAccessException e){
            return null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM " + Constants.CUSTOMER_TABLE_NAME;
        return jdbcTemplate.query(sql,new CustomerMapper());
    }

    @Override
    public List<Integer> getAllCustomerIds() {
        String sql = "SELECT id FROM " + Constants.CUSTOMER_TABLE_NAME;
        return jdbcTemplate.queryForList(sql,Integer.class);
    }

    @Override
    public List<String> getAllCustomerEmails() {
        String sql = "SELECT email FROM " + Constants.CUSTOMER_TABLE_NAME;
        return jdbcTemplate.queryForList(sql,String.class);
    }

    @Override
    public List<Customer> getAllCustomersByName(String name) {
        String sql = "SELECT * FROM " + Constants.CUSTOMER_TABLE_NAME + " WHERE first_name = ?";
        return jdbcTemplate.query(sql,new CustomerMapper(),name);
    }

    @Override
    public List<Customer> getCustomersByStatus(CustomerStatus customerStatus) {
        String sql = "SELECT * FROM " + Constants.CUSTOMER_TABLE_NAME + " WHERE customer_status = ?";
        return jdbcTemplate.query(sql,new CustomerMapper(),customerStatus.toString());
    }



}
