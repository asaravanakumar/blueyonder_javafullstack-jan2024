package com.examples.java.java17.record;

/**
 * Records are always final, they cannot be declared abstract, and they can’t use native methods.
 */
public record EmployeeRecord(int id,
                      String name,
                      String department,
                      String designation,
                      String country) {

//     Canonical Constructor
    public EmployeeRecord {
        if(id < 0) {
            throw new IllegalArgumentException("Employee ID can't be negative");
        }
    }

    public int id(int id) {
        System.out.println("Employee ID called");
        return id;
    }
}
