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

import fr.polytech.pooihm.phonebook.Contact;
import fr.polytech.pooihm.phonebookgwt.client.PhoneBookGWT;
import fr.polytech.pooihm.phonebookgwt.client.controler.DescriptionControler;

public class Description extends Composite {
    /** Le panel central */
    private VerticalPanel panel;
    /** Les panels pour chaque information utilisateur. */
    private HorizontalPanel pnom, pprenom, ptelmaison, ptelbureau, ptelmobile;
    /** Les champs constants */
    private HTML hnom, hprenom, htelmaison, htelbureau, htelmobile;
    /** Le bouton pour ajouter le nouveau contact */
    private Button quitter;
    
    private static final Description descriptionPrivate = new Description();
    /**
     * Génère la vue Description
     */
    private Description(){
        panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        pnom = new HorizontalPanel();
        hnom = new HTML("<p>Nom : </p>");
        pnom.add(hnom);
        pnom.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        pprenom = new HorizontalPanel();
        hprenom = new HTML("<p>Prénom : </p>");
        pprenom.add(hprenom);
        pprenom.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        ptelmaison = new HorizontalPanel();
        htelmaison = new HTML("<p>Téléphone (maison) : </p>");
        ptelmaison.add(htelmaison);
        ptelmaison.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        ptelbureau = new HorizontalPanel();
        htelbureau = new HTML("<p>Téléphone (bureau) : </p>");
        ptelbureau.add(htelbureau);
        ptelbureau.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        ptelmobile = new HorizontalPanel();
        htelmobile = new HTML("<p>Téléphone (mobile) : </p>");
        ptelmobile.add(htelmobile);
        ptelmobile.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
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
    
    public void loadDescription(String nom, String prenom){
        Contact c = DescriptionControler.getContact(nom, prenom);
        pnom.clear();
        pnom.add(hnom);
        pnom.add(new HTML("<p>"+c.getPerson().getLastname()+"</p>"));

        pprenom.clear();
        pprenom.add(hprenom);
        pprenom.add(new HTML("<p>"+c.getPerson().getFirstname()+"</p>"));

        ptelmaison.clear();
        ptelmaison.add(htelmaison);
        ptelmaison.add(new HTML("<p>"+c.getHomenum()+"</p>"));

        ptelbureau.clear();
        ptelbureau.add(htelbureau);
        ptelbureau.add(new HTML("<p>"+c.getOfficenum()+"</p>"));

        ptelmobile.clear();
        ptelmobile.add(htelmobile);
        ptelmobile.add(new HTML("<p>"+c.getCellnum()+"</p>"));
        
        /*
        panel.clear();
        panel.add(pnom);
        panel.add(pprenom);
        panel.add(ptelmaison);
        panel.add(ptelbureau);
        panel.add(ptelmobile);
        initWidget(panel);
        //*/
    }
}
