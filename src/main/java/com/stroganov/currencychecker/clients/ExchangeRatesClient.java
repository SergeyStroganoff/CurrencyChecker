package com.stroganov.currencychecker.clients;

import com.stroganov.currencychecker.configurations.ClientConfiguration;
import com.stroganov.currencychecker.models.DalyRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "openexchanger", url = "https://openexchangerates.org/api/",
        configuration = ClientConfiguration.class)
public interface ExchangeRatesClient {

    @GetMapping("/latest.json?app_id={app_id}&base={base}")
    DalyRates getLatestExchangeRate(@PathVariable("app_id") String appId, @PathVariable("base") String base);

    @GetMapping("historical/{data}.json?app_id={app_id}&base={base}")
    DalyRates getHistoricalExchangeRate(@PathVariable("data") String data, @PathVariable("app_id") String appId, @PathVariable("base") String base);
}
