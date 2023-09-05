package com.ibm.di;


import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("customers")
public class CustomerResource {
    @Inject
    OrderService orderService;
    @Inject
    CustomerService customerService;

    @GET
    @Path("/orders")
    public Uni<List<Order>> getOrders(){
         return orderService.findAllOrder();
    }
    @GET
    public Uni<List<Customer>> getCustomers(){
        return customerService.findAll();
    }
}
