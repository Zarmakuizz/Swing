/**
 * Classe de contrôle dans un cadre d'architecture MVC
 */
package controle;

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
    public static void validerAjout(){
        
    }
    
    /** Annule l'ajout */
    public static void annulerAjout(){
        
    }

}
