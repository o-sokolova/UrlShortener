package com.example.UrlShortener.services;

public class ShortUrlNotFoundExceptoin extends UrlShortenerServiceException{

    public ShortUrlNotFoundExceptoin() {
    }

    public ShortUrlNotFoundExceptoin(String message) {
        super(message);
    }

    public ShortUrlNotFoundExceptoin(String message, Throwable cause) {
        super(message, cause);
    }

    public ShortUrlNotFoundExceptoin(Throwable cause) {
        super(cause);
    }

    public ShortUrlNotFoundExceptoin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
