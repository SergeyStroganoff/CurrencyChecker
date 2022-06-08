package com.stroganov.currencychecker.service.impl;

import com.stroganov.currencychecker.clients.ExchangeRatesClient;
import com.stroganov.currencychecker.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Value("${openexchangerates.id}")
    private String appId;

    ExchangeRatesClient exchangeRatesClient;

    @Autowired
    public CurrencyServiceImpl(ExchangeRatesClient exchangeRatesClient) {
        this.exchangeRatesClient = exchangeRatesClient;
    }

    @Override
    public String getExchangeRate(String currency) {
        String result = exchangeRatesClient.getExchangeRate(appId);
        return result != null ? result : "null";
    }
}
