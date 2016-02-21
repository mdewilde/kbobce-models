package be.ceau.kbo.model.data;

import be.ceau.kbo.model.core.Language;
import be.ceau.kbo.model.core.TypeOfDenomination;
import be.ceau.kbo.model.util.Validator;

/**
 * Het bestand denomination.csv bevat 1 lijn per benaming van een onderneming of
 * vestigingseenheid. Een onderneming of vestigingseenheid kan meerdere
 * benamingen hebben.
 */
public class Denomination {

	private final Language language;
	private final TypeOfDenomination typeOfDenomination;
	private final String value;

	public Denomination(Language language, TypeOfDenomination typeOfDenomination, String value) {
		Validator.isNotNull(language, typeOfDenomination);
		Validator.isNotBlank(value);
		Validator.isMaxLength(320, value);
		this.language = language;
		this.typeOfDenomination = typeOfDenomination;
		this.value = value;
	}

	public Language getLanguage() {
		return language;
	}

	public TypeOfDenomination getTypeOfDenomination() {
		return typeOfDenomination;
	}

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
