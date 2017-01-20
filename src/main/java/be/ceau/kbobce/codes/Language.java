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
package be.ceau.kbobce.codes;

import java.util.Map;

import be.ceau.kbobce.entities.Denomination;

/**
 * The language of a {@link Denomination}.
 */
public class Language extends Code {

	private static final long serialVersionUID = 4031546705278349054L;

	/**
	 * Validate the given {@link String} as a possible {@code Language}
	 * code.
	 * 
	 * @param code
	 *            a {@code String} to validate as a possible
	 *            {@link Language}
	 * @return true if the given argument is a possible code of a
	 *         {@link Language}
	 */
	public static boolean isValid(String code) {
		return code != null && code.length() == 1;
	}

	/**
	 * Construct a new {@link Language}.
	 * 
	 * @param code
	 *            a {@link String}, not {@code blank}
	 * @param descriptions
	 *            descriptions for the code in Dutch, French and/or German, not
	 *            {@code null}
	 * @throws IllegalArgumentException
	 *             if argument not valid. Avoid this exception by passing only
	 *             input validated with static {@link #isValid} method
	 */
	public Language(String code, Map<String, String> descriptions) {
		super(code, descriptions);
		if (!isValid(code)) {
			throw new IllegalArgumentException("Language code must be exactly 1 character");
		}
	}

	@Override
	public int hashCode() {
		return code.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		return !code.equals(other.code);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Language [code=")
				.append(code)
				.append(", nl=")
				.append(nl)
				.append(", fr=")
				.append(fr)
				.append(", de=")
				.append(de)
				.append("]")
				.toString();
	}

}
