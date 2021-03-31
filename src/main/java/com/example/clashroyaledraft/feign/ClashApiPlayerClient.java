package com.example.clashroyaledraft.feign;

import com.example.clashroyaledraft.dto.Card;
import com.example.clashroyaledraft.dto.Player;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value="clashapi",url="https://api.clashroyale.com/v1/")
public interface ClashApiPlayerClient {

    @RequestMapping(method = RequestMethod.GET,
                    value = "/players/{playertag}",
                    produces = "application/json")
    Player getPlayer(@RequestHeader Map<String, String> header,
                     @PathVariable String playertag);
}
