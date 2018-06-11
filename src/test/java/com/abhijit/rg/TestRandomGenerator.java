package com.abhijit.rg;

import com.abhijit.jrg.RandomGenerator;

public class TestRandomGenerator {

	public static void main(String[] args) {
		String alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		System.out.println("RANDOM CHARACTER:: " + RandomGenerator.character());
		System.out.println("RANDOM CHARACTER:: "
		        + RandomGenerator.character('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));
		System.out.println("RANDOM CHARACTER:: " + RandomGenerator.character(alphanumeric));
		System.out.println("STRING:: " + RandomGenerator.string(alphanumeric, 10));
		System.out.println("STRING:: " + RandomGenerator.string(10));
		System.out.println("STRINGS:: " + RandomGenerator.strings(5));
		System.out.println("STRINGS:: " + RandomGenerator.strings(alphanumeric, 5));
		System.out.println("STRINGS:: " + RandomGenerator.strings(5, 3, 4));
		System.out.println("NUMBER:: " + RandomGenerator.number(10));
		System.out.println("NUMBER:: " + RandomGenerator.number(10.5));
		System.out.println("NUMBER:: " + RandomGenerator.number(5, 10));
		System.out.println("NUMBER:: " + RandomGenerator.number(5.5, 10.5));
		System.out.println("NUMBER:: " + RandomGenerator.number(5, 10, Integer.class));
		System.out.println("NUMBER:: " + RandomGenerator.number(5.5, 10.5, Double.class));
		System.out.println("NUMBERS:: " + RandomGenerator.numbers(Integer.class)
		    .setMinlimit(5)
		    .setMaxlimit(10)
		    .setSize(10)
		    .build());
		System.out.println("NUMBERS:: " + RandomGenerator.numbers(Double.class)
		    .setMinlimit(5.5)
		    .setMaxlimit(10.5)
		    .setSize(10)
		    .build());
		System.out.println("NUMBERS:: " + RandomGenerator.numbers(1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println("NUMBERS:: " + RandomGenerator.numbers(1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5));
	}

}
