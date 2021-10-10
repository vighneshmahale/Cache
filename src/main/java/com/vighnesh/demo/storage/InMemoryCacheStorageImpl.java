package com.vighnesh.demo.storage;

import com.vighnesh.demo.exceptions.CacheFullException;
import com.vighnesh.demo.exceptions.DependencyException;
import com.vighnesh.demo.exceptions.KeyNotExistException;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryCacheStorageImpl<Key, Value> implements CacheStorage<Key, Value> {

    private final double TOTAL_SIZE;
    private double currentSize;
    private final ConcurrentHashMap<Key, Value> map;

    private final StorageTypes cacheType;

    public InMemoryCacheStorageImpl(@org.springframework.beans.factory.annotation.Value("${CACHE_SIZE}") final double total_size) {
        TOTAL_SIZE = total_size;
        map = new ConcurrentHashMap<>();
        currentSize = 0;
        this.cacheType = StorageTypes.INMEMORY;
    }

    @Override
    public Value get(Key k) {
        Value value;
        try {
            if(!map.containsKey(k)) throw new KeyNotExistException();
            value = map.get(k);
        } catch (Exception e) {
            throw new DependencyException();
        }
        return value;
    }

    @Override
    public void set(Key k, Value v) {
        if (currentSize == TOTAL_SIZE) throw new CacheFullException();
        try {
            map.put(k, v);
            currentSize = currentSize + 1;
        } catch (Exception e) {
            throw new DependencyException();
        }
    }

    @Override
    public void delete(Key k, Value v) {
        try {
            map.remove(k);
            currentSize = currentSize - 1;
        } catch (Exception e) {
            throw new DependencyException();
        }
    }

    @Override
    public void emptyAll() {
        try {
            map.clear();
            currentSize = 0;
        } catch (Exception e) {
            throw new DependencyException();
        }
    }

    @Override
    public Double getTotalSize() {
        return TOTAL_SIZE;
    }

    @Override
    public Double getUtilizedSize() {
        return currentSize;
    }

    @Override
    public StorageTypes getStorageType(){
        return cacheType;
    }
}
