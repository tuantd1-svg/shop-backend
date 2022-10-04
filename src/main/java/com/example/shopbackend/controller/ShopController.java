package com.example.shopbackend.controller;

import com.example.commonapi.model.ResultMessage;
import com.example.shopbackend.model.CardInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "api")
public class ShopController {
    @RequestMapping(value = "addToCard",method = RequestMethod.POST)
    public ResultMessage addToCard(@RequestBody CardInfo cardInfo)
    {
        return null;
    }
}
