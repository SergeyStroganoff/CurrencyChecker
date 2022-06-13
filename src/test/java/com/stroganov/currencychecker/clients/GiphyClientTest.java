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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(SpringExtension.class)
class GiphyClientTest {

    @Autowired
    GiphyClient giphyClient;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Value("${giphiservice.id}")
    private String giphyId;

    @Test
    void getGiphy() throws JsonProcessingException {
        //GIVEN
        String tag = "rich";
        //WHEN
        JsonNode node = giphyClient.getGiphy(giphyId, tag);
        JsonNode nodeData = node.get("data");
        JsonNode nodeImages = nodeData.get("images");
        JsonNode nodeOriginal = nodeImages.get("original_mp4");
        OriginalGiphy originalGiphy = mapper.readValue(nodeOriginal.toString(), OriginalGiphy.class);
        Assertions.assertTrue(originalGiphy.getLink().startsWith("https"));
    }
}