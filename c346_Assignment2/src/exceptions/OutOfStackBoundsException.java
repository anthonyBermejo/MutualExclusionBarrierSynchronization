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
	 * Constructs an ElementNotFoundException with "Element at index does not exist" as its error
	 * message.
	 */
	public OutOfStackBoundsException() {
		super("Element does not exist.");
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
