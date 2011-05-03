package fr.polytech.pooihm.phonebookgwt.client.controler;

import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;

public class Control {

	private static Modele modele;
	
	public Control() {
		modele = new Modele();
	}
	
	
	public static String getFirstNameFromLine(String line) throws Exception {
		String prenom = null;
		// on vérifie que la ligne est bien celle d'un contact valide --Prénom Nom
		if (line.startsWith("--") && line.contains(" ")) {
			line = line.substring(2, line.length());
			prenom = line.substring(0, line.indexOf(" ") - 1);
		} else
			throw new Exception("deletion failed");
		return prenom;
	}
	
	public static String getLastNameFromLine(String line) throws Exception {
		String nom = null;
		// on vérifie que la ligne est bien celle d'un contact valide --Prénom Nom
		if (line.startsWith("--") && line.contains(" ")) {
			line = line.substring(2, line.length());
			nom = line.substring(line.indexOf(" "), line.length());
		} else
			throw new Exception("deletion failed");
		return nom;
	}
	
}
