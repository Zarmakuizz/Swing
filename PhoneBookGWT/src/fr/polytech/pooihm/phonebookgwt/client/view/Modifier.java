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
import fr.polytech.pooihm.phonebookgwt.client.controler.AccueilControler;
import fr.polytech.pooihm.phonebookgwt.client.controler.DescriptionControler;
import fr.polytech.pooihm.phonebookgwt.client.controler.ModifierControler;

public class Modifier extends Composite {
    /** Le panel central */
    private VerticalPanel panel;
    
    /** Les panels pour chaque champ. */
    private HorizontalPanel pnom, pprenom, ptelmaison, ptelbureau, ptelmobile;
    /** Les champs où l'utilisateur renseigne les coordonnées du contact. */
    private TextBox tnom, tprenom, ttelmaison, ttelbureau, ttelmobile;
    /** Les champs constants */
    private HTML hnom, hprenom, htelmaison, htelbureau, htelmobile;
    /** Le bouton pour ajouter le nouveau contact */
    private Button modifier;
    /** Le bouton pour ne pas faire de modification et revenir à l'accueil */
    private Button annuler;
    
    private static final Modifier modifierPrivate = new Modifier();
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
        return annuler;
    }
    
    /**
     * Génère la vue Modifier
     */
    private Modifier(){
        panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        tnom = new TextBox();
        tnom.setText("");
        pnom = new HorizontalPanel();
        hnom = new HTML("<p>Nom : </p>");
        pnom.add(hnom);
        pnom.add(tnom);
        
        tprenom = new TextBox();
        tprenom.setText("");
        pprenom = new HorizontalPanel();
        hprenom = new HTML("<p>Prénom : </p>");
        pprenom.add(hprenom);
        pprenom.add(tprenom);
        
        ttelmaison = new TextBox();
        ttelmaison.setText("");
        ptelmaison = new HorizontalPanel();
        htelmaison = new HTML("<p>Téléphone (maison) : </p>");
        ptelmaison.add(htelmaison);
        ptelmaison.add(ttelmaison);
        
        ttelbureau = new TextBox();
        ttelbureau.setText("");
        ptelbureau = new HorizontalPanel();
        ptelbureau.add(new HTML("<p>Téléphone (bureau) : </p>"));
        ptelbureau.add(ttelbureau);
        
        ttelmobile = new TextBox();
        ttelmobile.setText("");
        ptelmobile = new HorizontalPanel();
        htelmobile = new HTML("<p>Téléphone (mobile) : </p>");
        ptelmobile.add(htelmobile);
        ptelmobile.add(ttelmobile);
        
        modifier = new Button("Modifier");
        annuler = new Button("Annuler");
        initModifier();
        
        panel.add(pnom);
        panel.add(pprenom);
        panel.add(ptelmaison);
        panel.add(ptelbureau);
        panel.add(ptelmobile);
        panel.add(modifier);
        panel.add(annuler);
        
        initWidget(panel);
    }
    public static Modifier getInstance(){
        return modifierPrivate;
    }
    /**
     * Initialise les handlers de la vue Modifier
     */
    private void initModifier(){
        modifier.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(PhoneBookGWT.MODIFIER);
                // Confirmer l'action de l'utilisateur
                RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                PhoneBookGWT.MESSAGE.setHTML("Le contact a bien été modifié.");
                RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                RootPanel.get("display").add(PhoneBookGWT.ACCUEIL);
                AccueilControler.refresh();
            }
        });
        annuler.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(PhoneBookGWT.MODIFIER);
                RootPanel.get("display").add(PhoneBookGWT.ACCUEIL);
            }
        });
    }
    public void loadDescription(String nom, String prenom){
        Contact c = ModifierControler.getContact(nom, prenom);
        pnom.clear();
        pnom.add(hnom);
        tnom.setText(c.getPerson().getLastname());
        pnom.add(tnom);

        pprenom.clear();
        pprenom.add(hprenom);
        tprenom.setText(c.getPerson().getFirstname());
        pprenom.add(tprenom);

        ptelmaison.clear();
        ptelmaison.add(htelmaison);
        ttelmaison.setText(c.getHomenum());
        ptelmaison.add(ttelmaison);

        ptelbureau.clear();
        ptelbureau.add(htelbureau);
        ttelbureau.setText(c.getOfficenum());
        ptelbureau.add(ttelbureau);

        ptelmobile.clear();
        ptelmobile.add(htelmobile);
        ttelmobile.setText(c.getCellnum());
        ptelmobile.add(ttelmobile);
    }
}
