package com.stroganov.currencychecker.service.impl;

import com.stroganov.currencychecker.clients.ExchangeRatesClient;
import com.stroganov.currencychecker.models.DalyRates;
import com.stroganov.currencychecker.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Value("${openexchangerates.id}")
    private String appId;

    @Value("${baseCurrency}")
    private String baseCurrency;

    ExchangeRatesClient exchangeRatesClient;

    @Autowired
    public CurrencyServiceImpl(ExchangeRatesClient exchangeRatesClient) {
        this.exchangeRatesClient = exchangeRatesClient;
    }

    @Override
    public String getExchangeRate(String currency) {
        DalyRates result = exchangeRatesClient.getExchangeRate(appId,baseCurrency);
        return result != null ? result.toString() : "null";
    }
}
