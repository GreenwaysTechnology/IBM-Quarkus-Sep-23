package com.ibm.di;


import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class OrderService {

    public Uni<List<Order>> findAllOrder() {
        return Uni.createFrom().item(List.of(new Order(1, 1000.89)));
    }
}
