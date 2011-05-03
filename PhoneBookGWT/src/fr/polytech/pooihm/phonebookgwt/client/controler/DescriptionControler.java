package fr.polytech.pooihm.phonebookgwt.client.controler;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;
import fr.polytech.pooihm.phonebookgwt.client.view.Ajouter;
import fr.polytech.pooihm.phonebookgwt.client.view.Description;

public class DescriptionControler {
	
	/** Partie modèle */
	private static Modele modele;
	/** La fenêtere d'accueil */
	private Description description;
	
	public DescriptionControler(Modele modele) {
		this.modele = modele;
		description = Description.getInstance();
	}
	
	public static Contact getContact(String nom, String prenom){
	    return modele.getContactFromNames(nom, prenom);
	}
}
