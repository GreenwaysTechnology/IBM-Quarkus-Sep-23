package com.ibm.di.interfaces;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
//@WelcomeQualifier
@Named("welcome")
public class WelcomeService implements Greeter {
    @Override
    public String sayGreet() {
        return "Welcome";
    }
}
