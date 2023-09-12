package com.ibm.rest.client;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class HelloResource {

    @Inject
    HelloService helloService;

    @GET
    public Uni<String> hello() {
        return helloService.hello();
    }
}