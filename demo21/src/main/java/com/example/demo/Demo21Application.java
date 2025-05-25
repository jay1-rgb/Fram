package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.example.demo.Entity")
@SpringBootApplication
@EnableJpaRepositories("com.example.demo.repository")
@MapperScan("com.example.demo.Mapper")
public class Demo21Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo21Application.class, args);
    }

}
