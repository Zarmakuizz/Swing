package fr.polytech.pooihm.phonebookgwt.client.controllers;

import java.util.ArrayList;
import java.util.Collection;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebook.GroupNotDefinedException;
import fr.polytech.pooihm.phonebook.Person;
import fr.polytech.pooihm.phonebookgwt.client.model.PhoneBook;
import fr.polytech.pooihm.phonebookgwt.client.views.ContactInfoView;
import fr.polytech.pooihm.phonebookgwt.client.views.ContactsView;
import fr.polytech.pooihm.phonebookgwt.client.views.GroupView;
import fr.polytech.pooihm.phonebookgwt.client.views.MainWindow;

public class MainViewController {

	// View handled by this controller
	private ContactInfoView ctInfoView = null;
	private ContactsView ctsView = null;
	private GroupView grView = null;
	private MainWindow mainView = null;

	// Model
	private PhoneBook model = null;

	// Constructor
	public MainViewController(PhoneBook phoneBook) {
		this.model = phoneBook;
		ctInfoView = new ContactInfoView(this);

		ctsView = new ContactsView(this,
				getFirstName(model.getContactsWithoutDetails(model
						.getAllContacts())),
				getLastName(model.getContactsWithoutDetails(model
						.getAllContacts())));
		grView = new GroupView(this, model.getGroupNames());
		mainView = new MainWindow(grView, ctsView, ctInfoView);
		addListenersToModel();
	}

	private ArrayList<String> getFirstName(
			Collection<Person> contactsWithoutDetails) {
		ArrayList<String> firstName = new ArrayList<String>();
		for (Person p : contactsWithoutDetails) {
			firstName.add(p.getFirstname());
		}
		return firstName;
	}

	private ArrayList<String> getLastName(
			Collection<Person> contactsWithoutDetails) {
		ArrayList<String> firstName = new ArrayList<String>();
		for (Person p : contactsWithoutDetails) {
			firstName.add(p.getLastname());
		}
		return firstName;
	}

	// Linking model and view
	private void addListenersToModel() {
		model.addContactListener(ctsView);
		model.addGroupsListener(grView);
	}

	public MainWindow displayView() {
		return mainView;
	}

	// Action performed method
	// Add contact button clicked
	public void addContact() {
		ModifAddContactController controller = new ModifAddContactController(
				model);

		controller.display();
	}

	// Modify contact button clicked
	public void modifyContact(String fName, String lName) {
		ModifAddContactController controller = new ModifAddContactController(
				model);
		controller.display(fName, lName);
	}

	// Double click on a contact
	public void modifyContact(Object selectedValue) {
		modifyContact(model.getContactOfPerson((Person) selectedValue));
	}

	// Selected contact has changed, update ContactInfoView
	public void selectedContactChanged(String firstName, String lastName) {
		Contact contact = model.getContactOfPerson(new Person(firstName,
				lastName));
		ctInfoView.setContactToDisplay(contact.getPerson().getFirstname(),
				contact.getPerson().getLastname(), contact.getHomenum(),
				contact.getOfficenum(), contact.getCellnum());
	}

	// Selected group has changed, filtering contact list
	public void selectedGroupChanged(Object selectedValue) {
		String groupName = (String) selectedValue;
		if (groupName.equals("All")) {
			ctsView.changeContactList(getFirstName(model
					.getContactsWithoutDetails(model.getAllContacts())),
					getLastName(model.getContactsWithoutDetails(model
							.getAllContacts())));
		} else
			try {
				ctsView.changeContactList(getFirstName(model
						.getContactsWithoutDetails(model
								.getContactsByGroup(groupName))),
						getLastName(model.getContactsWithoutDetails(model
								.getContactsByGroup(groupName))));
			} catch (GroupNotDefinedException e) {

			}
	}
	
	//No more contacts selected, clearing ContactInfoView
	public void clearContactInfoView(){
		ctInfoView.clearView();
	}	

}
