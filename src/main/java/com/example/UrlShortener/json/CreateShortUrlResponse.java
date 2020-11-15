package com.example.UrlShortener.json;

public class CreateShortUrlResponse {

    private String shortUrl;

    public CreateShortUrlResponse() {
    }

    public CreateShortUrlResponse(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
