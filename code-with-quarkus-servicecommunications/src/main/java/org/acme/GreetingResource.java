package org.acme;

import com.ibm.rest.client.restcommunicator.HelloRestClientService;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.client.HttpResponse;
import io.vertx.mutiny.ext.web.client.WebClient;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/greet")
public class GreetingResource {

    @Inject
    @RestClient
    HelloRestClientService helloRestClientService;

    //Grab vertx Runtime Instance
    @Inject
    Vertx vertx;

    //WebClient:Object need to be created
    WebClient webClient;

    @PostConstruct // life cycle annotation
    public void init() {
        //create Web Client Object
        webClient = WebClient.create(vertx, new WebClientOptions()
                .setDefaultHost("localhost")
                .setDefaultPort(8080));

    }

    //Rest client
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return helloRestClientService.sayHello();
    }

    @GET
    @Path("/vertxclient")
    public Uni<String> sayHello() {
        return webClient.get("/hello").send().onItem().transform(HttpResponse::bodyAsString);
    }
}
