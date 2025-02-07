
public class MaxBooksAllowedException extends Exception {

	private static final long serialVersionUID = 1L;

	public MaxBooksAllowedException() {
		super("Maximum Book lending limit Reached");
	}
}