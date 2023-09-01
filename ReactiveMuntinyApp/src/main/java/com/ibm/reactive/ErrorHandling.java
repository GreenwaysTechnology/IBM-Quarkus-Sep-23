package com.ibm.reactive;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class ErrorHandling {
    public static void main(String[] args) {
        Uni.createFrom()
                .failure(new RuntimeException("Something went wrong"))
                .onFailure().recoverWithItem("fallback")
                .subscribe().with(err-> System.out.println(err));    }
}
