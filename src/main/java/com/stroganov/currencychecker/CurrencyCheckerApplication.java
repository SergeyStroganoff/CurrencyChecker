package com.stroganov.currencychecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class CurrencyCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyCheckerApplication.class, args);
    }

}
