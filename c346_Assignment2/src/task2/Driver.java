package task2;

import task2.*;
import exceptions.EmptyStackException;
import exceptions.OutOfStackBoundsException;

public class Driver {
	public static void main (String[] args) {
		
		try {
			BlockStack stack = new BlockStack();
			System.out.println(stack);
			
			// pop method testing
			System.out.println(stack.pop());
			System.out.println(stack);
			
			System.out.println(stack.pop());
			System.out.println(stack);
			System.out.println(stack.pop());
			System.out.println(stack);
			System.out.println(stack.pop());
			System.out.println(stack);
			
			// throws emptystackexception
			// System.out.println(stack.pop()); 
			
			// throws positionnotfoundexception
			//System.out.println(stack.getAt(0));
			
			// push method testing
			stack.push('z');
			System.out.println(stack);
			stack.push('b');
			System.out.println(stack);
			stack.push('c');
			System.out.println(stack);
			stack.push('d');
			System.out.println(stack);
			stack.push('e');
			System.out.println(stack);
			stack.push('x');
			System.out.println(stack);
			stack.push('y');
			System.out.println(stack);


			
			// getAt method testing
			System.out.println(stack.getAt(stack.getITop()));
			System.out.println(stack.getAt(0));
			
			// throws elementnotfoundexception
			//System.out.println(stack.getAt(-1));
			//System.out.println(stack.getAt(6));
			
		}
		catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		} catch (OutOfStackBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
}
