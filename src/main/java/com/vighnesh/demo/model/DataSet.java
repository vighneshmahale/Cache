package com.vighnesh.demo.model;

import lombok.Data;

@Data
public class DataSet <Key, Value>{
    private Key key;
    private Value value;
}
