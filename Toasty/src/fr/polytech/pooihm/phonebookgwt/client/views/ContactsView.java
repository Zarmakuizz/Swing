package fr.polytech.pooihm.phonebookgwt.client.views;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.polytech.pooihm.phonebookgwt.client.controllers.MainViewController;
import fr.polytech.pooihm.phonebookgwt.client.listeners.ContactListeChangedEvent;
import fr.polytech.pooihm.phonebookgwt.client.listeners.ContactListeListener;

public class ContactsView extends Composite implements ContactListeListener {

	// Graphical attributes
	private Button button;
	private Label label;
	private ListBox liste;

	// Attributes
	private MainViewController controller;
	private ArrayList<String> lastNames;
	private ArrayList<String> firstNames;

	public ContactsView(MainViewController mainViewController,
			ArrayList<String> firstName, ArrayList<String> lastName) {

		this.controller = mainViewController;
		buildFrame(firstName, lastName);
	}

	// Methods
	private void buildFrame(ArrayList<String> firstName,
			ArrayList<String> lastName) {
		// Configuring the panel
		VerticalPanel panel = new VerticalPanel();
		HorizontalPanel panel2 = new HorizontalPanel();
		// Initializing graphical components
		liste = new ListBox();
		liste.setVisibleItemCount(2);

		fillListe(firstName, lastName);

		liste.setSize("100%", "100%");
		liste.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				int i = liste.getSelectedIndex();
				controller.selectedContactChanged(firstNames.get(i),
						lastNames.get(i));
			}
		});

		liste.addDoubleClickHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				int i = liste.getSelectedIndex();
				controller.modifyContact(firstNames.get(i), lastNames.get(i));
			}
		});

		liste.setSelectedIndex(0);
		controller.selectedContactChanged(firstNames.get(0), lastNames.get(0));

		label = new Label("Contacts");
		button = new Button("+");
		
		
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.addContact();
			}
		});

		// Adding components to panel
		panel2.add(label);
		panel2.add(button);
		panel2.setWidth("100%");

		panel2.setCellHorizontalAlignment(label, HorizontalPanel.ALIGN_LEFT);
		panel2.setCellHorizontalAlignment(button, HorizontalPanel.ALIGN_RIGHT);

		panel.add(panel2);
		panel.add(liste);

		panel.setCellHeight(panel2, "24px");
		panel.setCellHeight(liste, "100%");

		this.initWidget(panel);
	}

	// Method used to display contacts of a particular group (called when
	// selected group changed)
	public void changeContactList(ArrayList<String> newFirstName,
			ArrayList<String> newLastName) {
		fillListe(newFirstName, newLastName);
		if(!newFirstName.isEmpty())
			controller.selectedContactChanged(firstNames.get(0), lastNames.get(0));

	}

	private void fillListe(ArrayList<String> firstName,
			ArrayList<String> lastName) {
		liste.clear();
		this.lastNames = lastName;
		this.firstNames = firstName;
		for (int i = 0; i < lastNames.size(); i++) {
			liste.addItem(firstNames.get(i) + " " + lastNames.get(i));
		}
		liste.setSelectedIndex(0);
	}

	@Override
	public void update(ContactListeChangedEvent evt) {
		fillListe(evt.getFirstNames(), evt.getLastNames());
		if(!evt.getFirstNames().isEmpty()) 
			controller.selectedContactChanged(firstNames.get(0), lastNames.get(0));
		else {
			controller.clearContactInfoView();
		}


	}
}
