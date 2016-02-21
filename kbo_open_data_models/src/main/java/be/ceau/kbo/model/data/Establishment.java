package be.ceau.kbo.model.data;

import java.time.LocalDate;

import be.ceau.kbo.model.core.EstablishmentNumber;
import be.ceau.kbo.model.util.Validator;

/**
 * Het bestand establishment.csv bevat 1 lijn per vestigingseenheid met enkele basisgegevens.
* "EstablishmentNumber","StartDate","EnterpriseNumber"
 */
public class Establishment {


	private final EstablishmentNumber establishmentNumber;
	private final LocalDate localDate;

	public Establishment(EstablishmentNumber establishmentNumber, LocalDate localDate) {
		Validator.isNotNull(establishmentNumber, localDate);
		this.establishmentNumber = establishmentNumber;
		this.localDate = localDate;
	}

	public EstablishmentNumber getEstablishmentNumber() {
		return establishmentNumber;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + establishmentNumber.hashCode();
		result = prime * result + localDate.hashCode();
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
		return localDate.equals(other.localDate);
	}

	@Override
	public String toString() {
		return "Establishment [establishmentNumber=" + establishmentNumber + ", localDate=" + localDate + "]";
	}
	
}
