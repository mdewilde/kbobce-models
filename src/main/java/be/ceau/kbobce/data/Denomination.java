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
package be.ceau.kbobce.data;

import be.ceau.kbobce.core.Language;
import be.ceau.kbobce.core.TypeOfDenomination;
import be.ceau.kbobce.util.Validator;

/**
 * Model definition for a name of an {@code Enterprise}.
 */
public class Denomination {

	private final Language language;

	private final TypeOfDenomination typeOfDenomination;

	private final String value;

	/**
	 * Constructor
	 * 
	 * @param language
	 *            not null {@code Language}
	 * @param typeOfDenomination
	 *            not null {@code TypeOfDenomination}
	 * @param value
	 *            not blank {@code String}, no more than 320 characters in
	 *            length
	 */
	public Denomination(Language language, TypeOfDenomination typeOfDenomination, String value) {
		Validator.isNotNull(language, typeOfDenomination);
		Validator.isNotBlank(value);
		Validator.isMaxLength(320, value);
		this.language = language;
		this.typeOfDenomination = typeOfDenomination;
		this.value = value;
	}
	
	/**
	 * @return the language of this {@code Denomination}, never null
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * @return the type of this {@code Denomination}, never null
	 */
	public TypeOfDenomination getTypeOfDenomination() {
		return typeOfDenomination;
	}

	/**
	 * @return the actual name, never blank, never more than 320 characters
	 */
	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value.hashCode();
		result = prime * result + language.hashCode();
		result = prime * result + typeOfDenomination.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Denomination other = (Denomination) obj;
		if (!value.equals(other.value)) {
			return false;
		} else if (!language.equals(other.language)) {
			return false;
		} else if (!typeOfDenomination.equals(other.typeOfDenomination))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Denomination [language=" + language + ", typeOfDenomination=" + typeOfDenomination + ", value=" + value
				+ "]";
	}

}