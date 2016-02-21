package be.ceau.kbo.model.data;

import be.ceau.kbo.model.core.ContactType;
import be.ceau.kbo.model.core.EntityContact;
import be.ceau.kbo.model.util.Validator;

/**
 * Het bestand contact.csv bevat 1 lijn per contact-gegeven van een onderneming
 * of vestigingseenheid. Per onderneming of vestigingseenheid kunnen meerdere
 * contact-gegevens voorkomen (bijvoorbeeld 1 telefoonnummer en 1 web adres).
 */
public class Contact {

	private final EntityContact entityContact;
	private final ContactType contactType;
	private final String value;

	public Contact(EntityContact entityContact, ContactType contactType, String value) {
		Validator.isNotNull(entityContact, contactType);
		Validator.isNotBlank(value);
		Validator.isMaxLength(254, value);
		this.entityContact = entityContact;
		this.contactType = contactType;
		this.value = value;
	}

	public EntityContact getEntityContact() {
		return entityContact;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contactType.hashCode();
		result = prime * result + entityContact.hashCode();
		result = prime * result + value.hashCode();
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
		Contact other = (Contact) obj;
		if (contactType == null) {
			if (other.contactType != null)
				return false;
		} else if (!contactType.equals(other.contactType))
			return false;
		if (entityContact != other.entityContact)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [entityContact=" + entityContact + ", contactType=" + contactType + ", value=" + value + "]";
	}

}
