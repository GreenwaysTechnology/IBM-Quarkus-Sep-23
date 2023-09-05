package com.ibm.rest.exceptions;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Path("movies")
public class MovieResource {
    @GET
    @Path("/hero/{name}")
    public Response getHero(@PathParam("name") String name) {

        if (name.equals("myhero")) {
            return Response.ok().entity("Hero " + name).build();
        } else {
            throw new WebApplicationException("Hero not found");
        }
    }
}
