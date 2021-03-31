package com.example.clashroyaledraft.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Player {
    @JsonProperty
    private Integer trophies;

    @JsonProperty
    private List<Card> cards;
}
