package route_file;

public interface GameActionConfigurable {
	public GameActionPerformable configureWith(ParsableList<String> line) throws Exception;
}
