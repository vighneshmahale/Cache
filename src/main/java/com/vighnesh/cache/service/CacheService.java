package com.vighnesh.cache.service;

import com.vighnesh.cache.model.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheService<K,V> {

    private final Cache<K, V> cache;

    public CacheService(@Autowired final Cache<K, V> cache) {
        this.cache = cache;
    }

    public V get(K k){
        return cache.get(k);
    }

    public void set(K key, V value){
        cache.set(key, value);
    }

    public void evict(){
        cache.evict();
    }
}
