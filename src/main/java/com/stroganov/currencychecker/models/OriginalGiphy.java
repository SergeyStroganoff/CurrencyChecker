package com.stroganov.currencychecker.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OriginalGiphy {
    private String height;
    @JsonAlias({"mp4"})
    private String link;
    @JsonAlias({"mp4_size"})
    private String size;
    private String width;
}
