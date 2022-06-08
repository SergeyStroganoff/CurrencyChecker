package com.stroganov.currencychecker.clients;

import com.stroganov.currencychecker.configurations.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "openexchanger", url = "https://openexchangerates.org/api/",
        configuration = ClientConfiguration.class)
public interface ExchangeRatesClient {

    @GetMapping(value = "/latest.json?app_id={appId}")
    String getExchangeRate(@PathVariable("appId") String appId);

    @GetMapping
    String getTestString();
}
