package fr.polytech.pooihm.phonebookgwt.client.controler;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebook.ContactAlreadyDefinedException;
import fr.polytech.pooihm.phonebook.Person;
import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;
import fr.polytech.pooihm.phonebookgwt.client.view.Ajouter;

public class AjouterControler {

	/** Partie modèle */
	private static Modele modele;
	/** La fenêtere d'accueil */
	private Ajouter ajouter;
	
	public AjouterControler(Modele modele) {
		this.modele = modele;
		ajouter = Ajouter.getInstance();
	}
	
    public static void ajouterContact(String nom, String prenom,
            String telMaison, String telBureau, String telMobile)
            throws ContactAlreadyDefinedException{
	    modele.addContact(new Contact(new Person(nom,prenom),telMaison,telBureau,telMobile));
	}
}
