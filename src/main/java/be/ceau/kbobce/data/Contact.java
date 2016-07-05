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
package be.ceau.kbobce.data;

import be.ceau.kbobce.core.ContactType;
import be.ceau.kbobce.core.EntityContact;
import be.ceau.kbobce.util.Validator;

/**
 * Model definition for contact data of an {@code Enterprise}
 */
public class Contact {

	private final EntityContact entityContact;
	
	private final ContactType contactType;
	
	private final String value;

	/**
	 * Constructor
	 * 
	 * @param entityContact
	 *            not null {@code EntityContact}
	 * @param contactType
	 *            not null {@code ContactType}
	 * @param value
	 *            not blank {@code String}, no more than 254 characters in
	 *            length
	 */
	public Contact(EntityContact entityContact, ContactType contactType, String value) {
		Validator.isNotNull(entityContact, contactType);
		Validator.isNotBlank(value);
		Validator.isMaxLength(254, value);
		this.entityContact = entityContact;
		this.contactType = contactType;
		this.value = value;
	}

	/**
	 * @return the type of the establishment of this contact data, never null
	 */
	public EntityContact getEntityContact() {
		return entityContact;
	}

	/**
	 * @return the type of this contact data, never null
	 */
	public ContactType getContactType() {
		return contactType;
	}

	/**
	 * @return the actual contact information, never blank, never more than 254 characters
	 */
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