package com.stroganov.currencychecker.clients;

import com.stroganov.currencychecker.configurations.ClientConfiguration;
import com.stroganov.currencychecker.models.DalyRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

@FeignClient(value = "openexchanger", url = "https://openexchangerates.org/api/",
        configuration = ClientConfiguration.class)
public interface ExchangeRatesClient {


    @GetMapping("/latest.json?app_id={app_id}&base={base}")
    DalyRates getExchangeRate(@PathVariable("app_id") String app_id, @PathVariable("base") String base );
    //@PathParam("base") String baseCurrency

}
