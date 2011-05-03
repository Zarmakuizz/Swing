/**
 * Classe de contrôle dans un cadre d'architecture MVC
 */
package fr.polytech.pooihm.phonebookgwt.client.modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebook.GroupNotDefinedException;
import fr.polytech.pooihm.phonebook.Person;

/**
 * Cette classe fait la jonction entre le modèle livré et l'architecture MVC à
 * mettre en place.
 * 
 * @author Zarmakuizz
 * @author namor
 */

public class Modele extends fr.polytech.pooihm.phonebook.PhoneBook {
	
	public static final String ALL_CONTACTS_GROUP_NAME = "Tous les contacts";

    /**
     * Renvoit un ArrayList d'ArrayList de string contenant les noms et prénoms
     * de toutes les personnes
     * 
     * @return personnes L'ArrayList d'ArrayList des noms et prénoms de chaque
     *         personne
     */
    public ArrayList<ArrayList<String>> getAllPersons() {
        ArrayList<ArrayList<String>> personnes = new ArrayList<ArrayList<String>>();
        // On parcourt la totalité des personnes
        for (Contact c : getAllContacts()) {
            ArrayList<String> personne = new ArrayList<String>();
            personne.add(c.getPerson().getFirstname());
            personne.add(c.getPerson().getLastname());
            personnes.add(personne);
        }
        return personnes;
    }
    
	/**
	 * Renvoit une ArrayList de chaque groupe, contenant une ArrayList de chaque
	 * personne, contenant une ArrayList avec en 0 le prénom et en 1 le nom
	 * Méthode très lourde
	 * 
	 * @return groupes
	 * @throws GroupNotDefinedException
	 */
    public ArrayList<ArrayList<ArrayList<String>>> getAllGroupsPersons()
            throws GroupNotDefinedException {
        ArrayList<ArrayList<ArrayList<String>>> groupes = new ArrayList<ArrayList<ArrayList<String>>>();
        // On parcourt les groupes
        Iterator iter = ((Set<String>) getGroupNames()).iterator();
        while (iter.hasNext()) {
            // On parcourt les personnes
            ArrayList<ArrayList<String>> personnes = new ArrayList<ArrayList<String>>();
            for (Contact c : getContactsByGroup((String) iter.next())) {
                ArrayList<String> personne = new ArrayList<String>();
                personne.add(c.getPerson().getFirstname());
                personne.add(c.getPerson().getLastname());
                personnes.add(personne);
            }
            groupes.add(personnes);
        }
        return groupes;
    }
    
    /**
     * Renvoit la liste des noms de groupes
     * @return groupes les noms des groupes existants
     */
    public ArrayList<String> getGroupes() {
        ArrayList<String> groupes = new ArrayList<String>();
        Iterator iter = ((Set<String>) getGroupNames()).iterator();
        while (iter.hasNext()) {
            groupes.add((String) iter.next());
        }
        return groupes;
    }
    
    /**
     * Renvoit un ArrayList de String contenant chacune des lignes à afficher sur l'accueil
     * @return affichage l'affichage de la liste à raffraichir
     * @throws GroupNotDefinedException 
     */
    public ArrayList<String> getAffichage(String groupStar) throws GroupNotDefinedException{
    	ArrayList<String> affichage = new ArrayList<String>();
    	//on crée le groupe contentnat tout le monde et on teste si c'est le groupe étendu
    	affichage.add(ALL_CONTACTS_GROUP_NAME);
        if(groupStar.equals(ALL_CONTACTS_GROUP_NAME)){
        	for (Contact c : getAllContacts()) {
                affichage.add("--"+c.getPerson().getFirstname()+" "+c.getPerson().getLastname());
            }
        }
        // On parcourt les groupes
        for(String gr : getGroupes()) {
        	//groupe ajouté
        	affichage.add(gr);
        	//Si le groupe est étendu
        	if(gr.equals(groupStar)){
	            // On parcourt les personnes
	            for (Contact c : getContactsByGroup(gr)) {
	                affichage.add("--"+c.getPerson().getFirstname()+" "+c.getPerson().getLastname());
	            }
        	}
        }
        return affichage;
    }

	/**
	 * Permet d'obtenir un objet contact à partir du prénom et nom
	 * 
	 * @param firstName
	 *            le prénom
	 * @param lastName
	 *            le nom
	 * @return contact le contact
	 */
	public Contact getContactFromNames(String firstName, String lastName) {
		Person person = new Person(firstName, lastName);
		Contact contact = null;
		for (Contact c : getAllContacts()) {
			if (c.getPerson().getFirstname().toLowerCase().equals(
					person.getFirstname().toLowerCase())
					&& c.getPerson().getLastname().toLowerCase().equals(
							person.getLastname().toLowerCase()))
				contact = c;
		}
		return contact;
	}

}
