/**
 * Classe de contrôle dans un cadre d'architecture MVC
 */
package controle;

import vue.Description;

/**
 * @author namor
 */

public class DescriptionControler extends DetailControler{
    
    /** Lance la vue Description */
    public static void vueDescription(){
        vue = new Description();
        vue.setVisible(true);
    }
    
    /** Permet de quitter la description */
    public static void quitterDescription(){
        
    }

}
