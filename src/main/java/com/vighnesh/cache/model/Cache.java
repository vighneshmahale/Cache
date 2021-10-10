package com.vighnesh.cache.model;

public interface Cache<Key, Value> {
    Value get(Key k);
    void set(Key k, Value v);
    void evict();
}
