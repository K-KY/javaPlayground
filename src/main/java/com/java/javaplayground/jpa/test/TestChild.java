package com.java.javaplayground.jpa.test;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TestChild {

    public TestChild(String name, Test test) {
        this.name = name;
        this.test = test;
    }

    public TestChild() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Test test;

    @OneToMany
    private List<TestChild> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test getTest() {
        return test;
    }

    public List<TestChild> getChildren() {
        return children;
    }

    public void setChildren(List<TestChild> children) {
        this.children = children;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
