package com.ibm.config.consul;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("consul")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message", defaultValue = "Hello from default")
    String message;

    @GET
    public String sayHello() {
        return message;
    }
}
