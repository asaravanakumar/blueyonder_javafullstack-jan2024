package com.examples.java.java12;

public class StringIntentTransformMethodsDemo {
    public static void main(String[] args) {
        String text = "Hello There!\nWelcome to Java 12 Features.";

        // String Indent
        text = text.indent(10);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);

        // String Transform
        String transformed = text.transform(value ->
                new StringBuilder(value).reverse().toString()
        );
        System.out.println(transformed);

    }
}
