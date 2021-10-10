package com.vighnesh.cache.eviction;

import com.vighnesh.cache.storage.CacheStorage;

public interface Eviction<Key, Value> {
    void evict();
    boolean isEligibleForEviction();
    CacheStorage getStorageType();
    Policy getPolicy();
}
