package com.examples.java.java10;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Optional Enhancements - orElseThrow()
 */
public class OptionalEnhancementsDemo {
    public static void main(String[] args) {
        Optional<List<String>> skills = Optional.of(Arrays.asList("Java","Scala","Python","Node"));
//        var skills = Optional.of(Arrays.asList("Java","Scala","Python","Node"));
//        var skills = Optional.empty();

        System.out.println(skills.get());
        System.out.println(skills.orElse(Arrays.asList("Java","Scala")));
        System.out.println(skills.orElseThrow(() -> new RuntimeException())); // Added in Java 10
    }
}
