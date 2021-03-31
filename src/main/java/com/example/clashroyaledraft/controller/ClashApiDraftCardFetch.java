package com.example.clashroyaledraft.controller;

import com.example.clashroyaledraft.dto.Card;
import com.example.clashroyaledraft.dto.Player;
import com.example.clashroyaledraft.feign.ClashApiPlayerClient;
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


    @GetMapping("/getPlayer/{playerid}")
    public Player getPlayer(@PathVariable String playerid) {
        Map<String, String> header = new HashMap<>();
        header.put("accept", "application/json");
        header.put("authorization", "Bearer " + env.getProperty("clash-token"));

        return clashApiPlayerClient.getPlayer(header, playerid);
    }
}
