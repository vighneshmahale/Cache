package com.vighnesh.demo.eviction;

import com.vighnesh.demo.storage.CacheStorage;

public interface Eviction<Key, Value> {
    void evict();
    boolean isEligibleForEviction();
    CacheStorage getStorageType();
    Policy getPolicy();
}
