package com.ibm.quarkus.data.dao.entity;


import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("persons")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    public Uni<List<Person>> findAll() {
        return personRepository.listAll();
    }

    @Path("/{id}")
    @GET
    public Uni<Person> findById(@PathParam("id") Long id) {
        return personRepository.findById(id);
    }

    @POST
    @WithTransaction //reactive version of transaction annotation
    public Uni<Person> create(Person person) {
        return personRepository.persist(person);
    }

    @PUT
    @WithTransaction
    public Uni<Integer> update(Person person) {
        String query = "name ='" + person.getName() + "' where id = ?1";
        System.out.println(query);
        return personRepository.update(query, person.getId());
    }

    @Path("/{id}")
    @DELETE()
    @WithTransaction
    public Uni<Boolean> remove(Long id) {
        return personRepository.deleteById(id);
    }
}
