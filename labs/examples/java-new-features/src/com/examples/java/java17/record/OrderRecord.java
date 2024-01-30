package com.examples.java.java17.record;

public record OrderRecord(int id, String desc) {

    // Canonical Constructor
    public OrderRecord {
        if(id <= 0) {
            throw new IllegalArgumentException("Invalid Order ID");
        }
    }

    @Override
    public String desc() {
        return desc.toUpperCase() + " " + getOrderStatus() + id;
    }

    private String getOrderStatus() {
        return "PENDING";
    }

//    @Override
//    public void run() {
//
//    }
}