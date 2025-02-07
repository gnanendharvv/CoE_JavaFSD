
public class BookNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {	
		super("Book Not Found, Try with any other Title");
	}
}
