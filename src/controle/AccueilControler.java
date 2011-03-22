/**
 * Classe de contrôle dans un cadre d'architecture MVC
 */
package controle;

import javax.swing.JOptionPane;

import modele.Modele;
import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebook.ContactAlreadyDefinedException;
import fr.polytech.pooihm.phonebook.GroupNotDefinedException;
import fr.polytech.pooihm.phonebook.Person;

import test.Test;
import vue.Accueil;

/**
 * @author namor
 */

public class AccueilControler {
    /** Partie modèle */
    private static Modele modele;
    /** La fenêtere d'accueil */
    private static Accueil accueil;
    
    /** initialise et lance la fenetre principale */
    public AccueilControler(){
        accueil = new Accueil();
        accueil.setVisible(true);
        modele = new Modele();

        accueil.fillAllPersons(modele.getAllPersons());
        try {
            accueil.fillTheTree(modele.getAllGroupsPersons(), modele.getGroupes());
        } catch (GroupNotDefinedException e) {
            //On affiche une fenetre d'erreur pour informer l'utilisateur
            JOptionPane erreur = new JOptionPane();
            erreur.showMessageDialog( accueil, "Ce groupe n'existe pas.", 
                  "Attention", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /** Demande si on est sur de supprimer */
    public static void vueSuppression(){
        int n = JOptionPane.showConfirmDialog(
            accueil,
            "Etes-vous sûr de vouloir supprimer ?",
            "Danger critique !",
            JOptionPane.YES_NO_OPTION);
        
        if(n==0) ouiSuppression();
        else nonSuppression();
    }
    
    /** Supprime */
    public static void ouiSuppression(){
    }
    
    /** Annule la suppression */
    public static void nonSuppression(){
        
    }
    
    /** Permet de charger le groupe sélectionné */
    public static void selectionGroupe(){
        
    }

}
