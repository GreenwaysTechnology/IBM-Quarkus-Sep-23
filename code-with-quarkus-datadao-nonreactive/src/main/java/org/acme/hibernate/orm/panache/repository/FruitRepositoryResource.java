package org.acme.hibernate.orm.panache.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.quarkus.panache.common.Sort;

@Path("repository/fruits")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class FruitRepositoryResource {

    @Inject
    FruitRepository fruitRepository;

    private static final Logger LOGGER = Logger.getLogger(FruitRepositoryResource.class.getName());

    @GET
    public List<Fruit> get() {
        return fruitRepository.listAll(Sort.by("name"));
    }

    @GET
    @Path("{id}")
    public Fruit getSingle(Long id) {
        Fruit entity = fruitRepository.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Fruit with id of " + id + " does not exist.", 404);
        }
        return entity;
    }

    @POST
    @Transactional
    public Response create(Fruit fruit) {
//        if (fruit.id != null) {
//            throw new WebApplicationException("Id was invalidly set on request.", 422);
//        }
        fruitRepository.persist(fruit);
        return Response.ok(fruit).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Fruit update(Long id, Fruit fruit) {
        if (fruit.name == null) {
            throw new WebApplicationException("Fruit Name was not set on request.", 422);
        }

        Fruit entity = fruitRepository.findById(id);

        if (entity == null) {
            throw new WebApplicationException("Fruit with id of " + id + " does not exist.", 404);
        }
        entity.name = fruit.name;

        return entity;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(Long id) {
        Fruit entity = fruitRepository.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Fruit with id of " + id + " does not exist.", 404);
        }
        fruitRepository.delete(entity);
        return Response.status(204).build();
    }

    @Provider
    public static class ErrorMapper implements ExceptionMapper<Exception> {

        @Inject
        ObjectMapper objectMapper;

        @Override
        public Response toResponse(Exception exception) {
            LOGGER.error("Failed to handle request", exception);

            int code = 500;
            if (exception instanceof WebApplicationException) {
                code = ((WebApplicationException) exception).getResponse().getStatus();
            }

            ObjectNode exceptionJson = objectMapper.createObjectNode();
            exceptionJson.put("exceptionType", exception.getClass().getName());
            exceptionJson.put("code", code);

            if (exception.getMessage() != null) {
                exceptionJson.put("error", exception.getMessage());
            }

            return Response.status(code)
                    .entity(exceptionJson)
                    .build();
        }

    }
}