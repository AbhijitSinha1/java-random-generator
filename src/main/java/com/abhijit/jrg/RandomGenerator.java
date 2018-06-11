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
		return (char) ('a' + (number(26)));
	}

	/**
	 * @param characters
	 *            an array of characters to select from
	 * @return a character from the array of characters
	 */
	public static Character character(char... characters) {
		return characters[number(characters.length)];
	}

	/**
	 * @param string
	 *            the input string from which a character needs to be chosen
	 * @return a character from the input string
	 */
	public static Character character(String string) {
		return string.charAt(number(string.length()));
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
	 * @param string
	 *            string from where characters are chosen for the random string
	 * @param size
	 *            random string size
	 * @return random string of size: <b>size</b> with characters from <b>string</b>
	 */
	public static String string(String string, int size) {
		return numbers(Integer.class).setMaxlimit(string.length())
		    .setMinlimit(0)
		    .setSize(size)
		    .build()
		    .stream()
		    .map(i -> String.valueOf(string.charAt(i)))
		    .reduce((a, b) -> a + b)
		    .get();
	}

	/**
	 * @param string
	 *            string from where the characters will be chosen
	 * @param wordCount
	 *            number of words generated
	 * @return list of words generated
	 */
	public static List<String> strings(String string, int wordCount) {
		return IntStream.range(0, wordCount)
		    .boxed()
		    .map(i -> string(string, 10))
		    .collect(Collectors.toList());
	}

	/**
	 * @param limit
	 *            the maximum value the random integer can take (minimum is 0)
	 * @return a positive random integer
	 */
	public static Integer number(int limit) {
		return number(0, limit);
	}

	/**
	 * @param minLimit
	 *            the minimum value the random integer can take
	 * @param maxLimit
	 *            the maximum value the random integer can take
	 * @return a positive random integer
	 */
	public static Integer number(int minLimit, int maxLimit) {
		return number((double) minLimit, (double) maxLimit).intValue();
	}

	/**
	 * @param limits
	 *            an array of integer limits
	 * @return list of random integers
	 */
	public static List<Integer> numbers(int... limits) {
		List<Integer> list = new ArrayList<>(limits.length);
		for (int limit : limits) {
			list.add(number(limit));
		}
		return list;
	}

	/**
	 * @param limit
	 *            the maximum value the random number can take (minimum is 0)
	 * @return a positive random number
	 */
	public static Double number(double limit) {
		return number((double) 0, limit);
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

	/**
	 * @return a random number generator
	 */
	public static <T extends Number> RandomNumberBuilder<T> numbers(Class<T> clz) {
		return new RandomNumberBuilder<T>(clz);
	}

	/**
	 * @param minLimit
	 * @param maxLimit
	 * @param clz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Number> T number(T minLimit, T maxLimit, Class<T> clz) {

		switch (clz.getName()) {
			case "java.lang.Integer": {
				return (T) number((Integer) minLimit, (Integer) maxLimit);
			}
			case "java.lang.Double": {
				return (T) number((Double) minLimit, (Double) maxLimit);
			}
		}
		return null;
	}

	/**
	 * @param rows
	 *            number of rows in the matrix
	 * @param cols
	 *            number of columns in the matrix
	 * @param limit
	 *            maximum value of each integer entry (minimum is 0)
	 * @return an integer matrix
	 */
	public static Integer[][] matrix(int rows, int cols, int limit) {
		Integer[][] arr = new Integer[rows][cols];
		for (int i = 0; i < rows; i++) {
			arr[i] = array(cols, limit);
		}
		return arr;
	}

	/**
	 * @param size
	 *            size of the array
	 * @param limit
	 *            maximum value of each entry (minimum is 0)
	 * @return an integer array
	 */
	private static Integer[] array(int size, int limit) {
		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++) {
			arr[i] = number(limit);
		}
		return arr;
	}

	/**
	 * @param list
	 *            list of objects
	 * @return randomized list of objects
	 */
	public static <T> List<T> randomize(List<T> list) {
		List<T> result = new ArrayList<>();
		List<T> original = new ArrayList<>(list);
		while (original.size() > 0) {
			result.add(original.remove((int) number(original.size())));
		}
		return result;
	}
}
