package com.ibm.di.interfaces;


import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("greeter")
public class GreeterResource {
    @Inject
    // @WelcomeQualifier
//    @HelloQualifier
    @Named("welcome")
    Greeter greeter;

    @GET
    public String getGreeter() {
        return greeter.sayGreet();
    }
}
