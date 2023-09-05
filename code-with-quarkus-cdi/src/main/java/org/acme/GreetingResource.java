package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

//    GreetingService greetingService = new GreetingService();

    @Inject
    //private  GreetingService greetingService;
    GreetingService greetingService;

//    private GreetingService greetingService;
//
//    public GreetingService getGreetingService() {
//        return greetingService;
//    }
//
//    @Inject
//    public void setGreetingService(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }

//    private  GreetingService greetingService;
//
//    public GreetingResource() {
//    }
//
//    @Inject
//    public GreetingResource(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.sayHello();
    }
}
