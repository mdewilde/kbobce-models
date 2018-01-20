/*
	Copyright 2018 Marceau Dewilde <m@ceau.be>
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
		https://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package be.ceau.kbobce.entities;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * The identifying number of an {@link Establishment}. An
 * {@link EstablishmentNumber} is the id field of an {@link Establishment}.
 * Instances are immutable.
 */
public class EstablishmentNumber implements Serializable {

	private static final long serialVersionUID = 8778758175781262698L;

	private static final Pattern FORMAT = Pattern.compile("[0-9]\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}");


	/**
	 * Validate the given {@link String} as a possible {@code EstablishmentNumber}
	 * 
	 * @param establishmentNumber
	 *            {@code String} to validate as a possible
	 *            {@code EstablishmentNumber}
	 * @return true if the given argument is a valid, correctly formatted
	 *         establishment number
	 */
	public static boolean isValid(String establishmentNumber) {
		if (establishmentNumber == null) {
			return false;
		}
		return FORMAT.matcher(establishmentNumber).matches();
	}

	/**
	 * Static factory for safe construction of {@link EstablishmentNumber}
	 * instances. If {@code establishmentNumber} argument fails
	 * {@link #isValid(String)} check, {@code null} is returned.
	 * 
	 * @param establishmentNumber
	 *            a {@link String}, can be empty or {@code null}
	 * @return an {@link EstablishmentNumber} or {@code null}
	 */
	public static EstablishmentNumber parse(String establishmentNumber) {
		if (establishmentNumber == null) {
			return null;
		}
		if (isValid(establishmentNumber)) {
			return new EstablishmentNumber(establishmentNumber);
		}
		return null;
	}
	
	private final String value;

	/**
	 * Construct a new immutable {@link EstablishmentNumber} instance.
	 * 
	 * @param value
	 *            a valid, correctly formatted establishment number.
	 * @throws IllegalArgumentException
	 *             if argument not valid. Avoid this exception by passing only
	 *             input validated with the static {@link #isValid} method, or
	 *             by using the static factory to create a new
	 *             {@link EstablishmentNumber}.
	 */
	public EstablishmentNumber(String value) {
		if (!EstablishmentNumber.isValid(value)) {
			throw new IllegalArgumentException("argument is not a valid EstablishmentNumber");
		}
		this.value = value;
	}

	/**
	 * @return the raw {@link String} value
	 */
	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
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
		return new StringBuilder()
				.append("EstablishmentNumber [value=")
				.append(value)
				.append("]")
				.toString();
	}

}
