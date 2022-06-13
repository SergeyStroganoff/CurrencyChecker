package com.stroganov.currencychecker.service.impl;

import com.stroganov.currencychecker.clients.ExchangeRatesClient;
import com.stroganov.currencychecker.models.DalyRates;
import com.stroganov.currencychecker.service.CurrencyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final Logger logger = LogManager.getLogger(CurrencyServiceImpl.class);
    private final ExchangeRatesClient exchangeRatesClient;
    @Value("${openexchangerates.id}")
    private String appId;

    @Autowired
    public CurrencyServiceImpl(ExchangeRatesClient exchangeRatesClient) {
        this.exchangeRatesClient = exchangeRatesClient;
    }

    @Override
    public DalyRates getLatestDailyRate(String currency) {
        return exchangeRatesClient.getLatestExchangeRate(appId, currency);
    }

    @Override
    public DalyRates getDayBeforeExchangeRate(String currency) {
        LocalDate yesterdayLocalDate = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String data = yesterdayLocalDate.format(formatter);
        logger.debug(data);
        return exchangeRatesClient.getHistoricalExchangeRate(data, appId, currency);
    }
}

