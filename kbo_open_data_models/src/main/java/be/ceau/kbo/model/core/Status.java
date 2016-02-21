package be.ceau.kbo.model.core;

import java.util.Map;

import be.ceau.kbo.model.util.Validator;

public class Status extends Code {

	public Status(String code, Map<String, String> descriptions) {
		super(code, descriptions);
		Validator.isLength(2, code);
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
		Status other = (Status) obj;
		return !code.equals(other.code);
	}

	@Override
	public String toString() {
		return "Status [code=" + code + "]";
	}

}
