package com.First_Spring_Project_0323.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerOrder {

    private Integer id;
    @JsonProperty("item_name")
    private String itemName;
    private Double price;
    @JsonProperty("customer_id")
    private Integer customerId;

    public CustomerOrder(Integer id, String itemName, Double price, Integer customerId) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
