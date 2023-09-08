package com.ibm.quarkus.data.activerecord.entity;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("customers")
public class CustomerResource {

    //return all customers
    @GET
    public Uni<List<Customer>> findAll() {
        return Customer.listAll();
    }

    //find by id
    @Path("/{id}")
    @GET
    public Uni<Customer> findById(@PathParam("id") Long id) {

        return Customer.findById(id);
    }

    @POST
    public Uni<Response> create(Customer customer) {
        //Error Handling
        if (customer == null || customer.name == null) {
            throw new WebApplicationException("CustomerNot Found", 400);
        }
        return Panache.withTransaction(customer::persist)
                .replaceWith(Response.ok(customer)
                        .status(Response.Status.CREATED).build()
                );

    }

    @PUT
    @Path("/{id}")
    public Uni<Response> update(Long id, Customer customer) {
        //Error Handling
        if (customer == null || customer.name == null) {
            throw new WebApplicationException("CustomerNot Found", 400);
        }
        return Panache
                .withTransaction(() -> Customer.<Customer>findById(id))
                .onItem()
                .ifNotNull()
                .invoke(entity ->
                        {
                            entity.city = customer.city;
                            System.out.println(entity.city + " " + entity.name);
                        }
                )
                .onItem().ifNotNull().transform(entity -> {
                    return Response.ok(entity).build();
                })
                .onItem().ifNull()
                .continueWith(Response.ok().status(Response.Status.NOT_FOUND)::build);
    }

    //delete
    @DELETE
    @Path("/{id}")
    public Uni<Response> delete(Long id) {
        return Panache.withTransaction(() -> Customer.deleteById(id))
                .map(deleted -> deleted ? Response.ok().status(Response.Status.NO_CONTENT).build()
                        : Response.ok().status(Response.Status.NOT_FOUND).build()
                );

    }
}
