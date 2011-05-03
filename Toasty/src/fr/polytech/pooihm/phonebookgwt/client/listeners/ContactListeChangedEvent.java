package fr.polytech.pooihm.phonebookgwt.client.listeners;

import java.util.ArrayList;
import java.util.EventObject;

public class ContactListeChangedEvent extends EventObject {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	// Attributes
	private ArrayList<String> firstNames;
	private ArrayList<String> lastNames;

	// Constructor
	public ContactListeChangedEvent(Object arg0, ArrayList<String> fNames,
			ArrayList<String> lNames) {
		super(arg0);
		firstNames = fNames;
		lastNames = lNames;
	}

	// Getter
	public ArrayList<String> getFirstNames() {
		return firstNames;
	}

	public ArrayList<String> getLastNames() {
		return lastNames;
	}

}
