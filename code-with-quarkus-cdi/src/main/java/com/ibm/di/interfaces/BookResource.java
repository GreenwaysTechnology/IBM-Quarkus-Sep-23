package com.ibm.di.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("books")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    public Book createBook(){
        return bookService.createBook();
    }

}
