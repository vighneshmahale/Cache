package com.vighnesh.demo.controller;

import com.vighnesh.demo.model.GetResponse;
import com.vighnesh.demo.model.SetResponse;
import com.vighnesh.demo.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheController {

    private final CacheService<String, String> cacheService;

    public CacheController(@Autowired CacheService<String, String> cacheService) {
        this.cacheService = cacheService;
    }

    public GetResponse<String> get(String key){
        try {
            String value = cacheService.get(key);
            return GetResponse.<String>builder().value(value).build();
        } catch (Exception e){
            throw e;
        }
    }

    public SetResponse set(String key, String value) {
        try{
            cacheService.set(key, value);
            return SetResponse.<String>builder().build();
        } catch (Exception e){
            throw e;
        }
    }
}
