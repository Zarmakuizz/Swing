package test;

import vue.Accueil;
import vue.Ajouter;
import vue.Alerte;
import vue.Description;
import vue.Detail;
import vue.Modifier;

public class Test {
    //private static Alerte al;
    private static Accueil ac;
    private static Detail dt1, dt2, dt3;
    
    public static void main(String[] args) {
        dt1 = new Ajouter();
        dt2 = new Modifier();
        dt3 = new Description();
        dt1.setVisible(true); dt2.setVisible(true); dt3.setVisible(true);
        ac = new Accueil();
        ac.setVisible(true);
        
    }

}
