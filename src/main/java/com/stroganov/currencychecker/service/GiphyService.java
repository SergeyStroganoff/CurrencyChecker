package com.stroganov.currencychecker.service;

import com.stroganov.currencychecker.models.OriginalGiphy;

public interface GiphyService {
    OriginalGiphy getGiphyByTag(String tag);
}
