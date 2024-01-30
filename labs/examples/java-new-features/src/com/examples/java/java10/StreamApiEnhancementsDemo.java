package com.examples.java.java10;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream API Enhancements - Collectors can return unmodifiable collection
 */
public class StreamApiEnhancementsDemo {
    public static void main(String[] args) {

        // Stream API Enhancements
        Stream<Integer> ids = Stream.of(10,20,30,20,40,50,60,70,80,90,10);
        var filteredIds = ids.filter(i -> i < 30).collect(Collectors.toUnmodifiableList()); // Java 10
        System.out.println(filteredIds);
//        filteredIds.add(30); // throws UnsupportedOperationException

    }
}
