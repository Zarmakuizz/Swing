package fr.polytech.pooihm.phonebookgwt.client.controllers;

import java.util.Collection;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebook.ContactAlreadyDefinedException;
import fr.polytech.pooihm.phonebook.ContactNotDefinedException;
import fr.polytech.pooihm.phonebook.ContactUpdateException;
import fr.polytech.pooihm.phonebook.Person;
import fr.polytech.pooihm.phonebookgwt.client.model.PhoneBook;
import fr.polytech.pooihm.phonebookgwt.client.views.ModifyAddContactView;

public class ModifAddContactController {

	// Model
	private PhoneBook model;

	// Constructor
	public ModifAddContactController(PhoneBook model) {
		this.model = model;
	}

	// Display controller's view
	public void display(String fName, String sName) {
		Contact c = model.getContactOfPerson(new Person(fName, sName));
		new ModifyAddContactView(this, c.getPerson().getFirstname(), c
				.getPerson().getLastname(), c.getHomenum(), c.getOfficenum(),
				c.getCellnum());
	}

	public void display() {
		new ModifyAddContactView(this);
	}

	// Methods to respond to user actions
	// Add a new contact
	public void addContact(String fName, String sName, String homeNum,
			String workNum, String mobileNum) {
		Person p = new Person(fName, sName);
		Contact c = new Contact(p, homeNum, workNum, mobileNum);
		try {
			model.addContact(c);
		} catch (ContactAlreadyDefinedException e) {
			// ne peut pas arriver
		}

	}

	

	// Delete a contact
	public void deleteContact(String firstName, String lastName) {
		try {
			model.deleteContact(model.getContactOfPerson(new Person(firstName,
					lastName)));
			
		} catch (ContactNotDefinedException e) {
			// ne peut pas arriver
		}
	}

	// Modify a contact
	public void modifyContact(String fName, String sName, String homeNum,
			String workNum, String mobileNum) {
		Contact oldC = model.getContactOfPerson(new Person(fName, sName));
		Contact newC = new Contact(new Person(fName, sName), homeNum, workNum,
				mobileNum);
		try {
			model.modifyContact(oldC, newC);
		} catch (ContactNotDefinedException e) {
			// ne peut pas arriver 

		} catch (ContactAlreadyDefinedException e) {
			// ne peut pas arriver 

		} catch (ContactUpdateException e) {
			// ne peut pas arriver
		}
	}

	// Used to prevent in live creation of a contact with same name of an
	// existing contact
	public boolean personExist(String fName, String lName) {
		Collection<Person> persons = model.getContactsWithoutDetails(model
				.getAllContacts());
		boolean res = false;
		for (Person p : persons) {
			if (p.getFirstname().equals(fName) && p.getLastname().equals(lName)) {
				res = true;
				break;
			}
		}
		return res;
	}
}
