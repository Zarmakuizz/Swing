package fr.polytech.pooihm.phonebookgwt.client.controler;

import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;
import fr.polytech.pooihm.phonebookgwt.client.view.Ajouter;

public class AjouterControler {

	/** Partie modèle */
	private Modele modele;
	/** La fenêtere d'accueil */
	private Ajouter ajouter;
	
	public AjouterControler(Modele modele) {
		this.modele = modele;
		ajouter = Ajouter.getInstance();
	}
	
}
