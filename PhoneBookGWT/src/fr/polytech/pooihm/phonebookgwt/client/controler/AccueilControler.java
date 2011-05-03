package fr.polytech.pooihm.phonebookgwt.client.controler;

import fr.polytech.pooihm.phonebookgwt.client.modele.Exception;
import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;
import fr.polytech.pooihm.phonebookgwt.client.view.Accueil;

public class AccueilControler {
	/** Partie modèle */
	private static Modele modele;
	/** La fenêtere d'accueil */
	private static Accueil accueil;

	/** initialise et lance la fenetre principale */
	public AccueilControler() {
		accueil = new Accueil();
		// accueil.setVisible(true);
		modele = new Modele();

		/*
		 * accueil.fillAllPersons(modele.getAllPersons()); try {
		 * accueil.fillTheTree(modele.getAllGroupsPersons(),
		 * modele.getGroupes()); } catch (GroupNotDefinedException e) { //On
		 * affiche une fenetre d'erreur pour informer l'utilisateur
		 * JOptionPane.showMessageDialog( accueil, "Ce groupe n'existe pas.",
		 * "Attention", JOptionPane.WARNING_MESSAGE); }
		 */
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
	
    /**
     * On supprime un contact par son nom et prénom (la ligne affichée sur l'accueil)
     * @param line
     * @throws Exception
     */
    public void deleteContact(String line) throws Exception{
    	//on vérifie que la ligne est bien celle d'un contact valide --Prénom Nom
    	if(line.startsWith("--") && line.contains(" ")){
    		line = line.substring(2, line.length());
    		String prenom = line.substring(0, line.)
    	}
    	else throw new Exception("deletion failed");
    }

}