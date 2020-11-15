package com.example.UrlShortener.services;

public class UrlShortenerServiceException extends RuntimeException {
    public UrlShortenerServiceException() {
    }

    public UrlShortenerServiceException(String message) {
        super(message);
    }

    public UrlShortenerServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UrlShortenerServiceException(Throwable cause) {
        super(cause);
    }

    public UrlShortenerServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
