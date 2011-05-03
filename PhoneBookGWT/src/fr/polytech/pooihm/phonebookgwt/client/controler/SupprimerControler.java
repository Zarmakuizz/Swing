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
		// on vérifie que la ligne est bien celle d'un contact valide --Prénom Nom
		if (line.startsWith("--") && line.contains(" ")) {
			line = line.substring(2, line.length());
			String prenom = line.substring(0, line.indexOf(" ") - 1);
			String nom = line.substring(line.indexOf(" "), line.length());
			Contact aSupprimer = modele.getContactFromNames(prenom, nom);
			modele.deleteContact(aSupprimer);
		} else
			throw new Exception("deletion failed");
	}

}
