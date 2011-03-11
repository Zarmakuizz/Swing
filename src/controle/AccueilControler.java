/**
 * Classe de contrôle dans un cadre d'architecture MVC
 */
package controle;

import javax.swing.JOptionPane;

import test.Test;

/**
 * @author namor
 */

public class AccueilControler {
    
    /** Demande si on est sur de supprimer */
    public static void vueSuppression(){
        int n = JOptionPane.showConfirmDialog(
            Test.getAccueil(),
            "Etes-vous sûr de vouloir supprimer ?",
            "Danger critique !",
            JOptionPane.YES_NO_OPTION);
        
        if(n==0) ouiSuppression();
        else nonSuppression();
    }
    
    /** Supprime */
    public static void ouiSuppression(){
        System.out.println("Noooooo it burns !");
    }
    
    /** Annule la suppression */
    public static void nonSuppression(){
        
    }
    
    /** Permet de charger le groupe sélectionné */
    public static void selectionGroupe(){
        
    }

}
