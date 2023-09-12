package com.ibm.rest.client;


import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public Uni<String> hello() {
        return Uni.createFrom().item("Hello Rest Client Service With Stork");
    }
}
