package com.java.javaplayground.jpa.ch2.service;

import com.java.javaplayground.jpa.ch2.entity.Sample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SampleServiceTest {

    @Autowired
    private SampleService sampleService;

    @Test
    void persistTest() {
        sampleService.save();
    }

    @Test
    void findTest() {
        Sample byId = sampleService.findById(1);
        assertThat(byId.getId()).isEqualTo(1);
    }
}