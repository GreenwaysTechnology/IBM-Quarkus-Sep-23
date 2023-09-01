package com.ibm.reactive;

import io.smallrye.mutiny.Uni;

public class HelloUni {
    public static void main(String[] args) {
        Uni.createFrom().item("Hello").subscribe().with(item->{
            System.out.println(item);
        });
    }
}
