package exceptions;

/**
 * Custom exception for when an index within the BlockStack array does not exist
 * 
 * @author Anthony-Virgil Bermejo (6982166)
 * @version 1.0
 */
public class OutOfStackBoundsException extends Exception {

	private static final long serialVersionUID = -5760831093153003481L;

	/**
	 * Constructs an ElementNotFoundException with "Out of stack bounds" as its error
	 * message.
	 */
	public OutOfStackBoundsException() {
		super("Out of stack bounds");
	}

	/**
	 * Constructs a ElementNotFoundException with the specified message.
	 * 
	 * @param message
	 *            the error message.
	 */
	public OutOfStackBoundsException(String message) {
		super(message);
	}
}
