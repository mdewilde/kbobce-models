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
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import be.ceau.kbobce.validate.Validator;

/**
 * A unit of establishment of an {@code Enterprise}. Create new instances using
 * by obtaining a {@link Builder} from {@link #builder()}.
 */
public class Establishment implements Serializable {

	private static final long serialVersionUID = 1993744126197854948L;

	/**
	 * @return a new {@link Builder} instance for fluent construction of an
	 *         {@link Establishment}
	 */
	public static Builder builder() {
		return new Builder();
	}

	private final EstablishmentNumber establishmentNumber;

	private final Set<Denomination> denominations;

	private final Set<Address> addresses;

	private final Set<Contact> contacts;

	private final Set<Activity> activities;

	private final LocalDate startDate;

	/**
	 * Constructor
	 * 
	 * @param establishmentNumber
	 *            an {@code EstablishmentNumber}, not {@code null}
	 * @param denominations
	 *            a {@code Collection} of {@code Denomination} instances, not
	 *            {@code null}
	 * @param addresses
	 *            a {@code Collection} of {@code Address} instances, not
	 *            {@code null}
	 * @param contacts
	 *            a {@code Collection} of {@code Contact} instances, not
	 *            {@code null}
	 * @param activities
	 *            a {@code Collection} of {@code Activity} instances, not
	 *            {@code null}
	 * @param startDate
	 *            a {@code LocalDate}, not {@code null}
	 * @throws IllegalArgumentException
	 *             if preconditions not met
	 * @see #builder()
	 */
	public Establishment(EstablishmentNumber establishmentNumber, Collection<Denomination> denominations,
			Collection<Address> addresses, Collection<Contact> contacts, Collection<Activity> activities,
			LocalDate startDate) {
		Validator.isNotNull(establishmentNumber, denominations, addresses, contacts, activities, startDate);
		this.establishmentNumber = establishmentNumber;
		this.denominations = Collections.unmodifiableSet(new HashSet<>(denominations));
		this.addresses = Collections.unmodifiableSet(new HashSet<>(addresses));
		this.contacts = Collections.unmodifiableSet(new HashSet<>(contacts));
		this.activities = Collections.unmodifiableSet(new HashSet<>(activities));
		this.startDate = startDate;
	}

	/**
	 * @return the identifier number of this {@code Establishment}, never
	 *         {@code null}
	 */
	public EstablishmentNumber getEstablishmentNumber() {
		return establishmentNumber;
	}

	/**
	 * @return an unmodifiable set of {@code Denomination} instances, never
	 *         {@code null}
	 */
	public Set<Denomination> getDenominations() {
		return denominations;
	}

	/**
	 * @return an unmodifiable set of {@code Address} instances, never
	 *         {@code null}
	 */
	public Set<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @return an unmodifiable set of {@code Contact} instances, never
	 *         {@code null}
	 */
	public Set<Contact> getContacts() {
		return contacts;
	}

	/**
	 * @return an unmodifiable set of {@code Activity} instances, never
	 *         {@code null}
	 */
	public Set<Activity> getActivities() {
		return activities;
	}

	/**
	 * @return the startDate of this {@code Establishment}, never {@code null}
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + establishmentNumber.hashCode();
		result = prime * result + startDate.hashCode();
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
		Establishment other = (Establishment) obj;
		if (!establishmentNumber.equals(other.establishmentNumber))
			return false;
		return startDate.equals(other.startDate);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Establishment [establishmentNumber=")
				.append(establishmentNumber)
				.append(", denominations=")
				.append(denominations)
				.append(", addresses=")
				.append(addresses)
				.append(", contacts=")
				.append(contacts)
				.append(", activities=")
				.append(activities)
				.append(", startDate=")
				.append(startDate)
				.append("]")
				.toString();
	}

	/**
	 * Builder class for new {@link Establishment} instances.
	 */
	public static class Builder implements Serializable {

		private static final long serialVersionUID = -7854844426241906998L;

		private EstablishmentNumber establishmentNumber;

		private Set<Denomination> denominations = new HashSet<>();

		private Set<Address> addresses = new HashSet<>();

		private Set<Contact> contacts = new HashSet<>();

		private Set<Activity> activities = new HashSet<>();

		private LocalDate startDate;

		public Builder() {
		}

		public Builder withEstablishmentNumber(EstablishmentNumber establishmentNumber) {
			this.establishmentNumber = establishmentNumber;
			return this;
		}

		public EstablishmentNumber getEstablishmentNumber() {
			return this.establishmentNumber;
		}

		public Builder addDenomination(Denomination denomination) {
			this.denominations.add(denomination);
			return this;
		}

		public Builder addDenominations(Collection<Denomination> denominations) {
			this.denominations.addAll(denominations);
			return this;
		}

		public Builder addAddress(Address address) {
			this.addresses.add(address);
			return this;
		}

		public Builder addAddresses(Collection<Address> addresses) {
			this.addresses.addAll(addresses);
			return this;
		}

		public Builder addContact(Contact contact) {
			this.contacts.add(contact);
			return this;
		}

		public Builder addContacts(Collection<Contact> contacts) {
			this.contacts.addAll(contacts);
			return this;
		}

		public Builder addActivity(Activity activity) {
			this.activities.add(activity);
			return this;
		}

		public Builder addActivities(Collection<Activity> activities) {
			this.activities.addAll(activities);
			return this;
		}

		public Builder withStartDate(LocalDate startDate) {
			this.startDate = startDate;
			return this;
		}

		public Establishment build() {
			return new Establishment(establishmentNumber, denominations, addresses, contacts, activities, startDate);
		}

	}
}
