package fr.pizzeria.exception;

@SuppressWarnings("serial")
public class NumberInvalidException extends Exception {

	public NumberInvalidException() {
		super();
	}
	public NumberInvalidException(String msg) {
		super(msg);
	}
	
}
