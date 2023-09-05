package com.ibm.di.interfaces;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class BookService {
    //This bean uses another Bean
    @Inject
    NumberGenerator numberGenerator;

    public Book createBook() {
        Book book = new Book("2333", "Quarkus in Action", "Subramanian");
        book.setIsbnNumber(numberGenerator.generateISBNNumber());
        return book;
    }
}
