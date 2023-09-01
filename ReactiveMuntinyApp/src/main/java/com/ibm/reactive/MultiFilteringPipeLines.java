package com.ibm.reactive;

import io.smallrye.mutiny.Multi;

public class MultiFilteringPipeLines {
    public static void main(String[] args) {
        Multi.createFrom()
                .items(1, 2,2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(item -> item % 2 == 0)
                .select().first(2)
                .select().distinct()
                .subscribe()
                .with(item -> System.out.println(item));

    }
}
