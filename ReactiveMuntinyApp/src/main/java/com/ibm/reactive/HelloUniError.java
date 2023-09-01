package com.ibm.reactive;

import io.smallrye.mutiny.Uni;

public class HelloUniError {
    public static void main(String[] args) {
        Uni.createFrom()
                .failure(new RuntimeException("Something went wrong"))
                .subscribe().with(item -> {
                    System.out.println(item);
                }, err -> {
                    System.out.println(err);
                });
    }
}
