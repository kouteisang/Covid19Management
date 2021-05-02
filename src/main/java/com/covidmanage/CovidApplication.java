package com.covidmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

//@EnableCaching  // 开启Spring Redis Cache，使用注解驱动缓存机制
@SpringBootApplication
@ComponentScan(basePackages = {"com.covidmanage.*"})
public class CovidApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidApplication.class, args);
    }

}
