package com.examples.java.java17.record;

public class EmployeeDTO {
    private final int id;
    private final String name;
    private final String department;
    private final String designation;
    private final String country;

    public EmployeeDTO(int id, String name, String department, String designation, String country) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public String getCountry() {
        return country;
    }
}
