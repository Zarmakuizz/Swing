package fr.polytech.pooihm.phonebookgwt.client.controler;

import com.google.gwt.user.client.ui.RootPanel;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebookgwt.client.PhoneBookGWT;
import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;

public class SupprimerControler {
	
	private static Modele modele;
	
	public SupprimerControler(Modele modele) {
		this.modele = modele;
	}
	
	/**
	 * On supprime un contact par son nom et prénom (la ligne affichée sur
	 * l'accueil)
	 * 
	 * @param line la ligne qu'on traite
	 * @throws Exception
	 */
	public static void deleteContact(String line) throws Exception {
		Contact aSupprimer = modele.getContactFromNames(Control.getFirstNameFromLine(line), Control.getLastNameFromLine(line));
		modele.deleteContact(aSupprimer);
	}

}
