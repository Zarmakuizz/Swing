package fr.polytech.pooihm.phonebookgwt.client.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Supprimer extends Composite {
    /** Le panel central */
    private VerticalPanel panel;
    /** Bouton pour confirmer la suppression */
    private Button oui;
    /** Bouton pour annuler la suppression */
    private Button non;
    
    /**
     * Renvoit le bouton de confirmation de suppression
     * @return Button le bouton de confirmation de suppression
     */
    public Button getConfirmerButton(){
        return oui;
    }
    /**
     * Renvoit le bouton d'annulation de suppression
     * @return Button le bouton pour annuler la suppression
     */
    public Button getAnnulerButton(){
        return non;
    }
    
    /**
     * Génère la vue Supprimer
     */
    public Supprimer(){
        panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        oui = new Button("Supprimer");
        non = new Button("Annuler");
        
        panel.add(new HTML("<p>Êtes-vous sûr de vouloir supprimer ce contact ?</p>"));
        panel.add(oui);
        panel.add(non);
        
        initWidget(panel);
    }
}
