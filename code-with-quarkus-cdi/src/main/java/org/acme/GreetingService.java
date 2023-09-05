package org.acme;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    public String sayHello() {
        return "Hello from RESTEasy Reactive";
    }
}
