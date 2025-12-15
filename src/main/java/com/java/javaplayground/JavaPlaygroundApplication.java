package com.java.javaplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JavaPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaPlaygroundApplication.class, args);
    }

}
