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
package be.ceau.kbobce.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import be.ceau.kbobce.util.Validator;

/**
 * A code used in the KBO/BCE dataset, along with translations in zero or more
 * languages.
 */
public abstract class Code {

	protected final String code;
	protected final Map<String, String> descriptions;

	/**
	 * Constructor
	 * 
	 * @param code
	 *            may not be {@code blank}
	 * @param descriptions
	 *            may not be {@code null}
	 */
	public Code(String code, Map<String, String> descriptions) {
		Validator.isNotBlank(code);
		Validator.isNotNull(descriptions);
		this.code = code;
		this.descriptions = Collections.unmodifiableMap(new HashMap<>(descriptions));
	}

	/**
	 * @return a non {@code blank} String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return unmodifiable map with all translations contained in this code
	 */
	public Map<String, String> getDescriptions() {
		return descriptions;
	}

	public String getDescription(String language) {
		return descriptions.get(language);
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
		Code other = (Code) obj;
		return code.equals(other.code);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Code [code=")
				.append(code)
				.append(", descriptions=")
				.append(descriptions)
				.append("]")
				.toString();
	}

}