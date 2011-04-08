/**
 * Classe de contrôle dans un cadre d'architecture MVC
 */
package controle;

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebook.ContactAlreadyDefinedException;
import fr.polytech.pooihm.phonebook.Person;
import vue.Ajouter;


/**
 * @author namor
 */

public class AjouterControler extends DetailControler{
    
    /** Lance la vue Ajouter */
    public static void vueAjout(){
        vue = new Ajouter();
        vue.setVisible(true);
    }
    
    /** Ajoute le contact */
    public static void validerAjout(String nom, String prenom, String telM, String telB, String telP){
        Contact c = new Contact(new Person(prenom, nom), telM, telB, telP);
        try {
            AccueilControler.getModel().addContact(c);
        } catch (ContactAlreadyDefinedException e) {
            vue.setVisible(true);
            System.out.println("existant !");
        }
        
    }
    
    /** Annule l'ajout */
    public static void annulerAjout(){
        vue.setVisible(false);
    }

}
