package be.ceau.kbo.model.core;

import java.util.Map;

import be.ceau.kbo.model.util.Validator;

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
