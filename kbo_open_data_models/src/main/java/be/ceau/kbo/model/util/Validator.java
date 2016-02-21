package be.ceau.kbo.model.util;

import java.util.Collection;

public class Validator {

	/**
	 * Validates that the input string is not blank.
	 * @param string
	 * @throws IllegalArgumentException if input string is blank
	 */
	public static void isNotBlank(String string) {
		if (string != null) {
			for (int i = 0; i < string.length(); i++) {
				if (!Character.isWhitespace(string.charAt(i))) {
					return;
				}
			}
		}
		throw new IllegalArgumentException("input string is blank");
	}
	
	/**
	 * Validates that none of the given arguments are null
	 * @param objects
	 * @throws IllegalArgumentException if at least one argument is null
	 */
	public static void isNotNull(Object... objects) {
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				if (objects[i] == null) {
					throw new IllegalArgumentException("at least one argument is null");
				}
			}
			return;
		}
		throw new IllegalArgumentException("argument is null");
	}

	/**
	 * Validates that the given string has no more than the given number of characters
	 * @param maxLength a non-negative int
	 * @param string a non-null String
	 * @throws NullPointerException if string is null
	 * @throws IllegalArgumentException if maxLength is less than 0 or if string has more than maxLength characters
	 */
	public static void isMaxLength(int maxLength, String string) {
		if (maxLength < 0) {
			throw new IllegalArgumentException("maxLength argument must a non-negative int");
		}
		if (string.length() > maxLength) {
			throw new IllegalArgumentException(string + " has more than " + maxLength + " characters");
		}
	}

	/**
	 * Validates that the given string has exactly the given number of characters
	 * @param maxLength a non-negative int
	 * @param string a non-null String
	 * @throws NullPointerException if string is null
	 * @throws IllegalArgumentException if maxLength is less than 0 or if string has more than maxLength characters
	 */
	public static void isLength(int maxLength, String string) {
		if (maxLength < 0) {
			throw new IllegalArgumentException("maxLength argument must a non-negative int");
		}
		if (string.length() != maxLength) {
			throw new IllegalArgumentException(string + " does not have exactly " + maxLength + " characters");
		}
	}

	/**
	 * Validates that the given collection is not empty
	 * @param collection
	 * @throws IllegalArgumentException if the given collection is empty (or null)
	 */
	public static void isNotEmpty(Collection<?> collection) {
		if (collection != null) {
			if (!collection.isEmpty()) {
				return;
			}
		}
		throw new IllegalArgumentException("collection is null or empty");
	}

}
