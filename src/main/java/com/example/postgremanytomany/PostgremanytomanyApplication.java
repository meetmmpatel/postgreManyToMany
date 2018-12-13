package com.example.postgremanytomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PostgremanytomanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgremanytomanyApplication.class, args);
    }

}

