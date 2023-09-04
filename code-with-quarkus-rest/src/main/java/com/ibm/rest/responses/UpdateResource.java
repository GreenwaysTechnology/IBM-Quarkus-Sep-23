package com.ibm.rest.responses;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("update")
public class UpdateResource {

    @GET
    public void update(){
        System.out.println("update");
    }
}
