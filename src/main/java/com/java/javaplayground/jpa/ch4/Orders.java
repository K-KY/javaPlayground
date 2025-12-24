package com.java.javaplayground.jpa.ch4;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private long id;

    @Column(name = "member_id")
    private long memberId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public long getId() {
        return id;
    }

    public long getMemberId() {
        return memberId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
