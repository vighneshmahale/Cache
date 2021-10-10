package com.vighnesh.cache.eviction;

public enum Policy {
    LRU,
    LFU,
    FIFO,
    NONE;

    public static Policy getPolicy(final String type){
        for (Policy s: Policy.values()){
            if(s.toString().equalsIgnoreCase(type)) return s;
        }
        return NONE;
    }

}
