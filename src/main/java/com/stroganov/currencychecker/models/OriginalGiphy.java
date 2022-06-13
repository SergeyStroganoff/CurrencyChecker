package com.stroganov.currencychecker.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OriginalGiphy {
    private String height;
    private String link;
    private String size;
    private String width;

    @JsonCreator
    public OriginalGiphy(@JsonProperty("height") String height, @JsonProperty("mp4") String link,
                         @JsonProperty("mp4_size") String size, @JsonProperty("width") String width) {
        this.height = height;
        this.link = link;
        this.size = size;
        this.width = width;
    }
}
