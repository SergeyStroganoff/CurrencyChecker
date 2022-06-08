package com.stroganov.currencychecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableFeignClients
@PropertySource("classpath:config.properties")
public class CurrencyCheckerApplication {

    static String message;

    public static void main(String[] args) {
        SpringApplication.run(CurrencyCheckerApplication.class, args);
    }

}
