package com.First_Spring_Project_0323.repository;

import com.First_Spring_Project_0323.model.CustomerOrder;
import com.First_Spring_Project_0323.repository.mapper.CustomerOrderMapper;
import com.First_Spring_Project_0323.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createOrder(CustomerOrder customerOrder) {
        String sql = "INSERT INTO " + Constants.ORDER_TABLE_NAME + " (item_name,price,customer_id) VALUES (?,?,?)";
        jdbcTemplate.update(sql,customerOrder.getItemName(),customerOrder.getPrice(),customerOrder.getCustomerId());
    }

    @Override
    public void updateOrder(CustomerOrder customerOrder) {
        String sql = "UPDATE " + Constants.ORDER_TABLE_NAME + " SET item_name = ?, price = ?, customer_id = ?  WHERE id = ?";
        jdbcTemplate.update(sql,customerOrder.getItemName(),customerOrder.getPrice(),customerOrder.getCustomerId(),customerOrder.getId());
    }

    @Override
    public void deleteOrder(Integer id) {
        String sql = "DELETE FROM " + Constants.ORDER_TABLE_NAME + " WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Integer id) {
        String sql = "SELECT * FROM " + Constants.ORDER_TABLE_NAME + " WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new CustomerOrderMapper(),id);
    }

    @Override
    public List<CustomerOrder> getCustomerOrdersByCustomerId(Integer customerId) {
        String sql = "SELECT * FROM " + Constants.ORDER_TABLE_NAME + " WHERE customer_id = ?";
        return jdbcTemplate.query(sql,new CustomerOrderMapper(),customerId);
    }
}
