package com.stroganov.currencychecker.clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stroganov.currencychecker.models.OriginalGiphy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class GiphyClientTest {

    @Autowired
    private GiphyClient giphyClient;

    @Autowired
    private ObjectMapper mapper;

    @Value("${giphiservice.id}")
    private String giphyId;

    @Test
    void When_getGiphy_then_originalGiphy_getLink_startsWith_https() throws JsonProcessingException {
        //GIVEN
        String tag = "rich";
        //WHEN
        JsonNode node = giphyClient.getGiphy(giphyId, tag);
        JsonNode nodeOriginal = node.at("/data/images/original_mp4");
        OriginalGiphy originalGiphy = mapper.readValue(nodeOriginal.toString(), OriginalGiphy.class);
        //THEN
        Assertions.assertTrue(originalGiphy.getLink().startsWith("https"));
    }
}