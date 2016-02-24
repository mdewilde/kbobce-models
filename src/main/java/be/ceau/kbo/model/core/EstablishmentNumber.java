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
package be.ceau.kbo.model.core;

import java.util.regex.Pattern;

/**
 * Het nummer van de vestigingseenheid.
 */
public class EstablishmentNumber {

	private static final Pattern FORMAT = Pattern.compile("[0-9]\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}");

	private final String value;

	public EstablishmentNumber(String value) {
		if (!EstablishmentNumber.isValid(value)) {
			throw new IllegalArgumentException("argument is not a valid EstablishmentNumber");
		}
		this.value = value;
	}

	/**
	 * Validate the given string as an EstablishmentNumber
	 * @param establishmentNumber
	 * @return true if the given argument is a valid, correctly formatted establishment number
	 */
	public static boolean isValid(String establishmentNumber) {
		if (establishmentNumber == null) {
			return false;
		}
		return FORMAT.matcher(establishmentNumber).matches();
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return 31 * value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstablishmentNumber other = (EstablishmentNumber) obj;
		return value.equals(other.value);
	}

	@Override
	public String toString() {
		return "EstablishmentNumber [value=" + value + "]";
	}
	
}
