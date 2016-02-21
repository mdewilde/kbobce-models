package be.ceau.kbo.model.data;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import be.ceau.kbo.model.core.EntityNumber;
import be.ceau.kbo.model.core.JuridicalForm;
import be.ceau.kbo.model.core.JuridicalSituation;
import be.ceau.kbo.model.core.Status;
import be.ceau.kbo.model.core.TypeOfEnterprise;
import be.ceau.kbo.model.util.Validator;

/**
 * Main model for this library.
 */
public class Enterprise {

	private final EntityNumber entityNumber;
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
	
	private Enterprise(Enterprise.Builder builder) {
		
		Validator.isNotNull(builder);
		
		Validator.isNotNull(builder.entityNumber);
		this.entityNumber = builder.entityNumber;

		Validator.isNotNull(builder.status);
		this.status = builder.status;

		Validator.isNotNull(builder.juridicalSituation);
		this.juridicalSituation = builder.juridicalSituation;

		Validator.isNotNull(builder.typeOfEnterprise);
		this.typeOfEnterprise = builder.typeOfEnterprise;

		Validator.isNotNull(builder.juridicalForm);
		this.juridicalForm = builder.juridicalForm;

		Validator.isNotNull(builder.startDate);
		this.startDate = builder.startDate;

		Validator.isNotNull(builder.denominations);
		this.denominations = builder.denominations;

		Validator.isNotNull(builder.establishments);
		this.establishments = Collections.unmodifiableSet(new HashSet<>(builder.establishments));

		Validator.isNotNull(builder.addresses);
		this.addresses = Collections.unmodifiableSet(new HashSet<>(builder.addresses));

		Validator.isNotNull(builder.contacts);
		this.contacts = Collections.unmodifiableSet(new HashSet<>(builder.contacts));

		Validator.isNotNull(builder.activities);
		this.activities = Collections.unmodifiableSet(new HashSet<>(builder.activities));

	}

	public EntityNumber getEntityNumber() {
		return entityNumber;
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
		return 31 * entityNumber.hashCode();
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
		return entityNumber.equals(other.entityNumber);
	}
	
	@Override
	public String toString() {
		return "Enterprise [entityNumber=" + entityNumber + ", status=" + status + ", juridicalSituation="
				+ juridicalSituation + ", typeOfEnterprise=" + typeOfEnterprise + ", juridicalForm=" + juridicalForm
				+ ", startDate=" + startDate + ", denominations=" + denominations + ", establishments=" + establishments
				+ ", addresses=" + addresses + ", contacts=" + contacts + ", activities=" + activities + "]";
	}

	public static class Builder {
		
		private EntityNumber entityNumber;
		private Status status;
		private JuridicalSituation juridicalSituation;
		private TypeOfEnterprise typeOfEnterprise;
		private JuridicalForm juridicalForm;
		private LocalDate startDate;
		private Set<Denomination> denominations = new HashSet<>();
		private Set<Establishment> establishments = new HashSet<>();
		private Set<Address> addresses = new HashSet<>();
		private Set<Contact> contacts = new HashSet<>();
		private Set<Activity> activities = new HashSet<>();
		
		private Builder() {}
		
		public Builder withEntityNumber(EntityNumber entityNumber) {
			this.entityNumber = entityNumber;
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

		public Builder addEstablishment(Establishment establishment) {
			this.establishments.add(establishment);
			return this;
		}
		
		public Builder addEstablishments(Collection<Establishment> establishments) {
			this.establishments.addAll(establishments);
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

		public Enterprise build() {
			return new Enterprise(this);
		}

		@Override
		public String toString() {
			return "Builder [entityNumber=" + entityNumber + ", status=" + status + ", juridicalSituation="
					+ juridicalSituation + ", typeOfEnterprise=" + typeOfEnterprise + ", juridicalForm=" + juridicalForm
					+ ", startDate=" + startDate + ", denominations=" + denominations + ", establishments="
					+ establishments + ", addresses=" + addresses + ", contacts=" + contacts + ", activities="
					+ activities + "]";
		}
		
	}
	
}
