package com.stroganov.currencychecker.service.impl;

import com.stroganov.currencychecker.models.OriginalGiphy;
import com.stroganov.currencychecker.service.GiphyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GiphyServiceImplTest {

    @Autowired
    GiphyService giphyService;

    @Test
    void When_getGiphyByTag_then_originalGiphy_getLink_startsWith_https() {
        //GIVEN
        String tag = "rich";
        //WHEN
        OriginalGiphy originalGiphy = giphyService.getGiphyByTag(tag);
        //THEN
        Assertions.assertTrue(originalGiphy.getLink().startsWith("https"));
    }
}