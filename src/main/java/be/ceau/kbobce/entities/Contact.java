/*
	Copyright 2017 Marceau Dewilde <m@ceau.be>
	
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

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import be.ceau.kbobce.codes.ContactType;
import be.ceau.kbobce.codes.EntityContact;
import be.ceau.kbobce.util.Validator;

/**
 * Contact data of an {@code Enterprise}
 */
@Embeddable
@Access(AccessType.FIELD)
public class Contact implements Serializable {

	private static final long serialVersionUID = -8048688693470336154L;

	@Embedded
	private final EntityContact entityContact;
	
	@Embedded
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
	 * @return the type of the establishment of this contact data, never {@code null}
	 */
	public EntityContact getEntityContact() {
		return entityContact;
	}

	/**
	 * @return the type of this contact data, never {@code null}
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
		if (!contactType.equals(other.contactType))
			return false;
		if (!entityContact.equals(other.entityContact))
			return false;
		return value.equals(other.value);
	}

	@Override
	public String toString() {
		return new StringBuilder()		
			.append("Contact [entityContact=")
			.append(entityContact)
			.append(", contactType=")
			.append(contactType)
			.append(", value=")
			.append(value)
			.append("]")
			.toString();
	}

}
