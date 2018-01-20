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
public abstract class Nace extends Code {

	private static final long serialVersionUID = -5512251988222060116L;

	public Nace(String code, Map<String, String> descriptions) {
		super(code, descriptions);
	}

	public abstract int getYear();

}
