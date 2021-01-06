package route_file;

import java.util.Arrays;
import java.util.LinkedList;

public class ParsableList<T> {
	private LinkedList<T> queue;
	
	// This is safe because what matters is that the arguments are of type T, not that the whole object is of type T[]
	@SafeVarargs
	public ParsableList(T... args) {
		this.queue = new LinkedList<T>(Arrays.asList(args));
	}
	
	public T peek() {
		return this.queue.peek();
	}
	
	public T poll() {
		return this.queue.poll();
	}
}
