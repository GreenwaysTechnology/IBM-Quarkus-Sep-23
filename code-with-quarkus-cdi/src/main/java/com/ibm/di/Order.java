package com.ibm.di;

public class Order {
    private  int orderId;
    private  double orderValue;

    public Order() {
    }

    public Order(int orderId, double orderValue) {
        this.orderId = orderId;
        this.orderValue = orderValue;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }
}
