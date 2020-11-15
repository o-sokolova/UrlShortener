package com.example.UrlShortener.services;

import com.example.UrlShortener.json.CreateShortUrlRequest;
import com.example.UrlShortener.repositories.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {
    @Autowired
    private UrlRepo repo;

    @Value("${server.port}")
    private int serverPort;

    public String shorten(String longUrl){
        String shortKey = Integer.toHexString(longUrl.hashCode());
        repo.save(shortKey, longUrl);
        return "http://localhost:" + serverPort + "/" + shortKey;
    }

    /**
     *
     * @param key created in {@link com.example.demo.controllers.ShortnererRestController#create(CreateShortUrlRequest)}
     * @return
     * @throws UrlShortenerServiceException
     */
    public String findLongUrl(String key) throws UrlShortenerServiceException {
        String longUrl = repo.find(key);
        if (longUrl == null) throw new ShortUrlNotFoundExceptoin(key);
        return longUrl;
    }
}
