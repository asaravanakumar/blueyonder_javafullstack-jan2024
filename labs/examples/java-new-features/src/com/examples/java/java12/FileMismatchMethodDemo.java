package com.examples.java.java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMismatchMethodDemo {
    public static void main(String[] args) throws IOException {

        // No Mismatch

        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");

        Files.writeString(filePath1, "Java 12 Features");
        Files.writeString(filePath2, "Java 12 Features");

        long mismatch = Files.mismatch(filePath1, filePath2);
        System.out.println(mismatch); // -1 -> No Mismatch

        // Mismatch

        Path filePath3 = Files.createTempFile("file3", ".txt");
        Path filePath4 = Files.createTempFile("file4", ".txt");
        Files.writeString(filePath3, "Java 12 Training");
        Files.writeString(filePath4, "Java 12 Learning");

        long mismatch1 = Files.mismatch(filePath3, filePath4);
        System.out.println(mismatch1); // n -> position of first mismatch
    }
}
