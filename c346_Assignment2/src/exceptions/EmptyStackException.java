package exceptions;

/**
 * Custom exception for the BlockStack array is empty
 * 
 * @author Anthony-Virgil Bermejo (6982166)
 * @version 1.0
 */
public class EmptyStackException extends Exception {

	private static final long serialVersionUID = -4808624043178555346L;

	/**
	 * Constructs an EmptyStackException with "Stack is empty" as its error
	 * message.
	 */
	public EmptyStackException() {
		super("Stack is empty");
	}

	/**
	 * Constructs a EmptyStackException with the specified message.
	 * 
	 * @param message
	 *            the error message.
	 */
	public EmptyStackException(String message) {
		super(message);
	}
}
