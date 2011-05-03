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
import fr.polytech.pooihm.phonebook.ContactAlreadyDefinedException;
import fr.polytech.pooihm.phonebook.Person;
import fr.polytech.pooihm.phonebookgwt.client.PhoneBookGWT;
import fr.polytech.pooihm.phonebookgwt.client.controler.AccueilControler;
import fr.polytech.pooihm.phonebookgwt.client.controler.AjouterControler;

/**
 * Définit la vue d'ajout de contact pour l'application. Cette classe utilise le
 * SingletonPattern.
 * 
 * @author Guy Champollion
 * @author Roman Mkrtchian
 */
public class Ajouter extends Composite {
    /** Le panel central */
    private VerticalPanel panel;

    /** Les panels pour chaque champ. */
    private HorizontalPanel pnom, pprenom, ptelmaison, ptelbureau, ptelmobile;
    /** Les champs où l'utilisateur renseigne les coordonnées du contact. */
    private TextBox tnom, tprenom, ttelmaison, ttelbureau, ttelmobile;
    /** Le bouton pour ajouter le nouveau contact */
    private Button ajout;
    /** Le bouton pour ne pas faire de modification et revenir à l'accueil */
    private Button annul;

    private static final Ajouter ajouterPrivate = new Ajouter();

    /**
     * Renvoie le bouton Ajouter
     * 
     * @return Button le bouton Ajouter
     */
    public Button getAjouterButton() {
        return ajout;
    }

    /**
     * Renvoie le bouton Annuler
     * 
     * @return Button le bouton Annuler
     */
    public Button getAnnulerButton() {
        return annul;
    }

    /**
     * Génère la vue Ajouter
     */
    private Ajouter() {
        panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        tnom = new TextBox();
        pnom = new HorizontalPanel();
        pnom.add(new HTML("<p>Nom : </p>"));
        pnom.add(tnom);

        tprenom = new TextBox();
        pprenom = new HorizontalPanel();
        pprenom.add(new HTML("<p>Prénom : </p>"));
        pprenom.add(tprenom);

        ttelmaison = new TextBox();
        ptelmaison = new HorizontalPanel();
        ptelmaison.add(new HTML("<p>Téléphone (maison) : </p>"));
        ptelmaison.add(ttelmaison);

        ttelbureau = new TextBox();
        ptelbureau = new HorizontalPanel();
        ptelbureau.add(new HTML("<p>Téléphone (bureau) : </p>"));
        ptelbureau.add(ttelbureau);

        ttelmobile = new TextBox();
        ptelmobile = new HorizontalPanel();
        ptelmobile.add(new HTML("<p>Téléphone (mobile) : </p>"));
        ptelmobile.add(ttelmobile);

        ajout = new Button("Ajouter");
        annul = new Button("Annuler");
        initAjouter();

        panel.add(pnom);
        panel.add(pprenom);
        panel.add(ptelmaison);
        panel.add(ptelbureau);
        panel.add(ptelmobile);
        panel.add(ajout);
        panel.add(annul);

        initWidget(panel);
    }

    public static Ajouter getInstance() {
        return ajouterPrivate;
    }

    /**
     * Initialise les handlers de la vue Ajouter
     */
    private void initAjouter() {
        //
        ajout.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                if (tnom.getText().equals("") || tprenom.getText().equals("")) {
                    RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                    PhoneBookGWT.MESSAGE
                            .setHTML("<span style='color:#FF0000;'>In faut indiquer au moins le nom et le prénom.</span>");
                    RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                } else {
                    RootPanel.get("display").remove(PhoneBookGWT.AJOUTER);
                    // Confirmer l'action de l'utilisateur
                    RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                    try {
                        AjouterControler.ajouterContact(tnom.getText(),
                                tprenom.getText(), ttelmaison.getText(),
                                ttelbureau.getText(), ttelmobile.getText());
                        PhoneBookGWT.MESSAGE
                                .setHTML("Le contact a bien été ajouté.");
                    } catch (ContactAlreadyDefinedException e) {
                        PhoneBookGWT.MESSAGE
                                .setHTML("<span style='color:#FF0000;'>Ce contact existe déjà.</span>");
                    }
                    PhoneBookGWT.MESSAGE
                            .setHTML("Le contact a bien été ajouté.");
                    RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                    RootPanel.get("display").add(PhoneBookGWT.ACCUEIL);
                    AccueilControler.refresh();
                }
            }
        });
        annul.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(PhoneBookGWT.AJOUTER);
                RootPanel.get("display").add(PhoneBookGWT.ACCUEIL);
            }
        });
    }
}
