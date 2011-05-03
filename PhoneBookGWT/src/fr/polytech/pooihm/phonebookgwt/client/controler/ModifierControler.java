package fr.polytech.pooihm.phonebookgwt.client.controler;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;
import fr.polytech.pooihm.phonebookgwt.client.view.Modifier;

public class ModifierControler {
	
	/** Partie modèle */
	private static Modele modele;
	/** La fenêtere d'accueil */
	private Modifier modifier;
	
	public ModifierControler(Modele modele) {
		this.modele = modele;
		modifier = Modifier.getInstance();
	}

    public static Contact getContact(String nom, String prenom){
        return modele.getContactFromNames(nom, prenom);
    }
}
