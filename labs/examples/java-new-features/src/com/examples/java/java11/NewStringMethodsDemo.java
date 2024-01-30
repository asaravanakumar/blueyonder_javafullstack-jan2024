package com.examples.java.java11;

import java.util.List;
import java.util.stream.Collectors;

/**
 * New methods in String - lines, isBlank, strip, stripTrailing, stringLeading, repeat
 */
public class NewStringMethodsDemo {

	public static void main(String[] args) {

		// isBlank, lines, strip, stripLeading, stripTrailing, and repeat
		String multilineString = "Java \n \n is \n Object Oriened and Functional language.";
		List<String> lines = multilineString
								.lines()
								.filter(line -> !line.isBlank())
								.map(String::strip)
								.collect(Collectors.toList());
		
		System.out.println(lines);
	}

}
