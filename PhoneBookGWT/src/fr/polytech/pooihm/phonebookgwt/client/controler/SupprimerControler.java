package fr.polytech.pooihm.phonebookgwt.client.controler;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;
import fr.polytech.pooihm.phonebookgwt.client.view.Accueil;

public class SupprimerControler {
	
	private Modele modele;
	
	public SupprimerControler() {
		modele = new Modele();
	}
	
	/**
	 * On supprime un contact par son nom et prénom (la ligne affichée sur
	 * l'accueil)
	 * 
	 * @param line la ligne qu'on traite
	 * @throws Exception
	 */
	public void deleteContact(String line) throws Exception {
		Contact aSupprimer = modele.getContactFromNames(Control.getFirstNameFromLine(line), Control.getLastNameFromLine(line));
		modele.deleteContact(aSupprimer);
	}

}
