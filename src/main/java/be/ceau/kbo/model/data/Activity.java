package be.ceau.kbo.model.data;

import be.ceau.kbo.model.core.ActivityGroup;
import be.ceau.kbo.model.core.Classification;
import be.ceau.kbo.model.core.Nace;
import be.ceau.kbo.model.util.Validator;

/**
 * Het bestand activity.csv bevat 1 lijn per activiteit van een onderneming of
 * vestigingseenheid. Een onderneming of vestiging kan meerdere activiteiten
 * uitoefenen.
 */
public class Activity {

	private final ActivityGroup activityGroup;
	private final Nace nace;
	private final Classification classification;

	public Activity(ActivityGroup activityGroup, Nace nace, Classification classification) {
		Validator.isNotNull(activityGroup, nace, classification);
		this.activityGroup = activityGroup;
		this.nace = nace;
		this.classification = classification;
	}

	public ActivityGroup getActivityGroup() {
		return activityGroup;
	}

	public Nace getNace() {
		return nace;
	}

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
		if (!nace.equals(other.nace))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Activity [activityGroup=" + activityGroup + ", nace=" + nace + ", classification=" + classification
				+ "]";
	}

}
