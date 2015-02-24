package task3;

import java.util.Arrays;

import exceptions.EmptyStackException;
import exceptions.OutOfStackBoundsException;
import task3.BlockManager;

/**
 * Class BlockStack Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $ $Last Revision Date: 2015/02/01 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca; Inspired by an earlier
 *         code by Prof. D. Probst
 */
class BlockStack {
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Task 2: Changed to private Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;

	/**
	 * Task 2: Changed to private Current top of the stack
	 */
	private int iTop = 3;

	/**
	 * Task 2: Changed to private stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] { 'a', 'b', 'c', 'd', '$', '$' };

	/**
	 * Task 1: Create class variable Task 2: Changed to private An integer
	 * counting how many times the stack was accessed
	 */
	private int stackAccessCounter;

	/**
	 * Default constructor
	 */
	public BlockStack() {
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize) {

		if (piSize != DEFAULT_SIZE) {
			
			BlockManager.mutex.P();
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for (int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char) ('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
			this.iSize = piSize;
			
			BlockManager.mutex.V();
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * 
	 * @return top element of the stack, char
	 * @throws EmptyStackException - if stack is empty
	 */
	public char pick() throws EmptyStackException {

		char top = '$';
		
		BlockManager.mutex.P();
		
		stackAccessCounter += 1;
		
		if (!isEmpty())
			top = this.acStack[this.iTop];
		else
			throw new EmptyStackException();
			
		BlockManager.mutex.V();
		
		return top;
	}

	/**
	 * Returns arbitrary value from the stack array
	 * 
	 * @return the element, char
	 * @throws OutOfStackBoundsException 
	 */
	public char getAt(final int piPosition) throws OutOfStackBoundsException {

		BlockManager.mutex.P();
		
		stackAccessCounter += 1;

		char stackChar = this.acStack[piPosition];
		
		BlockManager.mutex.V();
		
		if (piPosition >= 0 && piPosition < this.iSize) {
			return stackChar;
		}
		else
			throw new OutOfStackBoundsException();
	}

	public int getISize() {		
		return iSize;
	}

	public int getITop() {
		return iTop;
	}

	public int getAccessCounter() {
		return stackAccessCounter;
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) {
		
		BlockManager.mutex.P();
		
		stackAccessCounter += 1;

		if (isEmpty())
			this.acStack[++this.iTop] = 'a';
		else if (this.iTop < this.iSize - 1)
			this.acStack[++this.iTop] = pcBlock;
		else {
			expandArray();
			this.acStack[++this.iTop] = pcBlock;
		}
		
		BlockManager.mutex.V();
	}

	/**
	 * Standard pop operation
	 * 
	 * @return ex-top element of the stack, char
	 * @throws EmptyStackException 
	 */
	public char pop() throws EmptyStackException {
		
		char cBlock = '$';
		
		BlockManager.mutex.P();
		
		stackAccessCounter += 1;
		
		if (!isEmpty()) {
			cBlock = this.acStack[this.iTop];
			this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
		}
		else
			throw new EmptyStackException();
		
		BlockManager.mutex.V();
		
		return cBlock;
	}

	public boolean isEmpty() {
		return (this.iTop == -1);
	}

	@Override
	public String toString() {
		return "BlockStack [iSize=" + iSize + ", iTop=" + iTop + ", acStack="
				+ Arrays.toString(acStack) + ", stackAccessCounter="
				+ stackAccessCounter + "]";
	}

	/*
	 * Expands the array at double its length
	 */
	private void expandArray() {
		char[] newStack = Arrays.copyOf(acStack, acStack.length * 2);
		acStack = newStack;
		newStack = null;
		
		for (int i = this.iSize; i < acStack.length; i++)
			this.acStack[i] = '$';
		
		iSize = acStack.length;
	}
	
}

// EOF
