package com.examples.java.java8.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class BackwardCompatibilityEx {

   public static void main(String args[]) {
	BackwardCompatibilityEx backwardCompatibilityEx = new BackwardCompatibilityEx();
      backwardCompatibilityEx.testBackwardCompatability();
   }
	
   public void testBackwardCompatability() {
      //Get the current date
      Date currentDate = new Date();
      System.out.println("Current date: " + currentDate);
		
      //Get the instant of current date in terms of milliseconds
      Instant now = currentDate.toInstant();
      ZoneId currentZone = ZoneId.systemDefault();
		
      LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
      System.out.println("Local date: " + localDateTime);
		
      ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
      System.out.println("Zoned date: " + zonedDateTime);
   }
}