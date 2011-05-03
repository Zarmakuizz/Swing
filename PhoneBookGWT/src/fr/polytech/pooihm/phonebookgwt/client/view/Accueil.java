package fr.polytech.pooihm.phonebookgwt.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.server.rpc.UnexpectedException;

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
                String ligne;
                try {
                    ligne = getSelectedText();
                } catch (IndexOutOfBoundsException e) {
                    ligne = "";
                }
                // Si la ligne sélectionnée est un contact
                if (ligne.startsWith("--")) {
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
                String ligne;
                try {
                    ligne = getSelectedText();
                } catch (IndexOutOfBoundsException e) {
                    ligne = "";
                }
                // Si la ligne sélectionnée est un contact
                if (ligne.startsWith("--")) {
                    RootPanel.get("display").remove(PhoneBookGWT.ACCUEIL);
                    // Enlever le message précédemment affiché, s'il y en avait
                    // un
                    RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                    PhoneBookGWT.MESSAGE.setHTML(" ");
                    RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                    RootPanel.get("display").add(PhoneBookGWT.DESCRIPTION);

                    String[] textes = ligne.substring(2).split(" ");
                    PhoneBookGWT.DESCRIPTION.loadDescription(textes[0],
                            textes[1]);
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
                String ligne;
                try {
                    ligne = getSelectedText();
                } catch (IndexOutOfBoundsException e) {
                    ligne = "";
                }
                // Si la ligne sélectionnée est un contact
                if (ligne.startsWith("--")) {
                    RootPanel.get("display").remove(PhoneBookGWT.ACCUEIL);
                    // Enlever le message précédemment affiché, s'il y en avait
                    // un
                    RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                    PhoneBookGWT.MESSAGE.setHTML(" ");
                    RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                    PhoneBookGWT.SUPPRIMER.setMemberToDelete(list
                            .getItemText(list.getSelectedIndex()));
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
     * Obtenir le texte de la ligne sélectionné.
     * 
     * @return String
     */
    public String getSelectedText() throws IndexOutOfBoundsException {
        int index = list.getSelectedIndex();
        if (index == -1)
            throw new RuntimeException();
        else
            list.setSelectedIndex(index);
        String ligne = list.getItemText(index);
        return ligne;
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

    /**
     * Remet la liste à vide
     */
    public void resetList() {
        panel.remove(list);
        list = new ListBox();
        list.setVisibleItemCount(10);
        list.setWidth("350px");
        panel.add(list);
    }

    /**
     * Ajoute un contact dans la liste
     * 
     * @param contact
     */
    public void addContact(String contact) {
        panel.remove(list);
        list.addItem(contact);
        panel.add(list);
    }
}
