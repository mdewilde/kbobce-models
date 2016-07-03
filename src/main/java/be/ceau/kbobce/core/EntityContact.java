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

import be.ceau.kbobce.util.Validator;

/**
 * Geeft aan voor welk type entiteit dit een contactgegeven is: onderneming,
 * bijhuis of vestigingseenheid.
 */
public class EntityContact extends Code {

	public EntityContact(String code, Map<String, String> descriptions) {
		super(code, descriptions);
		Validator.isMaxLength(3, code);
	}

	@Override
	public int hashCode() {
		return 31 * code.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityContact other = (EntityContact) obj;
		return code.equals(other.code);
	}

	@Override
	public String toString() {
		return "EntityContact [code=" + code + "]";
	}

}
