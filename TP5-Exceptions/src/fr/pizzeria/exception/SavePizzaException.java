package fr.pizzeria.exception;

@SuppressWarnings("serial")
public class SavePizzaException extends PizzaException {

	public SavePizzaException() {
		super();
	}
	public SavePizzaException(String msg) {
		super(msg);
	}
	
}
