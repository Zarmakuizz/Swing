package fr.polytech.pooihm.phonebookgwt.client.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Modifier extends Composite {
    /** Le panel central */
    private VerticalPanel panel;
    
    /** Les panels pour chaque champ. */
    private HorizontalPanel pnom, pprenom, ptelmaison, ptelbureau, ptelmobile;
    /** Les champs où l'utilisateur renseigne les coordonnées du contact. */
    private TextBox tnom, tprenom, ttelmaison, ttelbureau, ttelmobile;
    /** Le bouton pour ajouter le nouveau contact */
    private Button modifier;
    /** Le bouton pour ne pas faire de modification et revenir à l'accueil */
    private Button annul;
    
    /**
     * Renvoie le bouton Modifier
     * @return Button le bouton Modifier
     */
    public Button getModifierButton(){
        return modifier;
    }
    /**
     * Renvoie le bouton Annuler
     * @return Button le bouton Annuler
     */
    public Button getAnnulerButton(){
        return annul;
    }
    
    /**
     * Génère la vue Modifier
     */
    public Modifier(){
        panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        tnom = new TextBox();
        tnom.setText("$variable");
        pnom = new HorizontalPanel();
        pnom.add(new HTML("<p>Nom : </p>"));
        pnom.add(tnom);
        
        tprenom = new TextBox();
        tprenom.setText("$variable");
        pprenom = new HorizontalPanel();
        pprenom.add(new HTML("<p>Prénom : </p>"));
        pprenom.add(tprenom);
        
        ttelmaison = new TextBox();
        ttelmaison.setText("$variable");
        ptelmaison = new HorizontalPanel();
        ptelmaison.add(new HTML("<p>Téléphone (maison) : </p>"));
        ptelmaison.add(ttelmaison);
        
        ttelbureau = new TextBox();
        ttelbureau.setText("$variable");
        ptelbureau = new HorizontalPanel();
        ptelbureau.add(new HTML("<p>Téléphone (bureau) : </p>"));
        ptelbureau.add(ttelbureau);
        
        ttelmobile = new TextBox();
        ttelmobile.setText("$variable");
        ptelmobile = new HorizontalPanel();
        ptelmobile.add(new HTML("<p>Téléphone (mobile) : </p>"));
        ptelmobile.add(ttelmobile);
        
        modifier = new Button("Modifier");
        annul = new Button("Annuler");
        
        panel.add(pnom);
        panel.add(pprenom);
        panel.add(ptelmaison);
        panel.add(ptelbureau);
        panel.add(ptelmobile);
        panel.add(modifier);
        panel.add(annul);
        
        initWidget(panel);
    }
}
