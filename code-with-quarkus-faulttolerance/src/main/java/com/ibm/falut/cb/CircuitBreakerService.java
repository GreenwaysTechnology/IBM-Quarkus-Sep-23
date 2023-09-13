package com.ibm.falut.cb;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CircuitBreakerService {

    public List<String> getProducts() {
        return List.of("product1", "product2");
    }
}
