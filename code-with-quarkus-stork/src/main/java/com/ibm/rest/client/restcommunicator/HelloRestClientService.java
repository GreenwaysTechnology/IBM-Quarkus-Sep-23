package com.ibm.rest.client.restcommunicator;


import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/hello")
@RegisterRestClient(configKey = "hello-api")
public interface HelloRestClientService {
    //CURD OPERATIONS OF CALL Declaration
    @GET
    Uni<String> sayHello();
}
