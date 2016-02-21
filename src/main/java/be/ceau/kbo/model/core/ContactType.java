package be.ceau.kbo.model.core;

import java.util.Map;

import be.ceau.kbo.model.util.Validator;

/**
 * Geeft het type contactgegeven aan: telefoonnummer, e-mail of web adres.
 */
public class ContactType extends Code {

	public ContactType(String code, Map<String, String> descriptions) {
		super(code, descriptions);
		Validator.isMaxLength(5, code);
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
		ContactType other = (ContactType) obj;
		return code.equals(other.code);
	}

	@Override
	public String toString() {
		return "ContactType [code=" + code + "]";
	}

}
