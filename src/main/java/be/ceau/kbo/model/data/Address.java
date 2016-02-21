package be.ceau.kbo.model.data;

import java.time.LocalDate;

import be.ceau.kbo.model.core.TypeOfAddress;
import be.ceau.kbo.model.util.Validator;

/**
 * Het bestand address.csv bevat 1 lijn per adres van een onderneming of
 * vestigingseenheid. Een onderneming rechtspersoon kan twee adressen hebben
 * wanneer het een buitenlandse onderneming met bijhuis in België betreft.
 */
public class Address {

	private final TypeOfAddress typeOfAddress;

	/**
	 * Voor een adres in het buitenland: de benaming van het land in het
	 * Nederlands.
	 */
	private final String countryNL;

	/**
	 * Voor een adres in het buitenland: de benaming van het land in het Frans.
	 */
	private final String countryFR;

	/**
	 * Postcode.
	 */
	private final String zipcode;

	/**
	 * De naam van de gemeente in het Nederlands.
	 */
	private final String municipalityNL;

	/**
	 * De naam van de gemeente in het Frans.
	 */
	private final String municipalityFR;

	/**
	 * Straatnaam in het Nederlands.
	 */
	private final String streetNL;

	/**
	 * Straatnaam in het Frans.
	 */
	private final String streetFR;

	/**
	 * Huisnummer (zonder busnummer)
	 */
	private final String houseNumber;

	/**
	 * Busnummer.
	 */
	private final String box;

	/**
	 * Bijkomende informatie over het adres, zoals bijvoorbeeld “City Atrium” of
	 * “North Gate II & III”.
	 */
	private final String extraAddressInfo;

	/**
	 * Indien het adres is doorgehaald, dan staat hier de datum vanaf wanneer
	 * het adres doorgehaald is.
	 */
	private final LocalDate dateStrikingOff;

	/**
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
	public Address(TypeOfAddress typeOfAddress, String countryNL, String countryFR, String zipcode,
			String municipalityNL, String municipalityFR, String streetNL, String streetFR, String houseNumber,
			String box, String extraAddressInfo, LocalDate dateStrikingOff) {

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
	 * @return String may be empty, never {@code null}
	 */
	public String getCountryNL() {
		return countryNL;
	}

	/**
	 * @return String may be empty, never {@code null}
	 */
	public String getCountryFR() {
		return countryFR;
	}

	/**
	 * @return String may be empty, never {@code null}
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @return String may be empty, never {@code null}
	 */
	public String getMunicipalityNL() {
		return municipalityNL;
	}

	/**
	 * @return String may be empty, never {@code null}
	 */
	public String getMunicipalityFR() {
		return municipalityFR;
	}

	/**
	 * @return String may be empty, never {@code null}
	 */
	public String getStreetNL() {
		return streetNL;
	}

	/**
	 * @return String may be empty, never {@code null}
	 */
	public String getStreetFR() {
		return streetFR;
	}

	/**
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
	 * @return String may be empty, never {@code null}
	 */
	public String getExtraAddressInfo() {
		return extraAddressInfo;
	}

	/**
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
		} else if (dateStrikingOff == null && other.dateStrikingOff != null) {
			return false;
		}
		return dateStrikingOff.equals(other.dateStrikingOff);
	}

	@Override
	public String toString() {
		return "Address [typeOfAddress=" + typeOfAddress + ", countryNL=" + countryNL + ", countryFR=" + countryFR
				+ ", zipcode=" + zipcode + ", municipalityNL=" + municipalityNL + ", municipalityFR=" + municipalityFR
				+ ", streetNL=" + streetNL + ", streetFR=" + streetFR + ", houseNumber=" + houseNumber + ", box=" + box
				+ ", extraAddressInfo=" + extraAddressInfo + ", dateStrikingOff=" + dateStrikingOff + "]";
	}

}
