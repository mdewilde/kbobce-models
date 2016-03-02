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

/**
 * 
 * Het RSZ-identificatienummer
 * 
 * Dit is het nummer waaronder een onderneming geregistreerd staat bij de
 * Belgische Rijksdienst voor Sociale Zekerheid.
 * 
 * Het nummer bestaat uit 12 cijfers. Het is samengesteld uit:
 * 
 * een kengetal (3 cijfers) het eigenlijke inschrijvingsnummer (7 cijfers) een
 * controlegetal (2 cijfers)
 * 
 * Le numéro d'identification ONSS
 * 
 * Il s'agit du numéro sous lequel une entreprise est enregistrée auprès de
 * l'Office National de Sécurité Sociale.
 * 
 * Le numéro se compose de 12 chiffres, à savoir:
 * 
 * un numéro indicatif (3 chiffres) le numéro d'inscription proprement dit (7
 * chiffres) un numéro de contrôle (2 chiffres)
 * 
 */
public class SocialSecurityNumber {

	private final String value;

	/**
	 * Construct a new {@link SocialSecurityNumber}.<br>
	 * 
	 * @param value
	 *            a valid, correctly formatted social security number.
	 * @throws IllegalArgumentException
	 *             if argument not valid. Avoid this exception by passing only
	 *             input validated with the static {@link #isValid} method, or by
	 *             using the static factory to create a new SocialSecurityNumber.
	 */
	public SocialSecurityNumber(String value) {
		if (!isValid(value)) {
			throw new IllegalArgumentException("value is not a valid SocialSecurityNumber");
		}
		this.value = value;
	}

	/**
	 * Validate the given string as an SocialSecurityNumber. For now, we'll hold
	 * that either 12 or 9 numbers are valid
	 * 
	 * @param socialSecurityNumber
	 * @return true if the given argument is a valid, correctly formatted social
	 *         security number
	 */
	public static boolean isValid(String socialSecurityNumber) {
		if (socialSecurityNumber == null) {
			return false;
		}
		if (socialSecurityNumber.length() != 12 && socialSecurityNumber.length() != 9) {
			return false;
		}
		for (int i = 0; i < socialSecurityNumber.length(); i++) {
			if (socialSecurityNumber.charAt(i) < '0' || socialSecurityNumber.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	public static SocialSecurityNumber parse(String socialSecurityNumber) {
		if (isValid(socialSecurityNumber)) {
			return new SocialSecurityNumber(socialSecurityNumber);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < socialSecurityNumber.length(); i++) {
			if (Character.isDigit(socialSecurityNumber.charAt(i))) {
				sb.append(socialSecurityNumber.charAt(i));
			}
		}
		socialSecurityNumber = sb.toString();
		if (isValid(socialSecurityNumber)) {
			return new SocialSecurityNumber(socialSecurityNumber);
		}
		return null;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return 31 * value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SocialSecurityNumber other = (SocialSecurityNumber) obj;
		return value.equals(other.value);
	}

}
