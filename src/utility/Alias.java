package utility;

public class Alias {
	private String alias;
	
	public Alias(String alias) {
		this.alias = alias;
	}
	
	private String getRealAlias() {
		return alias;
	}
	
	@Override
	public String toString() {
		return alias.toUpperCase();
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if(this == other)
			return true;
		
		if(alias == null || other == null)
			return false;
		
		String otherAliasStr = null;
		if(other instanceof String)
			otherAliasStr = (String)other;
		else if(other instanceof Alias)
			otherAliasStr = ((Alias)other).toString();
		else
			return false;
		
		if(otherAliasStr == null)
			return false;
		
		return alias.equalsIgnoreCase(otherAliasStr);
	}
}
