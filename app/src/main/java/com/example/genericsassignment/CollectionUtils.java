package com.example.genericsassignment;

import java.util.List;

/** Задание 5. Wildcard и принцип PECS (Producer Extends, Consumer Super). */
public class CollectionUtils {

    public static <T> void copy(
            List<? extends T> source,       // producer -> extends
            List<? super T> destination     // consumer -> super
    ) {
        for (T item : source) {
            destination.add(item);
        }
    }
}
