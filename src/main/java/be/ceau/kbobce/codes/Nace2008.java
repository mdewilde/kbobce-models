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
package be.ceau.kbobce.codes;

import java.util.Map;

import be.ceau.kbobce.entities.Enterprise;
import be.ceau.kbobce.entities.Establishment;

/**
 * Standardized code for the activity type of an {@link Enterprise} or
 * {@link Establishment}. {@code Nace} is an acronym for <strong>Nomenclature
 * génerale des Activités économiques dans les Communautées
 * Européennes</strong>.
 * 
 * @see <a href=
 *      "http://statbel.fgov.be/nl/statistieken/gegevensinzameling/nomenclaturen/nacebel/">statbel</a>
 */
public class Nace2008 extends Nace {

	private static final long serialVersionUID = 1511034246781L;

	/**
	 * Construct a new {@link Nace2008}.
	 * 
	 * @param code
	 *            a {@link String}, not {@code blank}
	 * @param descriptions
	 *            descriptions for the code in Dutch, French and/or German, not
	 *            {@code null}
	 * @throws IllegalArgumentException
	 *             if argument not valid
	 */
	public Nace2008(String code, Map<String, String> descriptions) {
		super(code, descriptions);
	}

	@Override
	public int getYear() {
		return 2003;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code.hashCode();
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
		Nace2008 other = (Nace2008) obj;
		if (code != other.code)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Nace2008 [code=")
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
