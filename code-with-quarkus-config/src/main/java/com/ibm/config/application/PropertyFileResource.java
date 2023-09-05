package com.ibm.config.application;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("properties")
public class PropertyFileResource {

    @ConfigProperty(name = "greeting.message", defaultValue = "Default Message")
    String message;

    @GET
    public String readFromPropertyFile() {
        return message;
    }

    @GET
    @Path("/configviacode")
    public String helloconfig() {
        String message = ConfigProvider
                .getConfig()
                .getOptionalValue("greeting.message", String.class)
                .orElse("Greeting");
        return message;
    }
}
