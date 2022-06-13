package com.stroganov.currencychecker.service.impl;

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
    private static final ObjectMapper mapper = new ObjectMapper();
    GiphyClient giphyClient;

    @Autowired
    public GiphyServiceImpl(GiphyClient giphyClient) {
        this.giphyClient = giphyClient;
    }

    @Value("${giphiservice.id}")
    private String giphyId;

    @Override
    public OriginalGiphy getGiphyByTag(String tag) {

        return null;
    }
}
