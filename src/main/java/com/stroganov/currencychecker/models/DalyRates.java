package com.stroganov.currencychecker.models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DalyRates {
    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String, Double> rates = new HashMap<>();
}
