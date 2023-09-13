package com.ibm.falut.retry;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class RetryService {

    public List<String> getProducts() throws InterruptedException {
        return List.of("product1", "product2");
    }
}
