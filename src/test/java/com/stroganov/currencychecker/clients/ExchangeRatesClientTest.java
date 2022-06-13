package com.stroganov.currencychecker.clients;

import com.stroganov.currencychecker.models.DalyRates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(SpringExtension.class)
class ExchangeRatesClientTest {

    @Autowired
    private ExchangeRatesClient exchangeRatesClient;
    @Value("${openexchangerates.id}")
    private String appId;

    @Value("${baseCurrency}")
    private String currency;

    @Test
    void When_LatestExchangeRate_Then_Given_DalyRates_withActualData() {
        //GIVEN
        DalyRates dalyRates = exchangeRatesClient.getLatestExchangeRate(appId, currency.toUpperCase());
        //THEN
        Date date = new Date(dalyRates.getTimestamp());
        Assertions.assertNotNull(dalyRates);
        Assertions.assertEquals(date.getTime(), dalyRates.getTimestamp());
    }

    @Test
    void When_getHistoricalExchangeRates_Then_currency_is_equal_responseCurrency() {
        //GIVEN
        LocalDate yesterdayLocalDate = LocalDate.now().minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String data = yesterdayLocalDate.format(formatter);
        //WHEN
        DalyRates dalyRates = exchangeRatesClient.getHistoricalExchangeRate(data, appId, currency.toUpperCase());
        //THEN
        Assertions.assertEquals(currency.toUpperCase(), dalyRates.getBase());
    }
}