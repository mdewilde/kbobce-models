package be.ceau.kbo.model.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import be.ceau.kbo.model.util.Validator;

/**
 * Class representing a code along with translations in zero or more languages.
 */
public abstract class Code {

	protected final String code;
	protected final Map<String, String> descriptions;
	
	public Code(String code, Map<String, String> descriptions) {
		Validator.isNotBlank(code);
		Validator.isNotNull(descriptions);
		this.code = code;
		this.descriptions = Collections.unmodifiableMap(new HashMap<>(descriptions));
	}

	public String getCode() {
		return code;
	}

	public Map<String, String> getDescriptions() {
		return descriptions;
	}

	public String getDescription(String language) {
		return descriptions.get(language);
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
		Code other = (Code) obj;
		return code.equals(other.code);
	}

	@Override
	public String toString() {
		return "Code [code=" + code + ", descriptions=" + descriptions + "]";
	}
	
}
