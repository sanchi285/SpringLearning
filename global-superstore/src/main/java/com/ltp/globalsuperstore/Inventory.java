package com.ltp.globalsuperstore;

public class Inventory {

    private String category;
    private String productName;
    private String price;
    private String discount;
    private String orderDate;

    public Inventory() {
    }

    public Inventory(String category, String productName, String price, String discount, String orderDate) {
        this.category = category;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.orderDate = orderDate;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return this.discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


    
}
