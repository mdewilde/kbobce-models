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
 * <pre>
 * <blockquote cite="http://www.ond.vlaanderen.be/welzijn/stage/faq18.htm">
Wat is de betekenis van het ondernemingsnummer of nr KBO?

De administratieve vereenvoudiging staat hoog vermeld in de beleidsprioriteiten van de regering. Een van de belangrijkste middelen om deze beleidsprioriteit te verwezenlijken is het e-government: het beroep op de informatie- en communicatietechnologie (ICT) om het –administratieve– leven van burger en onderneming eenvoudiger te maken.
De basisidee van de Kruispuntbank van Ondernemingen (KBO) is al enkele jaren oud. Aanvankelijk heette dit project “repertorium van rechtspersonen”, nadien “ondernemingsregister” en tenslotte “kruispuntbank”.
Tal van overheidsdiensten hebben dagelijks identificatiegegevens van ondernemingen nodig. Tot voor 1 juli 2003 voorzagen de specifieke reglementeringen van al die departementen dat, om een bepaalde beslissing te verkrijgen, de belanghebbenden welbepaalde identificatiegegevens moesten mededelen.
Voor alle overheidsdiensten samen was dat natuurlijk een immens dubbel gebruik aangezien in al deze diensten personen belast waren met het registreren en het actueel houden van die gegevens. Bovendien was dergelijk systeem oorzaak van inefficiëntie aangezien dubbele of meervoudige gegevensopslag noodzakelijkerwijze leidde tot conflicten tussen de inhoud van de verschillende bestanden.
Zodra een onderneming een wijziging mededeelde aan een dienst en niet aan een andere kreeg men verschillen in de databases en werd het zeer moeilijk om uit te vinden wat nu juist de correcte gegevens waren.

Vandaar de idee om de identificatiegegevens van de ondernemingen op een eenvormige wijze en centraal ter beschikking te stellen van alle diensten. Dit heeft veel voordelen. Voor de overheidsdiensten betekent dit eerst en vooral dat zij met zekerheid over de meest actuele en juiste gegevens beschikken. Naast het voordeel van juiste informatie sparen zij ook werk uit aangezien nu in al die verschillende diensten het werk wordt verricht dat voortaan centraal zal gebeuren. Men spaart dus personeel en middelen die vrijkomen voor andere opdrachten die meer rechtstreeks met de kerntaken van de betrokken diensten verband houden. Voor de ondernemingen is het voordeel nog groter. Zij moeten immers hun identificatiegegevens nog slechts één enkele keer aan de overheid geven. Eens zij een identificatienummer gekregen hebben, volstaat de mededeling van dat nummer waarna de overheidsdiensten zelf de nodige identificatiegegevens zullen kunnen opvragen bij de Kruispuntbank van Ondernemingen. Administratieve vereenvoudiging met een hoofdletter dus.
Samengevat komt het er op neer dat ondernemingen maar eenmaal hun gegevens meer moeten doorgeven aan de overheidsdiensten.

Meer info vind je op: http://kbo-bce-ps.mineco.fgov.be/ps/kbo_ps/kbo_search.jsp?lang=nl&dest=ST

Men onderscheidt het ondernemingsnummer of nr. KBO en het vestigingseenheidsnummer in deze nieuwe aanpak van e-government. De reden waarom we voor de stages het ondernemingsnummer nodig is hebben, is op vraag van externe diensten. Zij werken "standaard" met het ondernemingsnummer. Het nummer moet in onze naamlijst worden ingevuld voor de opvolging van de gezondheidsbeoordelingen. Dit nummer kan je best opvragen in de stageovereenkomst, dan wordt het standaard meegegeven.

Je kan het zelf ook opzoeken. Het ondernemingsnummer kan eenvoudig via de naam van de stagegever opgezocht worden op: http://kbo-bce-ps.mineco.fgov.be/ps/kbo_ps/kbo_search.jsp?lang=nl&dest=ST

Het ondernemingsnummer bestaat uit 10 cijfers en begint met een 0. Het formaat is: 0xxx.xxx.xxx
</blockquote>
 * </pre>
 * 
 */
public class EnterpriseNumber {

	private static final Pattern PATTERN = Pattern.compile("0[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}");

	private final String enterpriseNumber;

	/**
	 * Construct a new {@link EnterpriseNumber}.<br>
	 * 
	 * @param enterpriseNumber
	 *            a valid, correctly formatted entity number.
	 * @throws IllegalArgumentException
	 *             if argument not valid. Avoid this exception by passing only
	 *             input validated with static {@link #isValid} method, or by
	 *             using the static factory to create a new EnterpriseNumber.
	 */
	public EnterpriseNumber(String enterpriseNumber) {
		if (!EnterpriseNumber.isValid(enterpriseNumber)) {
			throw new IllegalArgumentException("argument is not a valid EnterpriseNumber");
		}
		this.enterpriseNumber = enterpriseNumber;
	}

	public String getEnterpriseNumber() {
		return enterpriseNumber;
	}

	public static EnterpriseNumber parse(String enterpriseNumber) {
		if (isValid(enterpriseNumber)) {
			return new EnterpriseNumber(enterpriseNumber);
		}
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (char ch : enterpriseNumber.toCharArray()) {
			if (Character.isDigit(ch)) {
				if (index < 10) {
					sb.append(ch);
				} else {
					return null;
				}
			}
		}
		if (isValid(enterpriseNumber)) {
			return new EnterpriseNumber(enterpriseNumber);
		}
		return null;
	}

	/**
	 * Validate the given string as an EnterpriseNumber
	 * 
	 * @param enterpriseNumber
	 * @return true if the given argument is a valid, correctly formatted
	 *         EnterpriseNumber
	 */
	public static boolean isValid(String enterpriseNumber) {
		if (enterpriseNumber == null) {
			return false;
		}
		return PATTERN.matcher(enterpriseNumber).matches();
	}

	@Override
	public int hashCode() {
		return 31 * enterpriseNumber.hashCode();
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
		return enterpriseNumber.equals(other.enterpriseNumber);
	}

	@Override
	public String toString() {
		return "EnterpriseNumber [enterpriseNumber=" + enterpriseNumber + "]";
	}

}
