/*
	Copyright 2017 Marceau Dewilde <m@ceau.be>
	
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
 * The nationally unique identifying number of a Belgian {@link Enterprise}. An
 * {@link EnterpriseNumber} is the id field of an {@link Enterprise}.
 * Instances are immutable.
 */
public class EnterpriseNumber implements Serializable {

	private static final long serialVersionUID = -3112897886124790983L;

	private static final Pattern PATTERN = Pattern.compile("0[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}");

	/**
	 * Static factory for safe construction of {@link EnterpriseNumber}
	 * instances. If {@code enterpriseNumber} argument fails
	 * {@link #isValid(String)} check, {@code null} is returned.
	 * 
	 * @param enterpriseNumber
	 *            a {@link String}, can be empty or {@code null}
	 * @return an {@link EnterpriseNumber} or {@code null}
	 */
	public static EnterpriseNumber parse(String enterpriseNumber) {
		if (enterpriseNumber == null) {
			return null;
		}
		if (isValid(enterpriseNumber)) {
			return new EnterpriseNumber(enterpriseNumber);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < enterpriseNumber.length(); i++) {
			if (Character.isDigit(enterpriseNumber.charAt(i))) {
				if (sb.length() < 10) {
					sb.append(enterpriseNumber.charAt(i));
				} else {
					return null;
				}
			}
		}
		if (sb.length() < 10) {
			return null;
		}
		sb.insert(4, '.');
		sb.insert(8, '.');
		enterpriseNumber = sb.toString();
		if (isValid(enterpriseNumber)) {
			return new EnterpriseNumber(enterpriseNumber);
		}
		return null;
	}

	/**
	 * Validate the given {@link String} as a possible {@code EnterpriseNumber}
	 * 
	 * @param enterpriseNumber
	 *            a {@code String} to validate as a possible
	 *            {@code EnterpriseNumber}
	 * @return true if the given argument is a valid, correctly formatted
	 *         enterprise number
	 */
	public static boolean isValid(String enterpriseNumber) {
		if (enterpriseNumber == null) {
			return false;
		}
		return PATTERN.matcher(enterpriseNumber).matches();
	}

	private final String value;

	/**
	 * Construct a new {@link EnterpriseNumber}.
	 * 
	 * @param value
	 *            a valid, correctly formatted enterprise number.
	 * @throws IllegalArgumentException
	 *             if argument not valid. Avoid this exception by passing only
	 *             input validated with static {@link #isValid} method, or by
	 *             using the static factory to create a new EnterpriseNumber.
	 */
	public EnterpriseNumber(String value) {
		if (!EnterpriseNumber.isValid(value)) {
			throw new IllegalArgumentException("argument is not a valid EnterpriseNumber");
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
		EnterpriseNumber other = (EnterpriseNumber) obj;
		return value.equals(other.value);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("EnterpriseNumber [value=")
				.append(value)
				.append("]")
				.toString();
	}

}
