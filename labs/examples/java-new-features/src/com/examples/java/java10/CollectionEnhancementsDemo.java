package com.examples.java.java10;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collection Enhancements - copyOf() factory method
 */
public class CollectionEnhancementsDemo {
    public static void main(String[] args) {
        List<String> skills = List.of("Java","Scala","Python","Java"); // Java 9

        // creates unmodifiable collection
//        var skills1 = Collections.unmodifiableList(skills);
//        System.out.println(skills1);
//        skills1.add("PHP"); // throws UnsupportedOperationException

        var skills1 = List.copyOf(skills); // Java 10
        System.out.println(skills1);
//        skills1.add("PHP"); // throws UnsupportedOperationException

        var skills2 = Set.copyOf(skills); // Java 10
        System.out.println(skills2);
//        skills2.add("PHP"); // throws UnsupportedOperationException
    }
}
