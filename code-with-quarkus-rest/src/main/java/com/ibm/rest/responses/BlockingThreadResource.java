package com.ibm.rest.responses;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseHeader;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import java.util.List;

@Path("threads")
public class BlockingThreadResource {

    //blocking code: running on worker pool thread
    @GET
    public String runOnWorkerPool() {
        System.out.println("Thread = > " + Thread.currentThread().getName());
        return "Worker pool";
    }

    //non blocking code: running on event loop thread

    @GET
    @Path("eventloop")
    public Uni<String> runOnEventLoop() {
        System.out.println("Thread => " + Thread.currentThread().getName());
        return Uni.createFrom().item("Hello Uni");
    }

    //reactive Products
    @GET
    @Path("reactive/products")
    public Uni<List<Product>> getProducts() {
        System.out.println("Products Thread => " + Thread.currentThread().getName());
        List<Product> products = List.of(new Product(1, "Phone", 13, 34999.90f));
        return Uni.createFrom().item(products);
    }

    //Response Reactive

    @GET
    @Path("/reactive/reactiveresponse")
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseHeader(name = "header", value = "hello")
    public Uni<List<Product>> getReactiveResponse() {
        List<Product> products = List.of(new Product(1, "Phone", 13, 34999.90f));
        System.out.println("getReactiveResponse Products Thread => " + Thread.currentThread().getName());
        return Uni.createFrom().item(products);
    }


}
