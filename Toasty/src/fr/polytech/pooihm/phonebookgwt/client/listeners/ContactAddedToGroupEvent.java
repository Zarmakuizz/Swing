package fr.polytech.pooihm.phonebookgwt.client.listeners;

import java.util.EventObject;

public class ContactAddedToGroupEvent extends EventObject {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	// Attribute
	private String name;

	// Constructor
	public ContactAddedToGroupEvent(Object source, String gName) {
		super(source);
		name = gName;
	}

	// Getter
	public String getGroupName() {
		return name;
	}

}
