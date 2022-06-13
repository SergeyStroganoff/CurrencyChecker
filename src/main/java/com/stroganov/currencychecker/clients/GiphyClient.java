package com.stroganov.currencychecker.clients;

import com.fasterxml.jackson.databind.JsonNode;
import com.stroganov.currencychecker.configurations.ClientConfiguration;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//  https://api.giphy.com/v1/gifs/random?api_key=cAMTs3jGG7552mMJz9LevmywAyyJor0Z&tag=rich&rating=g
@FeignClient(value = "CurrencyChecker", url = "https://api.giphy.com/v1/gifs",
        configuration = ClientConfiguration.class)
public interface GiphyClient {
    @GetMapping("/random?api_key={giphy_id}&tag={search_tag}&rating=g")
    @Headers("Content-Type: application/json")
    JsonNode getGiphy(@PathVariable("giphy_id") String appId, @PathVariable("search_tag") String base);
}
