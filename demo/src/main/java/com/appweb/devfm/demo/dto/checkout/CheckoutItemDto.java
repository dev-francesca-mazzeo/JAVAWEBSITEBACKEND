package com.appweb.devfm.demo.dto.checkout;

public class CheckoutItemDto {

    private String productName;
    private double price;
    private long productId;
    private int userId;

    public CheckoutItemDto() {}

    public CheckoutItemDto(String productName, double price, long productId, int userId) {
        this.productName = productName;
        this.price = price;
        this.productId = productId;
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(){return price;}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long id) {
        this.productId = id;
    }



}