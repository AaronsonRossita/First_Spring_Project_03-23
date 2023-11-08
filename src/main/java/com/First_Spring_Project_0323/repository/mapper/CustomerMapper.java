package com.First_Spring_Project_0323.repository.mapper;

import com.First_Spring_Project_0323.model.Customer;
import com.First_Spring_Project_0323.model.CustomerStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerMapper implements RowMapper<Customer> {

//    @Override
//    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Customer customer = new Customer(
//                rs.getInt("id"),
//                rs.getString("first_name"),
//                rs.getString("last_name"),
//                rs.getString("email")
//        );
//        return customer;
//    }
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                CustomerStatus.valueOf(rs.getString("customer_status"))
        );
    }
}
