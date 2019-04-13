package com.demo.dddsample.warehouse;

import lombok.Value;

@Value
public class Product {
    private final String productId;
    private final String productType;
    private final Integer price;
    private final Integer weight;
}
