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
package be.ceau.kbobce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Main model for this library.
 */
public class Enterprise {

	private final EnterpriseNumber enterpriseNumber;

	private final Status status;

	private final JuridicalSituation juridicalSituation;

	private final TypeOfEnterprise typeOfEnterprise;

	private final JuridicalForm juridicalForm;

	private final LocalDate startDate;

	private final Set<Denomination> denominations;

	private final Set<Establishment> establishments;

	private final Set<Address> addresses;

	private final Set<Contact> contacts;

	private final Set<Activity> activities;

	public static Builder builder() {
		return new Enterprise.Builder();
	}

	/**
	 * Constructs a new immutable {@code Entreprise} instance
	 * 
	 * @param enterpriseNumber
	 *            {@link EnterpriseNumber} instance, not {@code null}
	 * @param status
	 *            {@link Status} instance, not {@code null}
	 * @param juridicalSituation
	 *            {@link JuridicalSituation} instance, not {@code null}
	 * @param typeOfEnterprise
	 *            {@link TypeOfEnterprise} instance, not {@code null}
	 * @param juridicalForm
	 *            {@link JuridicalForm} instance, not {@code null}
	 * @param startDate
	 *            {@link LocalDate} instance, not {@code null}
	 * @param denominations
	 *            collection of {@link Denomination} instances, can be
	 *            {@code null} or empty
	 * @param establishments
	 *            collection of {@link Establishment} instances, can be
	 *            {@code null} or empty
	 * @param addresses
	 *            collection of {@link Address} instances, can be {@code null}
	 *            or empty
	 * @param contacts
	 *            collection of {@link Contact} instances, can be {@code null}
	 *            or empty
	 * @param activities
	 *            collection of {@link Activity} instances, can be {@code null}
	 *            or empty
	 */
	public Enterprise(EnterpriseNumber enterpriseNumber, Status status, JuridicalSituation juridicalSituation, TypeOfEnterprise typeOfEnterprise, JuridicalForm juridicalForm, LocalDate startDate, Collection<Denomination> denominations, Collection<Establishment> establishments, Collection<Address> addresses, Collection<Contact> contacts, Collection<Activity> activities) {

		if (!isValid(enterpriseNumber, status, juridicalSituation, typeOfEnterprise, juridicalForm, startDate)) {
			throw new IllegalArgumentException("at least one required argument is null");
		}

		this.enterpriseNumber = enterpriseNumber;
		this.status = status;
		this.juridicalSituation = juridicalSituation;
		this.typeOfEnterprise = typeOfEnterprise;
		this.juridicalForm = juridicalForm;
		this.startDate = startDate;

		if (denominations == null || denominations.isEmpty()) {
			this.denominations = Collections.emptySet();
		} else {
			this.denominations = Collections.unmodifiableSet(new HashSet<>(denominations));
		}

		if (establishments == null || establishments.isEmpty()) {
			this.establishments = Collections.emptySet();
		} else {
			this.establishments = Collections.unmodifiableSet(new HashSet<>(establishments));
		}

		if (addresses == null || addresses.isEmpty()) {
			this.addresses = Collections.emptySet();
		} else {
			this.addresses = Collections.unmodifiableSet(new HashSet<>(addresses));
		}

		if (contacts == null || contacts.isEmpty()) {
			this.contacts = Collections.emptySet();
		} else {
			this.contacts = Collections.unmodifiableSet(new HashSet<>(contacts));
		}

		if (activities == null || activities.isEmpty()) {
			this.activities = Collections.emptySet();
		} else {
			this.activities = Collections.unmodifiableSet(new HashSet<>(activities));
		}

	}

	public static boolean isValid(EnterpriseNumber enterpriseNumber, Status status, JuridicalSituation juridicalSituation, TypeOfEnterprise typeOfEnterprise, JuridicalForm juridicalForm, LocalDate startDate) {
		return enterpriseNumber != null && status != null && juridicalSituation != null && typeOfEnterprise != null && juridicalForm != null && startDate != null;
	}

	public EnterpriseNumber getEnterpriseNumber() {
		return enterpriseNumber;
	}

	public Status getStatus() {
		return status;
	}

	public JuridicalSituation getJuridicalSituation() {
		return juridicalSituation;
	}

	public TypeOfEnterprise getTypeOfEnterprise() {
		return typeOfEnterprise;
	}

	public JuridicalForm getJuridicalForm() {
		return juridicalForm;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public Set<Denomination> getDenominations() {
		return denominations;
	}

	public Set<Establishment> getEstablishments() {
		return establishments;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	@Override
	public int hashCode() {
		return 31 * enterpriseNumber.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enterprise other = (Enterprise) obj;
		return enterpriseNumber.equals(other.enterpriseNumber);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Enterprise [enterpriseNumber=").append(enterpriseNumber).append(", status=").append(status).append(", juridicalSituation=").append(juridicalSituation).append(", typeOfEnterprise=").append(typeOfEnterprise).append(", juridicalForm=").append(juridicalForm).append(", startDate=").append(startDate).append(", denominations=").append(denominations).append(", establishments=").append(establishments).append(", addresses=").append(addresses).append(", contacts=").append(contacts)
				.append(", activities=").append(activities).append("]").toString();
	}

	public static class Builder {

		private EnterpriseNumber enterpriseNumber;
		private Status status;
		private JuridicalSituation juridicalSituation;
		private TypeOfEnterprise typeOfEnterprise;
		private JuridicalForm juridicalForm;
		private LocalDate startDate;
		private Set<Denomination> denominations = new HashSet<>();
		private Map<EstablishmentNumber, Establishment.Builder> establishments = new HashMap<>();
		private Set<Address> addresses = new HashSet<>();
		private Set<Contact> contacts = new HashSet<>();
		private Set<Activity> activities = new HashSet<>();

		private Builder() {
		}

		public EnterpriseNumber getEnterpriseNumber() {
			return this.enterpriseNumber;
		}

		public Builder withEnterpriseNumber(EnterpriseNumber enterpriseNumber) {
			this.enterpriseNumber = enterpriseNumber;
			return this;
		}

		public Builder withStatus(Status status) {
			this.status = status;
			return this;
		}

		public Builder withJuridicalSituation(JuridicalSituation juridicalSituation) {
			this.juridicalSituation = juridicalSituation;
			return this;
		}

		public Builder withTypeOfEnterprise(TypeOfEnterprise typeOfEnterprise) {
			this.typeOfEnterprise = typeOfEnterprise;
			return this;
		}

		public Builder withJuridicalForm(JuridicalForm juridicalForm) {
			this.juridicalForm = juridicalForm;
			return this;
		}

		public Builder withStartDate(LocalDate startDate) {
			this.startDate = startDate;
			return this;
		}

		public Builder addDenomination(Denomination denomination) {
			this.denominations.add(denomination);
			return this;
		}

		public Builder addDenominations(Collection<Denomination> denominations) {
			this.denominations.addAll(denominations);
			return this;
		}

		public Builder addEstablishment(Establishment.Builder establishment) {
			this.establishments.put(establishment.getEstablishmentNumber(), establishment);
			return this;
		}

		public Builder addEstablishments(Collection<Establishment.Builder> establishments) {
			for (Establishment.Builder establishment : establishments) {
				this.establishments.put(establishment.getEstablishmentNumber(), establishment);
			}
			return this;
		}

		public Establishment.Builder getEstablishmentBuilder(EstablishmentNumber establishmentNumber) {
			return this.establishments.get(establishmentNumber);
		}

		private Collection<Establishment> getEstablishments() {
			List<Establishment> establishments = new ArrayList<>();
			for (Establishment.Builder builder : this.establishments.values()) {
				establishments.add(builder.build());
			}
			return establishments;
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

		public Enterprise build() {
			return new Enterprise(enterpriseNumber, status, juridicalSituation, typeOfEnterprise, juridicalForm, startDate, denominations, getEstablishments(), addresses, contacts, activities);
		}

		@Override
		public String toString() {
			return new StringBuilder()
					.append("Enterprise.Builder [enterpriseNumber=")
					.append(enterpriseNumber)
					.append(", status=")
					.append(status)
					.append(", juridicalSituation=")
					.append(juridicalSituation)
					.append(", typeOfEnterprise=")
					.append(typeOfEnterprise)
					.append(", juridicalForm=")
					.append(juridicalForm)
					.append(", startDate=")
					.append(startDate)
					.append(", denominations=")
					.append(denominations)
					.append(", establishments=")
					.append(establishments)
					.append(", addresses=")
					.append(addresses)
					.append(", contacts=")
					.append(contacts)
					.append(", activities=")
					.append(activities)
					.append("]")
					.toString();
		}

	}

}
