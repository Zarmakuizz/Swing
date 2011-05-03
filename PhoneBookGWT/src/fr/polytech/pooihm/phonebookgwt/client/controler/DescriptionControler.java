package fr.polytech.pooihm.phonebookgwt.client.controler;

import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;
import fr.polytech.pooihm.phonebookgwt.client.view.Ajouter;
import fr.polytech.pooihm.phonebookgwt.client.view.Description;

public class DescriptionControler {
	
	/** Partie modèle */
	private Modele modele;
	/** La fenêtere d'accueil */
	private Description description;
	
	public DescriptionControler(Modele modele) {
		this.modele = modele;
		description = Description.getInstance();
	}
	
}
