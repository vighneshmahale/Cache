package com.vighnesh.cache.eviction.inmemory;

import com.vighnesh.cache.eviction.Eviction;
import com.vighnesh.cache.eviction.Policy;
import com.vighnesh.cache.storage.CacheStorage;
import com.vighnesh.cache.storage.InMemoryCacheStorageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LRU implements Eviction {

    @Autowired
    private InMemoryCacheStorageImpl storage;

    @Override
    public void evict() {
    }

    @Override
    public boolean isEligibleForEviction() {
        return true;
    }

    @Override
    public CacheStorage getStorageType() {
        return storage;
    }

    @Override
    public Policy getPolicy() {
        return Policy.LRU;
    }
}
