/**
 * Classe de contrôle dans un cadre d'architecture MVC
 */
package controle;

import vue.Modifier;

/**
 * @author namor
 */

public class ModifierControler extends DetailControler{
    
    /** Lance la vue Modifier */
    public static void vueModifier(){
        vue = new Modifier();
        vue.setVisible(true);
    }
    
    /** Modifie le contact */
    public static void validerModif(){
        
    }
    
    /** Annule la modification */
    public static void annulerModification(){
        vue.setVisible(false);
    }

}
