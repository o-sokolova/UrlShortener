package com.example.UrlShortener.controllers;

import com.example.UrlShortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class RedirectController {
    @Autowired
    private UrlShortenerService urlShortenerService;

    //"http://localhost:" + serverPort + "/"
    @RequestMapping("/{key}")
    public void redirect(@PathVariable("key") String key, HttpServletResponse response){

        String longUrl = urlShortenerService.findLongUrl(key);
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.addHeader("Location", longUrl);
    }
}
