package com.example.clashroyaledraft.controller;

import com.example.clashroyaledraft.dto.Player;
import com.example.clashroyaledraft.feign.ClashApiPlayerClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClashApiDraftCardFetch {

    @Autowired
    private ClashApiPlayerClient clashApiPlayerClient;

    @Autowired
    private Environment env;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/getPlayer/{playerid}", produces = "application/json")
    public String getPlayer(@PathVariable String playerid) {
        Map<String, String> header = new HashMap<>();
        header.put("accept", "application/json");
        header.put("authorization", "Bearer " + env.getProperty("clash-token"));

        try {
            Player player = clashApiPlayerClient.getPlayer(header, playerid);
            try {
                return objectMapper.writeValueAsString(player);
            } catch (Exception e) {
                return e.toString();
            }
        } catch (FeignException e) {
            return e.contentUTF8();
        }
    }
}
