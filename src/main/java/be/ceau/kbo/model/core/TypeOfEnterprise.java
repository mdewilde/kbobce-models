package be.ceau.kbo.model.core;

import java.util.Map;

import be.ceau.kbo.model.util.Validator;

public class TypeOfEnterprise extends Code {
	
	public TypeOfEnterprise(String code, Map<String, String> descriptions) {
		super(code, descriptions);
		Validator.isLength(1, code);
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
		TypeOfEnterprise other = (TypeOfEnterprise) obj;
		return !code.equals(other.code);
	}

	@Override
	public String toString() {
		return "TypeOfEnterprise [code=" + code + "]";
	}

}
