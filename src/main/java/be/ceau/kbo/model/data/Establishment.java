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
package be.ceau.kbo.model.data;

import java.time.LocalDate;

import be.ceau.kbo.model.core.EstablishmentNumber;
import be.ceau.kbo.model.util.Validator;

/**
 * Model definition for a unit of establishment of an {@code Enterprise}
 */
public class Establishment {

	private final EstablishmentNumber establishmentNumber;

	private final LocalDate startDate;

	/**
	 * Constructor
	 * 
	 * @param establishmentNumber
	 *            non-null {@code EstablishmentNumber}
	 * @param startDate
	 *            non-null {@code LocalDate}
	 */
	public Establishment(EstablishmentNumber establishmentNumber, LocalDate startDate) {
		Validator.isNotNull(establishmentNumber, startDate);
		this.establishmentNumber = establishmentNumber;
		this.startDate = startDate;
	}

	/**
	 * @return the identifier number of this {@code Establishment}, never null
	 */
	public EstablishmentNumber getEstablishmentNumber() {
		return establishmentNumber;
	}

	/**
	 * @return the startDate of this {@code Establishment}, never null
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
		return "Establishment [establishmentNumber=" + establishmentNumber + ", localDate=" + startDate + "]";
	}

}
