package com.First_Spring_Project_0323.repository.mapper;

import com.First_Spring_Project_0323.model.CustomerOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerOrderMapper implements RowMapper<CustomerOrder> {
    @Override
    public CustomerOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerOrder(
                rs.getInt("id"),
                rs.getString("item_name"),
                rs.getDouble("price"),
                rs.getInt("customer_id")
        );
    }

}
