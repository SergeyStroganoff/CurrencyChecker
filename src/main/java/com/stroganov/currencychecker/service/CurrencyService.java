package com.stroganov.currencychecker.service;

import com.stroganov.currencychecker.models.DalyRates;

public interface CurrencyService {
    DalyRates getLatestDailyRate(String currency);

    DalyRates getDayBeforeExchangeRate(String currency);
}
