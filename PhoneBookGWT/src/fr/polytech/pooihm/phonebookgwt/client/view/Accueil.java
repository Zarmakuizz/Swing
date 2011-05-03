package fr.polytech.pooihm.phonebookgwt.client.view;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.polytech.pooihm.phonebookgwt.client.PhoneBookGWT;

/**
 * Définit la vue d'accueil de l'application. Cette classe utilise le
 * SingletonPattern, pour s'assurer de l'unicité de cette vue au moment de
 * l'exécution.
 * 
 * @author Guy Champollion
 * @author Roman Mkrtchian
 */
public class Accueil extends Composite {
    /** Boutons */
    private Button add, mod, desc, supp;
    /** Le panel central */
    private VerticalPanel panel;
    /** La ListBox affichant les contacts */
    private ListBox list;
    /** Le panel des boutons */
    private HorizontalPanel pBoutons;
    /** Retient le groupe consulté par l'utilisateur. */
    private String groupeConsulte;

    /**
     * L'instance d'Accueil, en private conformément au SingletonPattern.
     */
    private static final Accueil accueilPrivate = new Accueil();

    /**
     * Génère la vue Accueil. Le constructeur est private conformément au
     * SingletonPattern.
     */
    private Accueil() {
        groupeConsulte = fr.polytech.pooihm.phonebookgwt.client.modele.Modele.ALL_CONTACTS_GROUP_NAME;

        // Préparation des boutons
        add = new Button();
        add.setText("Ajouter");
        mod = new Button();
        mod.setText("Modifier");
        desc = new Button();
        desc.setText("Description");
        supp = new Button();
        supp.setText("Supprimer");
        initAccueilBoutons();
        // Préparation du panel de boutons
        pBoutons = new HorizontalPanel();
        pBoutons.setWidth("350px");
        pBoutons.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        pBoutons.add(add);
        pBoutons.add(mod);
        pBoutons.add(desc);
        pBoutons.add(supp);

        // Préparation de la liste des groupes et contacts
        list = new ListBox();
        list.setVisibleItemCount(10);
        list.setWidth("330px");
        for (int i = 0; i < 5; i++) {
            list.addItem("Hap");
            list.addItem("--- Onche Hapiste");
            list.addItem("--- Onche Kikoo");
            list.addItem("Noel");
            list.addItem("--- Noel");
        }

        // Assemblage de la vue dans le panel principal
        panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.add(pBoutons);
        panel.add(list);
        initWidget(panel);
    }

    /**
     * Initialise les handlers de la vue d'accueil
     */
    private void initAccueilBoutons() {
        // Le bouton d'ajout de contact
        add.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(PhoneBookGWT.ACCUEIL);
                // Enlever le message précédemment affiché, s'il y en avait un
                RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                PhoneBookGWT.MESSAGE.setHTML(" ");
                RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                RootPanel.get("display").add(PhoneBookGWT.AJOUTER);
            }
        });
        // Le bouton de modification de contact
        // Propose de modifier un contact si l'utilisateur en a sélectionné un
        mod.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (isSelectedLineAContact()) {
                    RootPanel.get("display").remove(PhoneBookGWT.ACCUEIL);
                    // Enlever l'ancien message affiché, s'il y en avait un
                    RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                    PhoneBookGWT.MESSAGE.setHTML(" ");
                    RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                    RootPanel.get("display").add(PhoneBookGWT.MODIFIER);
                } else {
                    // Enlever l'ancien message affiché, s'il y en avait un
                    RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                    PhoneBookGWT.MESSAGE
                            .setHTML("<span style='color:red;'>Veuillez sélectionner un contact.</span>");
                    RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                }
            }
        });
        // Le bouton de visualisation de la description d'un contact
        // Propose d'afficher la description d'un contact si l'utilisateur en a
        // affiché un
        desc.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (isSelectedLineAContact()) {
                    RootPanel.get("display").remove(PhoneBookGWT.ACCUEIL);
                    // Enlever le message précédemment affiché, s'il y en avait
                    // un
                    RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                    PhoneBookGWT.MESSAGE.setHTML(" ");
                    RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                    RootPanel.get("display").add(PhoneBookGWT.DESCRIPTION);
                } else {
                    RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                    PhoneBookGWT.MESSAGE
                            .setHTML("<span style='color:red;'>Veuillez sélectionner un contact.</span>");
                    RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                }
            }
        });
        // Le bouton de suppression d'un contact
        supp.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (isSelectedLineAContact()) {
                    RootPanel.get("display").remove(PhoneBookGWT.ACCUEIL);
                    // Enlever le message précédemment affiché, s'il y en avait
                    // un
                    RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                    PhoneBookGWT.MESSAGE.setHTML(" ");
                    RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                    RootPanel.get("display").add(PhoneBookGWT.SUPPRIMER);
                } else {
                    RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                    PhoneBookGWT.MESSAGE
                            .setHTML("<span style='color:red;'>Veuillez sélectionner un contact.</span>");
                    RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                }
            }
        });
    }

    /**
     * Détermine si la ligne sélectionnée dans la ListBox est celle d'un
     * contact.
     * 
     * @return boolean false si aucun élément n'est sélectionné ou si l'élément
     *         sélectionné correspond à un groupe.
     */
    public boolean isSelectedLineAContact() {
        int index = list.getSelectedIndex();
        if (index == -1)
            return false;
        String ligne = list.getItemText(index);
        return ligne.startsWith("--- ");
    }

    /**
     * Renvoie la seule instance d'Accueil accessible, conformément au
     * SingletonPattern.
     * 
     * @return Accueil Une instance d'Accueil.
     */
    public static Accueil getInstance() {
        return accueilPrivate;
    }
}
