/*
	Copyright 2017 Marceau Dewilde <m@ceau.be>
	
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
package be.ceau.kbobce.codes;

import java.io.Serializable;
import java.util.Map;

import be.ceau.kbobce.validate.Validator;

/**
 * A code used in the KBO/BCE dataset, along with translations in zero or more
 * languages.
 */
public abstract class Code implements Serializable {

	private static final long serialVersionUID = 4667958339551715533L;

	protected final String code;
	
	protected final String nl;
	protected final String fr;
	protected final String de;

	/**
	 * Constructor
	 * 
	 * @param code
	 *            a {@link String}, not {@code blank}
	 * @param descriptions
	 *            a {@link String}, not {@code null}
	 */
	public Code(String code, Map<String, String> descriptions) {
		Validator.isNotBlank(code);
		Validator.isNotNull(descriptions);
		this.code = code;
		this.nl = descriptions.get("NL");
		this.fr = descriptions.get("FR");
		this.de = descriptions.get("DE");
	}

	/**
	 * @return a non blank {@link String}
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return Dutch translation {@link String}, or {@code null}
	 */
	public String getNl() {
		return nl;
	}

	/**
	 * @return French translation {@link String}, or {@code null}
	 */
	public String getFr() {
		return fr;
	}

	/**
	 * @return German translation {@link String}, or {@code null}
	 */
	public String getDe() {
		return de;
	}

	@Override
	public int hashCode() {
		return code.hashCode();
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
		return new StringBuilder()
				.append("Code [code=")
				.append(code)
				.append(", nl=")
				.append(nl)
				.append(", fr=")
				.append(fr)
				.append(", de=")
				.append(de)
				.append("]")
				.toString();
	}

	
}