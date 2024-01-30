package com.examples.java.java17.record;

/**
 * Records are immutable data classes that require only the type and name of fields.
 */
public class RecordDemo {
    public static void main(String[] args) {
        EmployeeRecord employee = new EmployeeRecord (1, "Vikram", "Sales", "Manager", "India");
        System.out.println(employee.id());
        System.out.println(employee.id(100));
        System.out.println(employee.name());
        System.out.println(employee);
//        System.out.println(employee.toString());
//        System.out.println(employee.hashCode());
    }

//    record EmployeeRecord1(int id,
//                           String name,
//                           String department,
//                           String designation,
//                           String country){}
}
