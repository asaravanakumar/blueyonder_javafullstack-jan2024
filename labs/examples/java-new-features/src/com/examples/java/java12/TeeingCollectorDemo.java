package com.examples.java.java12;

import java.nio.file.FileSystems;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeeingCollectorDemo {
    public static void main(String[] args) {
        double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(Collectors.summingDouble(i -> i),
                        Collectors.counting(), (sum, count) -> sum / count));
        System.out.println(mean);
    }
}
