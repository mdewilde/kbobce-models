package be.ceau.kbo.model.core;

import java.util.Map;

/**
 * <strong>Nomenclature génerale des Activités économiques dans les Communautées Européennes</strong>
 * <a href="http://statbel.fgov.be/nl/statistieken/gegevensinzameling/nomenclaturen/nacebel/">source</a>
 */
public class Nace extends Code {

	private final int year;
	
	public Nace(int year, String code, Map<String, String> descriptions) {
		super(code, descriptions);
		if (year != 2003 && year != 2008) {
			throw new IllegalArgumentException("Nace year must be 2003 or 2008");
		}
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code.hashCode();
		result = prime * result + year;
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
		Nace other = (Nace) obj;
		if (code != other.code)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nace [year=" + year + ", code=" + code + "]";
	}
	
}
