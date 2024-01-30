package com.examples.java.java17.record;

public class OrderDTO {
    private final int id;
    private final String desc;

    public OrderDTO(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
