package com.raduq.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Raduq on 04/07/2016.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "com.raduq.shopping")
@ComponentScan
public class ShoppingCartApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartApplication.class, args);
    }
}
