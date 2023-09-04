package com.ibm.rest.responses;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("products")
public class ProductResource {

    //    @GET
//    public List<Product> getProducts() {
//        return List.of(new Product(1, "Phone", 1000, 23.9F));
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        List<Product> products = List.of(new Product(1, "Phone", 1000, 23.9F));
        return Response
                .ok()  // 200
                .entity(products) // content
                .header("productheader", "product") //custom header
                .build();
    }
}
