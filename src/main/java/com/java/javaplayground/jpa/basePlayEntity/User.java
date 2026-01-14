package com.java.javaplayground.jpa.basePlayEntity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    private String userName;
    private String userAge;
    private String userGender;

    private String userEmail;
    private String userAddress;

    //default eager
    @ManyToOne(fetch = FetchType.EAGER)
    private Group eagerGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group lazyGroup;
}
