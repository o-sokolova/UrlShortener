package com.example.UrlShortener.json;

public class CreateShortUrlRequest {

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    private String longUrl;

}
