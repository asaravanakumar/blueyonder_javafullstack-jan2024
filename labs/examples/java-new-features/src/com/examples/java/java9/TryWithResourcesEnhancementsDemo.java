package com.examples.java.java9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Try with Resources Enhancements
 */
public class TryWithResourcesEnhancementsDemo {
    public static void main(String[] args) throws FileNotFoundException{
        // Java 7
        try(Scanner in = new Scanner(new File("input/test.txt"));
            Scanner accIn = new Scanner(new File("input/account.txt"));) {
            while(in.hasNext()) {
                System.out.println(in.nextLine());
            }

            while(accIn.hasNext()) {
                System.out.println(accIn.nextLine());
            }

//            in.tokens().forEach(System.out::println);
//            accIn.tokens().forEach(System.out::println);

            System.out.println("NO ERROR");

        }

        System.out.println("**********************");

        // Java 9
        Scanner in = new Scanner(new File("input/test.txt"));
        Scanner accIn = new Scanner(new File("input/account.txt"));

        try(in;accIn) {
            while (in.hasNext()) {
                System.out.println(in.nextLine());
            }

            while(accIn.hasNext()) {
                System.out.println(accIn.nextLine());
            }
            System.out.println("NO ERROR");
        }

//        catch (FileNotFoundException e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
    }
}
