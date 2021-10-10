package com.vighnesh.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetResponse<V> {
    private V value;
}
