package com.example.clashroyaledraft.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class Card {
    @JsonProperty
    private String name;

    @JsonProperty
    private Integer id;

    @JsonProperty
    private Integer count;

    @JsonProperty
    private Integer level;

    @JsonProperty
    private Integer maxLevel;

    @JsonProperty
    private Map<String, String> iconUrls;
}
