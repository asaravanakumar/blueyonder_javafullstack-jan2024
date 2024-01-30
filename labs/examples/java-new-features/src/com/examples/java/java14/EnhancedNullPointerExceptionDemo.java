package com.examples.java.java14;

public class EnhancedNullPointerExceptionDemo {
    public static void main(String[] args) {
        String firstName = "Arun";
        String lastName = null;
        System.out.println(firstName.toUpperCase() + lastName.toUpperCase()); // throws NullPointerException with specifics
    }
}
