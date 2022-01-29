package com.sample.demo.exceptions;

public class StackOverflowBusinesssException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String e;

	public StackOverflowBusinesssException(String e) {
		super(e);
		this.e = e;
	}
}
