package com.springdata.mappings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MappingsApplication {

    public static void main(String[] args) {

        SpringApplication.run(MappingsApplication.class, args);
        System.out.println("Spring Data JPA Mapping Running....");
    }

}
