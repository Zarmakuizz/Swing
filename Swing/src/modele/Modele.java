/**
 * Classe de contrôle dans un cadre d'architecture MVC
 */
package modele;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebook.GroupNotDefinedException;
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
    
    public ArrayList<ArrayList<ArrayList<String>>> getAllGroupsPersons() throws GroupNotDefinedException{
        ArrayList<ArrayList<ArrayList<String>>> groupes = new ArrayList<ArrayList<ArrayList<String>>>();
        //On parcourt les groupes
        Iterator iter = ((Set<String>) getGroupNames()).iterator();
        while (iter.hasNext()) {
            //On parcourt les personnes
            ArrayList<ArrayList<String>> personnes = new ArrayList<ArrayList<String>>();
            for(Contact c : getContactsByGroup((String) iter.next()) ){
                ArrayList<String> personne = new ArrayList<String>();
                personne.add(c.getPerson().getFirstname());
                personne.add(c.getPerson().getLastname());
                personnes.add(personne);
            }
            groupes.add(personnes);
        }
        return groupes;
    }
    
    public ArrayList<String> getGroupes(){
        ArrayList<String> groupes = new ArrayList<String>();
        Iterator iter = ((Set<String>) getGroupNames()).iterator();
        while (iter.hasNext()) {
            groupes.add((String) iter.next());
        }
        return groupes;
    }
}
