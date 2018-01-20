/*
	Copyright 2018 Marceau Dewilde <m@ceau.be>
	
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

import be.ceau.kbobce.codes.ActivityGroup;
import be.ceau.kbobce.codes.Classification;
import be.ceau.kbobce.codes.Nace;
import be.ceau.kbobce.validate.Validator;

/**
 * An activity of an {@code Enterprise}
 */
public class Activity implements Serializable {

	private static final long serialVersionUID = -8162508698551226674L;

	private final ActivityGroup activityGroup;
	
	private final Nace nace;
	
	private final Classification classification;

	/**
	 * Constructor
	 * 
	 * @param activityGroup
	 *            not null {@code ActivityGroup}
	 * @param nace
	 *            not null {@code Nace}
	 * @param classification
	 *            not null {@code Classification}
	 */
	public Activity(ActivityGroup activityGroup, Nace nace, Classification classification) {
		Validator.isNotNull(activityGroup, nace, classification);
		this.activityGroup = activityGroup;
		this.nace = nace;
		this.classification = classification;
	}

	/**
	 * @return the group of this {@code Activity}, never {@code null}
	 */
	public ActivityGroup getActivityGroup() {
		return activityGroup;
	}

	/**
	 * @return the NACE code of this {@code Activity}, never {@code null}
	 */
	public Nace getNace() {
		return nace;
	}

	/**
	 * @return the classification of this {@code Activity}, never {@code null}
	 */
	public Classification getClassification() {
		return classification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activityGroup.hashCode();
		result = prime * result + classification.hashCode();
		result = prime * result + nace.hashCode();
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
		Activity other = (Activity) obj;
		if (!activityGroup.equals(other.activityGroup))
			return false;
		if (!classification.equals(other.classification))
			return false;
		return nace.equals(other.nace);
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Activity [activityGroup=")
				.append(activityGroup)
				.append(", nace=")
				.append(nace)
				.append(", classification=")
				.append(classification)
				.append("]")
				.toString();
	}


}
