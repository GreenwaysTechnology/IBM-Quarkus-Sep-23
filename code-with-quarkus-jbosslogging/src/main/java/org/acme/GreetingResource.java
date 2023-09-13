package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {
    //logger declartion
    //private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @Inject
    Logger LOG;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("Rest API is called");
        return "Hello from RESTEasy Reactive";
    }
}
