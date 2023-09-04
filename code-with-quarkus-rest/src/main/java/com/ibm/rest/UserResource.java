package com.ibm.rest;

import jakarta.ws.rs.*;

@Path("users")
public class UserResource {
    //apis
    @GET
    public String getUsers() {
        return "Users";
    }

    @Path("/{id}")
    @GET
    public String findUserById(@PathParam("id")  String id) {
        return "User By Id  " + id;
    }

    //http://localhost:8080/users/contact?mailId=test@gmail.com
    @GET
    @Path("/contact")
    public String findUsersByContact(@QueryParam("mailId") @DefaultValue("contact@ibm.com") String mailId ) {
        return "User by mail id  " + mailId;
    }

    //
    @Path("/address")
    @GET
    public String getUserByAddress(@MatrixParam("city") String city,@MatrixParam("state") String state,@MatrixParam("country") String country){

         return  city + " " + state + " " + country;
    }

    @POST
    public String create() {
        return "User Create";
    }

    @PUT
    @Path("/{id}")
    public String update(@PathParam("id") String id) {
        return "User update";
    }

    @DELETE
    @Path("/{id}")
    public String remove(@PathParam("id") String id) {
        return "User Remove " + id;
    }
}
