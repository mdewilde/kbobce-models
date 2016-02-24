/*
	Copyright 2016 Marceau Dewilde <m@ceau.be>
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
		http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package be.ceau.kbo.model.util;

import java.util.Collection;

/**
 * Utility class for validating preconditions and postconditions in this class.
 */
public class Validator {

	/**
	 * Validates that the input string is not blank.
	 * 
	 * @param string
	 * @throws IllegalArgumentException
	 *             if input string is blank
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
	 * 
	 * @param objects
	 * @throws IllegalArgumentException
	 *             if at least one argument is null
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
	 * Validates that the given string has no more than the given number of
	 * characters
	 * 
	 * @param maxLength
	 *            a non-negative int
	 * @param string
	 *            a non-null String
	 * @throws NullPointerException
	 *             if string is null
	 * @throws IllegalArgumentException
	 *             if maxLength is less than 0 or if string has more than
	 *             maxLength characters
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
	 * Validates that the given string has exactly the given number of
	 * characters
	 * 
	 * @param maxLength
	 *            a non-negative int
	 * @param string
	 *            a non-null String
	 * @throws NullPointerException
	 *             if string is null
	 * @throws IllegalArgumentException
	 *             if maxLength is less than 0 or if string has more than
	 *             maxLength characters
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
	 * 
	 * @param collection
	 * @throws IllegalArgumentException
	 *             if the given collection is empty (or null)
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
