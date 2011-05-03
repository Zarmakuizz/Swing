package fr.polytech.pooihm.phonebookgwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import fr.polytech.pooihm.phonebookgwt.client.controllers.MainViewController;
import fr.polytech.pooihm.phonebookgwt.client.model.PhoneBook;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PhoneBookGWT implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	public void onModuleLoad() {
		// Initializing the model
		PhoneBook phoneBook = new PhoneBook();
		// Creating the main controller
		MainViewController mvc = new MainViewController(phoneBook);
		RootLayoutPanel.get().add(mvc.displayView());

	}
}
