package com.ibm.rest.threading;


import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.Duration;
import java.util.List;

@Path("products")
public class ProductResource {

    //This api runs by "Event loop thread"
    //This code is nonblocking code.
    @GET
    @Blocking //safely delegate the work to worker thread...
    public Uni<String> getProduct() throws InterruptedException {
        //Blocking code
        Thread.sleep(10000);
        System.out.println("Thread " + Thread.currentThread().getName());
        return Uni.createFrom().item("Product");
    }
    @GET
    @Path("/nonblockingdelay")
    public Uni delayBooks() throws InterruptedException {
        System.out.println("Current Thread - getBooks " + Thread.currentThread().getName());
        return Uni.createFrom().item("Books").onItem().delayIt().by(Duration.ofSeconds(2));
    }
}
