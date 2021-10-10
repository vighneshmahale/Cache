package com.vighnesh.demo.storage;

public enum StorageTypes {
    INMEMORY,
    EXTERNAL,
    NONE;

    public static StorageTypes getStorageType(final String type){
        for (StorageTypes s: StorageTypes.values()){
            if(s.toString().equalsIgnoreCase(type)) return s;
        }
        return NONE;
    }


}
