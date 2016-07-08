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

import java.util.Map;

/**
 * <strong>Nomenclature génerale des Activités économiques dans les Communautées Européennes</strong>
 * <a href="http://statbel.fgov.be/nl/statistieken/gegevensinzameling/nomenclaturen/nacebel/">source</a>
 */
public class Nace extends Code {

	private final int year;
	
	public Nace(int year, String code, Map<String, String> descriptions) {
		super(code, descriptions);
		if (year != 2003 && year != 2008) {
			throw new IllegalArgumentException("Nace year must be 2003 or 2008");
		}
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code.hashCode();
		result = prime * result + year;
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
		Nace other = (Nace) obj;
		if (code != other.code)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Nace [year=")
				.append(year)
				.append(", code=")
				.append(code)
				.append(", descriptions=")
				.append(descriptions)
				.append("]")
				.toString();
	}
	
}
