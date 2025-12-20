package com.java.javaplayground.jpa.ch2.repository;


import com.java.javaplayground.jpa.ch2.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Integer> {
}
