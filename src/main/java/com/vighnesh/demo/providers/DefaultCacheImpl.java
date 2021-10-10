package com.vighnesh.demo.providers;

import com.vighnesh.demo.eviction.Eviction;
import com.vighnesh.demo.eviction.EvictionFactory;
import com.vighnesh.demo.eviction.Policy;
import com.vighnesh.demo.model.Cache;
import com.vighnesh.demo.storage.CacheStorage;
import com.vighnesh.demo.storage.StorageTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DefaultCacheImpl<K, V> implements Cache<K, V> {

    private final CacheStorage<K, V> cacheStorage;

    private final Eviction eviction;

    DefaultCacheImpl(@Value("${STORAGE_TYPE}") String storageTypeInput,
                     @Value("${POLICY}") String policyInput,
                     @Autowired EvictionFactory<K, V> evictionFactory){
        Policy policy = Policy.getPolicy(policyInput);
        StorageTypes storageTypes = StorageTypes.getStorageType(storageTypeInput);

        if(Policy.NONE.equals(policy) || StorageTypes.NONE.equals(storageTypes)) {
            throw new RuntimeException();
        }
        eviction = evictionFactory.getEviction(storageTypes, policy);
        cacheStorage = eviction.getStorageType();
    }

    @Override
    public V get(K k) {
        return cacheStorage.get(k);
    }

    @Override
    public void set(K k, V v) {
        cacheStorage.set(k, v);
    }

    @Override
    public void evict() {
        eviction.evict();
    }
}
