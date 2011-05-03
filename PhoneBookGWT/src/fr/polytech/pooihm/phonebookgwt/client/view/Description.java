package fr.polytech.pooihm.phonebookgwt.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.polytech.pooihm.phonebookgwt.client.PhoneBookGWT;

public class Description extends Composite {
    /** Le panel central */
    private VerticalPanel panel;
    /** Les panels pour chaque information utilisateur. */
    private HorizontalPanel pnom, pprenom, ptelmaison, ptelbureau, ptelmobile;
    /** Le bouton pour ajouter le nouveau contact */
    private Button quitter;
    
    
    private static final Description descriptionPrivate = new Description();
    /**
     * Renvoie le bouton Quitter
     * @return Button le bouton Quitter
     */
    public Button getQuitterButton(){
        return quitter;
    }
    
    /**
     * Génère la vue Description
     */
    private Description(){
        panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        pnom = new HorizontalPanel();
        pnom.add(new HTML("<p>Nom : $variable</p>"));
        
        pprenom = new HorizontalPanel();
        pprenom.add(new HTML("<p>Prénom : $variable</p>"));
        
        ptelmaison = new HorizontalPanel();
        ptelmaison.add(new HTML("<p>Téléphone (maison) : $variable</p>"));
        
        ptelbureau = new HorizontalPanel();
        ptelbureau.add(new HTML("<p>Téléphone (bureau) : $variable</p>"));
        
        ptelmobile = new HorizontalPanel();
        ptelmobile.add(new HTML("<p>Téléphone (mobile) : $variable</p>"));
        
        quitter = new Button("Quitter");
        initDescription();
        
        panel.add(pnom);
        panel.add(pprenom);
        panel.add(ptelmaison);
        panel.add(ptelbureau);
        panel.add(ptelmobile);
        panel.add(quitter);
        
        initWidget(panel);
    }
    public static Description getInstance(){
        return descriptionPrivate;
    }
    
    /**
     * Initialise les handlers de la vue Description
     */
    private void initDescription(){
        quitter.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(PhoneBookGWT.DESCRIPTION);
                RootPanel.get("display").add(PhoneBookGWT.ACCUEIL);
            }
        });
    }
}
