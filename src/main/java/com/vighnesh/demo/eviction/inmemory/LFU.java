package com.vighnesh.demo.eviction.inmemory;

import com.vighnesh.demo.eviction.Eviction;
import com.vighnesh.demo.eviction.Policy;
import com.vighnesh.demo.storage.CacheStorage;
import com.vighnesh.demo.storage.InMemoryCacheStorageImpl;
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
