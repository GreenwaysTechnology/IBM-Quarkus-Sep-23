package com.ibm.di;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CustomerService {

    public Uni<List<Customer>> findAll() {
        return Uni.createFrom().item(List.of(new Customer(1, "Subramanian")));
    }
}
