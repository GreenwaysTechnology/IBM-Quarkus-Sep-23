package com.ibm.rest.responses;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("customers")
public class CustomerResource {

    @GET
    public Customer getCustomer() {
        Customer customer = new Customer(1, "Subramanian", "Murugan", "Coimbatore");
        return customer;
    }

    //List of customers
    @GET
    @Path("list")
    public List<Customer> listCustomer() {
        return List.of(
                new Customer(1, "Subramanian", "Murugan", "Coimbatore"),
                new Customer(2, "Ram", "Murugan", "Coimbatore"),
                new Customer(3, "Geetha", "Subramanian", "Coimbatore"),
                new Customer(4, "Shrisha", "Subramanian", "Coimbatore")
        );
    }
}
