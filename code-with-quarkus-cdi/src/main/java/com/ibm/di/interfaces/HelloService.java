package com.ibm.di.interfaces;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
//@HelloQualifier
@Named("hello")
public class HelloService implements Greeter {
    @Override
    public String sayGreet() {
        return "Hello";
    }
}
