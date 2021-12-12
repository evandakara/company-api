package com.evan.learning.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CompanyApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyApiApplication.class, args);
    }


}
