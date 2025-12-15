package com.java.javaplayground.jpa.ch1.service;

import com.java.javaplayground.jpa.ch1.entity.Sample;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleService {
    private final EntityManager entityManager;

    public SampleService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save() {
        Sample sample = new Sample("saved" + (int)(Math.random() * 100), 100, "M");
        entityManager.persist(sample);
    }

    public Sample findById(long id) {
        return entityManager.find(Sample.class, id);
    }

}


