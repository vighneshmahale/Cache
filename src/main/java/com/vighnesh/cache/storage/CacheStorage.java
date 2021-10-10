package com.vighnesh.cache.storage;

public interface CacheStorage<Key , Value> {
    Value get(Key k);
    void set(Key k, Value v);
    void delete(Key k, Value v);
    void emptyAll();
    Double getTotalSize();
    Double getUtilizedSize();
    StorageTypes getStorageType();
}
