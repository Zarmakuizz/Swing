package fr.polytech.pooihm.phonebook;

public class ContactAlreadyDefinedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5826369035424746765L;

	public ContactAlreadyDefinedException(String msg) {
		super(msg);
	}
}
