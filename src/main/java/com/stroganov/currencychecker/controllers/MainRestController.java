package com.stroganov.currencychecker.controllers;

import com.stroganov.currencychecker.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange-rates/dynamics/")
public class MainRestController {

    @Value("${exception.feignException.message}")
    private String message;

    @Autowired
    CurrencyService currencyService;

    @GetMapping("fast-result")
    public ResponseEntity<String> getExchangeRate(@PathParam("currency") String currency) {
        if (currency != null) {
            return ResponseEntity.ok(currencyService.getExchangeRate(currency));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(message);
    }

}

