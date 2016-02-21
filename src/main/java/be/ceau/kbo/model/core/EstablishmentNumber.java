package be.ceau.kbo.model.core;

import java.util.regex.Pattern;

/**
 * Het nummer van de vestigingseenheid.
 */
public class EstablishmentNumber {

	private static final Pattern FORMAT = Pattern.compile("[0-9]\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}");

	private final String value;

	public EstablishmentNumber(String value) {
		if (!EstablishmentNumber.isValid(value)) {
			throw new IllegalArgumentException("argument is not a valid EstablishmentNumber");
		}
		this.value = value;
	}

	/**
	 * Validate the given string as an EstablishmentNumber
	 * @param establishmentNumber
	 * @return true if the given argument is a valid, correctly formatted establishment number
	 */
	public static boolean isValid(String establishmentNumber) {
		if (establishmentNumber == null) {
			return false;
		}
		return FORMAT.matcher(establishmentNumber).matches();
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
		EstablishmentNumber other = (EstablishmentNumber) obj;
		return value.equals(other.value);
	}

	@Override
	public String toString() {
		return "EstablishmentNumber [value=" + value + "]";
	}
	
}
