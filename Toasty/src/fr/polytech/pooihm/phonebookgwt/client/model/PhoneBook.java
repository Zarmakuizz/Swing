package fr.polytech.pooihm.phonebookgwt.client.model;

import java.util.ArrayList;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebook.ContactAlreadyDefinedException;
import fr.polytech.pooihm.phonebook.ContactNotDefinedException;
import fr.polytech.pooihm.phonebook.ContactUpdateException;
import fr.polytech.pooihm.phonebook.Person;
import fr.polytech.pooihm.phonebookgwt.client.listeners.ContactAddedToGroupEvent;
import fr.polytech.pooihm.phonebookgwt.client.listeners.ContactListeChangedEvent;
import fr.polytech.pooihm.phonebookgwt.client.listeners.ContactListeListener;
import fr.polytech.pooihm.phonebookgwt.client.listeners.GroupsListener;

public class PhoneBook extends fr.polytech.pooihm.phonebook.PhoneBook {

	// Attribute
	private ContactListeListener contactsListener;
	private GroupsListener groupsListener;

	// Constructor
	public PhoneBook() {
		super();
	}

	// Overrided methods
	@Override
	public void addContact(Contact c) throws ContactAlreadyDefinedException {
		fireContactAddedToGroup("All");
		super.addContact(c);
		fireContactsChanged();
	}

	@Override
	public void deleteContact(Contact c) throws ContactNotDefinedException {
		fireContactAddedToGroup("All");
		super.deleteContact(c);
		fireContactsChanged();
	}

	@Override
	public void modifyContact(Contact c, Contact newc)
			throws ContactNotDefinedException, ContactAlreadyDefinedException,
			ContactUpdateException {
		fireContactAddedToGroup("All");
		super.modifyContact(c, newc);
		fireContactsChanged();
	}

	// Added method
	// use to get a contact corresponding to the person p
	public Contact getContactOfPerson(Person p) {
		Contact res = null;
		if (p != null) {
			for (Contact c : getAllContacts()) {
				if (c.getPerson().getFirstname().toLowerCase()
						.equals(p.getFirstname().toLowerCase())
						&& c.getPerson().getLastname().toLowerCase()
								.equals(p.getLastname().toLowerCase()))
					res = c;
			}
		}
		return res;
	}

	// MVC Methods
	// Alert views
	private void fireContactsChanged() {
		ArrayList<String> firstNames = new ArrayList<String>();
		ArrayList<String> lastNames = new ArrayList<String>();
		int i = 0;
		for (Contact c : getAllContacts()) {
			firstNames.add(i, c.getPerson().getFirstname());
			lastNames.add(i, c.getPerson().getLastname());
			i++;
		}
		contactsListener.update(new ContactListeChangedEvent(this, firstNames,
				lastNames));
	}

	private void fireContactAddedToGroup(String gName) {
		groupsListener.contactAddedToGroup(new ContactAddedToGroupEvent(this,
				gName));
	}

	// Adding listeners
	public void addContactListener(ContactListeListener l) {
		contactsListener = l;
	}

	public void addGroupsListener(GroupsListener l) {
		groupsListener = l;
	}
}
