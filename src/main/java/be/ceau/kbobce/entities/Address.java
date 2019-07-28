/*
	Copyright 2019 Marceau Dewilde <m@ceau.be>
	
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
import java.time.LocalDate;

import be.ceau.kbobce.codes.TypeOfAddress;
import be.ceau.kbobce.validate.Validator;

/**
 * An address of an {@code Enterprise}
 */
public class Address implements Serializable {

	private static final long serialVersionUID = 484080285262597494L;

	private final TypeOfAddress typeOfAddress;

	private final String countryNL;

	private final String countryFR;

	private final String zipcode;

	private final String municipalityNL;

	private final String municipalityFR;

	private final String streetNL;

	private final String streetFR;

	private final String houseNumber;

	private final String box;

	private final String extraAddressInfo;

	private final LocalDate dateStrikingOff;

	/**
	 * Constructor
	 * 
	 * @param typeOfAddress
	 *            may not be {@code null}
	 * @param countryNL
	 *            may be {@code null}
	 * @param countryFR
	 *            may be {@code null}
	 * @param zipcode
	 *            may be {@code null}
	 * @param municipalityNL
	 *            may be {@code null}
	 * @param municipalityFR
	 *            may be {@code null}
	 * @param streetNL
	 *            may be {@code null}
	 * @param streetFR
	 *            may be {@code null}
	 * @param houseNumber
	 *            may be {@code null}
	 * @param box
	 *            may be {@code null}
	 * @param extraAddressInfo
	 *            may be {@code null}
	 * @param dateStrikingOff
	 *            may be {@code null}
	 */
	public Address(TypeOfAddress typeOfAddress, String countryNL, String countryFR, String zipcode, String municipalityNL, String municipalityFR, String streetNL, String streetFR, String houseNumber, String box, String extraAddressInfo, LocalDate dateStrikingOff) {

		Validator.isNotNull(typeOfAddress);
		this.typeOfAddress = typeOfAddress;

		if (countryNL != null) {
			Validator.isMaxLength(100, countryNL);
		}
		this.countryNL = countryNL != null ? countryNL : "";

		if (countryFR != null) {
			Validator.isMaxLength(100, countryFR);
		}
		this.countryFR = countryFR != null ? countryFR : "";

		if (zipcode != null) {
			Validator.isMaxLength(20, zipcode);
		}
		this.zipcode = zipcode != null ? zipcode : "";

		if (municipalityNL != null) {
			Validator.isMaxLength(200, municipalityNL);
		}
		this.municipalityNL = municipalityNL != null ? municipalityNL : "";

		if (municipalityFR != null) {
			Validator.isMaxLength(200, municipalityFR);
		}
		this.municipalityFR = municipalityFR != null ? municipalityFR : "";

		if (streetNL != null) {
			Validator.isMaxLength(200, streetNL);
		}
		this.streetNL = streetNL != null ? streetNL : "";

		if (streetFR != null) {
			Validator.isMaxLength(200, streetFR);
		}
		this.streetFR = streetFR != null ? streetFR : "";

		if (houseNumber != null) {
			Validator.isMaxLength(22, houseNumber);
		}
		this.houseNumber = houseNumber != null ? houseNumber : "";

		if (box != null) {
			Validator.isMaxLength(20, box);
		}
		this.box = box != null ? box : "";

		if (extraAddressInfo != null) {
			Validator.isMaxLength(80, extraAddressInfo);
		}
		this.extraAddressInfo = extraAddressInfo != null ? extraAddressInfo : "";

		this.dateStrikingOff = dateStrikingOff;
	}

	/**
	 * @return TypeOfAddress never {@code null}
	 */
	public TypeOfAddress getTypeOfAddress() {
		return typeOfAddress;
	}

	/**
	 * Country name in Dutch, if the address is not in Belgium
	 * 
	 * @return {@link String} possibly empty, never {@code null}
	 */
	public String getCountryNL() {
		return countryNL;
	}

	/**
	 * Country name in French, if the address is not in Belgium
	 * 
	 * @return {@link String} possibly empty, never {@code null}
	 */
	public String getCountryFR() {
		return countryFR;
	}

	/**
	 * @return {@link String} possibly empty, never {@code null}
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * Name of the municipality in Dutch
	 * 
	 * @return String may be empty, never {@code null}
	 */
	public String getMunicipalityNL() {
		return municipalityNL;
	}

	/**
	 * Name of the municipality in French
	 * 
	 * @return String may be empty, never {@code null}
	 */
	public String getMunicipalityFR() {
		return municipalityFR;
	}

	/**
	 * Streetname in Dutch
	 * 
	 * @return String may be empty, never {@code null}
	 */
	public String getStreetNL() {
		return streetNL;
	}

	/**
	 * Streetname in French
	 * 
	 * @return String may be empty, never {@code null}
	 */
	public String getStreetFR() {
		return streetFR;
	}

	/**
	 * Housenumber (excluding box number)
	 * 
	 * @return String may be empty, never {@code null}
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @return String may be empty, never {@code null}
	 */
	public String getBox() {
		return box;
	}

	/**
	 * Extra information about the address, such as "City Atrium" or
	 * "North Gate II &amp; III"
	 * 
	 * @return String may be empty, never {@code null}
	 */
	public String getExtraAddressInfo() {
		return extraAddressInfo;
	}

	/**
	 * The date the address was stricken, if it was stricken
	 * 
	 * @return LocalDate may be {@code null}
	 */
	public LocalDate getDateStrikingOff() {
		return dateStrikingOff;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + typeOfAddress.hashCode();
		result = prime * result + countryNL.hashCode();
		result = prime * result + countryFR.hashCode();
		result = prime * result + zipcode.hashCode();
		result = prime * result + municipalityNL.hashCode();
		result = prime * result + municipalityFR.hashCode();
		result = prime * result + streetNL.hashCode();
		result = prime * result + streetFR.hashCode();
		result = prime * result + houseNumber.hashCode();
		result = prime * result + box.hashCode();
		result = prime * result + extraAddressInfo.hashCode();
		result = prime * result + ((dateStrikingOff == null) ? 0 : dateStrikingOff.hashCode());
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
		Address other = (Address) obj;
		if (!typeOfAddress.equals(other.typeOfAddress)) {
			return false;
		} else if (!countryNL.equals(other.countryNL)) {
			return false;
		} else if (!countryFR.equals(other.countryFR)) {
			return false;
		} else if (!zipcode.equals(other.zipcode)) {
			return false;
		} else if (!municipalityNL.equals(other.municipalityNL)) {
			return false;
		} else if (!municipalityFR.equals(other.municipalityFR)) {
			return false;
		} else if (!streetNL.equals(other.streetNL)) {
			return false;
		} else if (!streetFR.equals(other.streetFR)) {
			return false;
		} else if (!houseNumber.equals(other.houseNumber)) {
			return false;
		} else if (!box.equals(other.box)) {
			return false;
		} else if (!extraAddressInfo.equals(other.extraAddressInfo)) {
			return false;
		} else if (dateStrikingOff == null) {
			return other.dateStrikingOff == null;
		}
		return dateStrikingOff.equals(other.dateStrikingOff);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Address [typeOfAddress=").append(typeOfAddress).append(", countryNL=").append(countryNL).append(", countryFR=").append(countryFR).append(", zipcode=").append(zipcode).append(", municipalityNL=").append(municipalityNL).append(", municipalityFR=").append(municipalityFR).append(", streetNL=").append(streetNL).append(", streetFR=").append(streetFR).append(", houseNumber=").append(houseNumber).append(", box=").append(box).append(", extraAddressInfo=").append(extraAddressInfo)
				.append(", dateStrikingOff=").append(dateStrikingOff).append("]").toString();
	}

}
