package com.vighnesh.cache.eviction;

import com.vighnesh.cache.storage.StorageTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Component
public class EvictionFactory<Key, Value> {

    private static final HashMap<String, Eviction> evictionHashMap = new HashMap<>();

    EvictionFactory(@Autowired List<Eviction<Key, Value> > evictionList) {
        for(Eviction e:  evictionList){
             evictionHashMap.put(getHashKey(e.getStorageType().getStorageType(), e.getPolicy()), e);
         }
    }

    public Eviction<Key, Value> getEviction(final StorageTypes storageTypes, final Policy policy){
        Eviction eviction = evictionHashMap.get(getHashKey(storageTypes, policy));
        if(Objects.isNull(eviction)) throw new RuntimeException("No such eviction policy found");

        return eviction;
    }

    private static String getHashKey(final StorageTypes storageTypes, final Policy policy){
        return storageTypes.toString() + "-" + policy.toString();
    }
}
