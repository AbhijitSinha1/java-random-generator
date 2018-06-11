package com.abhijit.jrg;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator {

	/**
	 * @return an alphabet between <b>a - z</b>
	 */
	public static Character character() {
		return (char) ('a' + (integer(26)));
	}

	/**
	 * @param characters
	 *            an array of characters to select from
	 * @return a character from the array of characters
	 */
	public static Character character(char... characters) {
		return characters[integer(characters.length)];
	}

	/**
	 * @param stringLength
	 *            number of characters in the string
	 * @return a string with <b>stringLength</b> number of characters
	 */
	public static String string(int stringLength) {
		return IntStream.range(0, stringLength)
		    .mapToObj(i -> character())
		    .map(a -> a.toString())
		    .reduce((a, b) -> a + b)
		    .get();
	}

	/**
	 * @param wordCount
	 *            number of words of size 10 needed
	 * @return a list of strings with each string size 10 and list size equal to
	 *         wordCount
	 */
	public static List<String> strings(int wordCount) {
		return IntStream.range(0, wordCount)
		    .boxed()
		    .map(i -> string(10))
		    .collect(Collectors.toList());
	}

	/**
	 * @param stringLengths
	 *            an array of integers specifying the string lengths
	 * @return a list of strings with specified string lengths
	 */
	public static List<String> strings(int... stringLengths) {
		List<String> list = new ArrayList<>();
		for (int count : stringLengths) {
			list.add(string(count));
		}
		return list;
	}

	/**
	 * @param limit
	 *            the maximum value the random integer can take (minimum is 0)
	 * @return a positive random integer
	 */
	public static Integer integer(int limit) {
		return integer(0, limit);
	}

	/**
	 * @param minLimit
	 *            the minimum value the random integer can take
	 * @param maxLimit
	 *            the maximum value the random integer can take
	 * @return a positive random integer
	 */
	public static Integer integer(int minLimit, int maxLimit) {
		return number(minLimit, maxLimit).intValue();
	}

	/**
	 * @param limits
	 *            an array of integer limits
	 * @return list of random integers
	 */
	public static List<Integer> integers(int... limits) {
		List<Integer> list = new ArrayList<>(limits.length);
		for (int limit : limits) {
			list.add(integer(limit));
		}
		return list;
	}

	/**
	 * @param limit
	 *            the maximum value the random number can take (minimum is 0)
	 * @return a positive random number
	 */
	public static Double number(double limit) {
		return number(0, limit);
	}

	/**
	 * @param minLimit
	 *            the minimum value the random number can take
	 * @param maxLimit
	 *            the maximum value the random number can take
	 * @return a positive random number
	 */
	public static Double number(double minLimit, double maxLimit) {
		return minLimit + Math.random() * (maxLimit - minLimit);
	}

	/**
	 * @param limits
	 *            an array of limits
	 * @return list of random numbers
	 */
	public static List<Double> numbers(double... limits) {
		List<Double> list = new ArrayList<>();
		for (double limit : limits) {
			list.add(number(limit));
		}
		return list;
	}

}
