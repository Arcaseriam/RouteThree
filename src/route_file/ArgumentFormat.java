package route_file;

public class ArgumentFormat {
	private Class<?> argClass;
	private ArgumentNecessity type;
	private String fieldName;
	private Object defaultValue;
	
	public ArgumentFormat(Class<?> argClass, ArgumentNecessity type, String fieldName, Object defaultValue) {
		this.argClass = argClass;
		this.type = type;
		this.fieldName = fieldName;
		this.defaultValue = setDefaultValue(defaultValue);
	}
	
	public ArgumentFormat(Class<?> argClass, ArgumentNecessity type, String fieldName){
		this(argClass, type, fieldName, null);
	}

	
	public Class<?> getArgClass() {
		return argClass;
	}
	
	public ArgumentNecessity getType() {
		return type;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	// Ready to be casted
	public Object getDefaultValue() {
		return defaultValue;
	}
	
	private Object setDefaultValue(Object defaultValue) {
		Object casted = null;
		if(defaultValue != null && argClass.isInstance(defaultValue))
			casted = argClass.cast(defaultValue);
		
		return casted;
	}
}
