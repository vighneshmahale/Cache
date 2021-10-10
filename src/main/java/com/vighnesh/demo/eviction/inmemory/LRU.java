package com.vighnesh.demo.eviction.inmemory;

import com.vighnesh.demo.eviction.Eviction;
import com.vighnesh.demo.eviction.Policy;
import com.vighnesh.demo.storage.CacheStorage;
import com.vighnesh.demo.storage.InMemoryCacheStorageImpl;
import com.vighnesh.demo.storage.StorageTypes;
import lombok.Getter;
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
