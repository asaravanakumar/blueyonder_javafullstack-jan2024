package com.examples.java.java14;

public class NewSwitchCaseDemo {

    public static void main(String[] args) {
        System.out.println("Old Switch");
        System.out.println(getDayTypeOldStyle("Monday"));
        System.out.println(getDayTypeOldStyle("Saturday"));
        System.out.println(getDayTypeOldStyle(""));

        System.out.println("New Switch");
        System.out.println(getDayType("Monday"));
        System.out.println(getDayType("Saturday"));
        System.out.println(getDayType(""));
    }

//    public static String getDayType(String day) {
//        // Java 14 feature
//        String result = switch (day) {
//            case "Monday", "Tuesday", "Wednesday","Thursday", "Friday":
//                System.out.println( "Weekday");
//                System.out.println("Multiple Statements");
////                yield "Weekday";
//            case "Saturday", "Sunday":
//                yield "Weekend";
//            default: yield "Invalid day.";
//        };
//        return result;
//    }

    public static String getDayType(String day) {
        // Java 17 feature
        String result = switch (day) {
            case "Monday", "Tuesday", "Wednesday","Thursday", "Friday" ->
            { System.out.println("Test"); yield "Weekday"; }
            case "Saturday", "Sunday" -> {yield "Weekend";}
            default -> {yield "Invalid day.";}
        };
        return result;

    }

    public static String getDayTypeOldStyle(String day) {
        String result = null;

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                result = "Weekday";
                break;
            case "Saturday":
            case "Sunday":
                result = "Weekend";
                break;
            default:
                result =  "Invalid day.";
        }

        return result;
    }
}
