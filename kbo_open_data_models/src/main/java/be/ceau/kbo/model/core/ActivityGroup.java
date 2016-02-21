package be.ceau.kbo.model.core;

import java.util.Map;

import be.ceau.kbo.model.util.Validator;

public class ActivityGroup extends Code {

	public ActivityGroup(String code, Map<String, String> descriptions) {
		super(code, descriptions);
		Validator.isMaxLength(6, code);
	}

	@Override
	public int hashCode() {
		return 31 * code.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityGroup other = (ActivityGroup) obj;
		return !code.equals(other.code);
	}

	@Override
	public String toString() {
		return "ActivityGroup [code=" + code + "]";
	}

}
