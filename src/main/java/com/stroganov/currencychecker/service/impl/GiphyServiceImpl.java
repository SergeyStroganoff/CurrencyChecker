package com.stroganov.currencychecker.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stroganov.currencychecker.clients.GiphyClient;
import com.stroganov.currencychecker.models.OriginalGiphy;
import com.stroganov.currencychecker.service.GiphyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GiphyServiceImpl implements GiphyService {
    private final Logger logger = LogManager.getLogger(GiphyServiceImpl.class);
    private final ObjectMapper mapper;
    private final GiphyClient giphyClient;

    @Autowired
    public GiphyServiceImpl(ObjectMapper mapper, GiphyClient giphyClient) {
        this.mapper = mapper;
        this.giphyClient = giphyClient;
    }

    @Value("${giphiservice.id}")
    private String giphyId;

    @Override
    public OriginalGiphy getGiphyByTag(String tag) {
        JsonNode node = giphyClient.getGiphy(giphyId, tag);
        JsonNode nodeOriginal = node.at("/data/images/original_mp4");
        OriginalGiphy originalGiphy = null;
        try {
            originalGiphy = mapper.readValue(nodeOriginal.toString(), OriginalGiphy.class);
        } catch (JsonProcessingException e) {
            logger.error(e);
        }
        return originalGiphy;
    }
}
