package com.example.UrlShortener.repositories;

import org.springframework.stereotype.Repository;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class UrlRepo {

    private Map<String, String> repoMap = new ConcurrentHashMap<>();

    public void save(String key, String value) {
        repoMap.put(key, value);
    }

    public String find (String key){
        return repoMap.get(key);
    }
}
