package com.vighnesh.cache.eviction.inmemory;

import com.vighnesh.cache.eviction.Eviction;
import com.vighnesh.cache.eviction.Policy;
import com.vighnesh.cache.storage.CacheStorage;
import com.vighnesh.cache.storage.InMemoryCacheStorageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LFU<Key,Value> implements Eviction<Key, Value> {

    @Autowired
    private InMemoryCacheStorageImpl<Key, Value> storage;

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
        return Policy.LFU;
    }
}
