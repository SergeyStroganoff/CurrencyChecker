package com.stroganov.currencychecker.controllers;

import com.stroganov.currencychecker.models.DalyRates;
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

    @Value("${baseCurrency}")
    private String baseCurrency;

    @Autowired
    CurrencyService currencyService;

    @GetMapping("fast-result")
    public ResponseEntity<?> getExchangeRate(@PathParam("currency") String currency) throws InterruptedException {
        DalyRates todayRates = currencyService.getLatestDailyRate(baseCurrency);
        DalyRates yesterdayRates = currencyService.getDayBeforeExchangeRate(baseCurrency);
        if (!todayRates.getRates().containsKey(currency)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        boolean isTodayCurrencyPriseHigherThenYesterday = Double.compare(todayRates.getRates().get(currency), yesterdayRates.getRates().get(currency)) > 1;
        if (isTodayCurrencyPriseHigherThenYesterday) {
            return ResponseEntity.ok("Yes, it is higher than yesterday");
        } else {
            return ResponseEntity.ok("No it is lower today");
        }
    }


}

