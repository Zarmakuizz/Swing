/**
 * Classe de contrôle dans un cadre d'architecture MVC
 */
package modele;

import java.util.ArrayList;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebook.PhoneBook;


/**
 * @author namor
 */

public class Modele extends PhoneBook{
    
    /**
     * Renvoit un ArrayList d'ArrayList de string contenant les noms et prénoms de toutes les personnes
     * @return personnes L'ArrayList d'ArrayList des noms et prénoms de chaque personne
     */
    public ArrayList<ArrayList<String>> getAllPersons(){
        ArrayList<ArrayList<String>> personnes = new ArrayList<ArrayList<String>>();
        //On parcourt la totalité des personnes
        for(Contact c : getAllContacts()){
            ArrayList<String> personne = new ArrayList<String>();
            personne.add(c.getPerson().getFirstname());
            personne.add(c.getPerson().getLastname());
            personnes.add(personne);
        }
        return personnes;
    }
}
