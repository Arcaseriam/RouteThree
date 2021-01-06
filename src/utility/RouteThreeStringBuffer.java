package utility;

public class RouteThreeStringBuffer {
	private StringBuilder sb;
	
	public RouteThreeStringBuffer() {
		sb = new StringBuilder();
	}
	
	public void append(String str) {
		sb.append(str);
	}
	
	public void appendln(String str) {
		append(str);
		appendln();
	}

	/*
	public void appendln(Object obj) {
		if(obj != null)
			appendln(obj.toString());
	}
	*/
	
	public void appendln() {
		append(Constants.ENDL);
	}
	
	@Override
	public String toString() {
		return sb.toString();
	}

}
