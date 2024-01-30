package com.examples.java.java17.record;

public class OrderMain {
    public static void main(String[] args) {
//        OrderDTO order = new OrderDTO(100, "Dell Inspiron Laptop");
//        System.out.println(order.getId());
//        System.out.println(order.getDesc());
//        System.out.println(order);

        OrderRecord order1 = new OrderRecord(1, "Mac Book Pro");
        System.out.println(order1.id());
        System.out.println(order1.desc());
//        System.out.println(order1.getOrderStatus());
        System.out.println(order1);


    }
}
