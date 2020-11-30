package com.example.UrlShortener.controllers;

import com.example.UrlShortener.json.CreateShortUrlRequest;
import com.example.UrlShortener.json.CreateShortUrlResponse;
import com.example.UrlShortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortnererRestController {

    @Autowired // привяжет экземпляр сервиса к данному классу
    private UrlShortenerService urlShortenerService;

    @RequestMapping("/hellourl")
    public String hello(String name){
        return "Hello, " + name;
    }

    @RequestMapping(value = "/shorturl", method = RequestMethod.POST)
    public CreateShortUrlResponse create (@RequestBody CreateShortUrlRequest request){
        String shortUrl = urlShortenerService.shorten(request.getLongUrl());
        return new CreateShortUrlResponse(shortUrl);
    }
}
