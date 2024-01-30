package com.examples.java.java9;

import java.util.*;

/**
 * Factory Methods for Immutable List, Set and Map - of()
 */
public class CollectionEnhancementsDemo {
    public static void main(String[] args) {

        // Java 8
        List<String> skills = new ArrayList<>(Arrays.asList("Java", "Python"));
        skills = Collections.unmodifiableList(skills);
//        skills.add("Node JS");
        System.out.println(skills);

        // Java 9 - List, Set, Map factory methods
        List<String> skills1 = new ArrayList<>( List.of("Java", "Python", "Java"));
//        skills1.add("Node JS"); // throws UnsupportedOperationException
        System.out.println(skills1);

        Set<String> skills2 = Set.of("Java", "Python");
//                skills2.add("Node JS"); // throws UnsupportedOperationException
        System.out.println(skills2);

        Map<String, String> skills3 = Map.of("Java", "10", "Python", "5");
//        skills3.put("JS", "5"); // throws UnsupportedOperationException
        System.out.println(skills3);
    }
}
