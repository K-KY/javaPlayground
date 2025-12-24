package com.java.javaplayground.jpa.ch4;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private long id;

    private long itemId;
    private long orderId;

    private int orderPrice;
    private int count;

    public long getId() {
        return id;
    }

    public long getItemId() {
        return itemId;
    }

    public long getOrderId() {
        return orderId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getCount() {
        return count;
    }
}
