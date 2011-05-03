package fr.polytech.pooihm.phonebookgwt.client.controler;

import fr.polytech.pooihm.phonebook.GroupNotDefinedException;
import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;
import fr.polytech.pooihm.phonebookgwt.client.view.Accueil;

public class AccueilControler {
	/** Partie modèle */
	private static Modele modele;
	/** La fenêtere d'accueil */
	private static Accueil accueil;

	/** initialise et lance la fenetre principale */

	public AccueilControler(Modele modele) {
		this.modele = modele;
		accueil = Accueil.getInstance();
	}

	/**
	 * Rafraichit la vue principale
	 * @throws GroupNotDefinedException 
	 */
	public static void refresh(){
		refresh(Modele.ALL_CONTACTS_GROUP_NAME);
	}
	
	public static void refresh(String groupe){
		accueil.resetList();
		try {
			for(String contact : modele.getAffichage(groupe)){
				accueil.addContact(contact);
			}
		} catch (GroupNotDefinedException e) {
			//ca veut juste dire que le groupe principal a été choisi
			//rien à faire ici
		}
	}
	
	/** Demande si on est sur de supprimer */
	public void vueSuppression() {
		/*
		 * int n = JOptionPane.showConfirmDialog( accueil,
		 * "Etes-vous sûr de vouloir supprimer ?", "Danger critique !",
		 * JOptionPane.YES_NO_OPTION);
		 * 
		 * if(n==0) ouiSuppression(); else nonSuppression();
		 */
	}

	/** Permet d'accéder au modèle */
	public Modele getModel() {
		return modele;
	}

	/** Supprime */
	public void ouiSuppression() {
	}

	/** Annule la suppression */
	public void nonSuppression() {

	}

	/** Permet de charger le groupe sélectionné */
	public void selectionGroupe() {

	}
	

}