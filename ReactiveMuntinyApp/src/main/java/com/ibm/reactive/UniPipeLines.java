package com.ibm.reactive;

import io.smallrye.mutiny.Uni;

public class UniPipeLines {
    public static void main(String[] args) {
        //transformation,filtering,accumulating etc....
        Uni.createFrom()
                .item("Hello")
                .onItem().transform(item -> {
                    return item + " Subramanian";
                })
                .onItem()
                .transform(item -> item.toUpperCase())
                .subscribe()
                .with(item -> System.out.println(item));
    }
}
