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
 * Définit la vue d'accueil de l'application.
 * Cette classe utilise le SingletonPattern, pour s'assurer de l'unicité de cette vue au moment de l'exécution.
 * @author zarmakuizz
 * @author namor
 */
public class Accueil extends Composite {
    /** Boutons */
    private Button add, mod, desc, supp;
    /** Le panel central */
    private VerticalPanel panel;

    /** Le panel des boutons */
    private HorizontalPanel pBoutons;
    
    private String groupeConsulte;
    
    /** la liste à afficher */
    private ListBox list;

    /**
     * L'instance d'Accueil, en private conformément au SingletonPattern.
     */
    private static final Accueil accueilPrivate = new Accueil();

    /**
     * Génère la vue Accueil.
     */
    private Accueil() {
        groupeConsulte = fr.polytech.pooihm.phonebookgwt.client.modele.Modele.ALL_CONTACTS_GROUP_NAME;
        add = new Button();
        add.setText("Ajouter");
        mod = new Button();
        mod.setText("Modifier");
        desc = new Button();
        desc.setText("Description");
        supp = new Button();
        supp.setText("Supprimer");
        
        initAccueil();
        pBoutons = new HorizontalPanel();
        pBoutons.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        pBoutons.add(add);
        pBoutons.add(mod);
        pBoutons.add(desc);
        pBoutons.add(supp);

        list = new ListBox();
        list.setVisibleItemCount(5);
        list.setWidth("350px");
        for (int i=0; i< 5; i++){
            list.addItem("Onche Hapower");
            list.addItem("Onche Hapiste");
            list.addItem("Golay Noel");
            list.addItem("Noel Jerry");
            list.addItem("Norris Chuck");
        }
        
        panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.add(pBoutons);
        // panel.add(treeroot);
        panel.add(list);
        initWidget(panel);
    }
    /**
     * Initialise les handlers de la vue d'accueil
     */
    private void initAccueil(){
        // Le bouton d'ajout de contact
        add.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(PhoneBookGWT.ACCUEIL);
                // Enlever le message précédemment affiché, s'il y en avait un
                RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                PhoneBookGWT.MESSAGE.setHTML("");
                RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                RootPanel.get("display").add(PhoneBookGWT.AJOUTER);
            }
        });
        // Le bouton de modification de contact
        mod.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(PhoneBookGWT.ACCUEIL);
                // Enlever le message précédemment affiché, s'il y en avait un
                RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                PhoneBookGWT.MESSAGE.setHTML("");
                RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                RootPanel.get("display").add(PhoneBookGWT.MODIFIER);
            }
        });
        // Le bouton de visualisation de la description d'un contact
        desc.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(PhoneBookGWT.ACCUEIL);
                // Enlever le message précédemment affiché, s'il y en avait un
                RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                PhoneBookGWT.MESSAGE.setHTML("");
                RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                RootPanel.get("display").add(PhoneBookGWT.DESCRIPTION);
            }
        });
        // Le bouton de suppression d'un contact
        supp.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(PhoneBookGWT.ACCUEIL);
                // Enlever le message précédemment affiché, s'il y en avait un
                RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
                PhoneBookGWT.MESSAGE.setHTML("");
                RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
                RootPanel.get("display").add(PhoneBookGWT.SUPPRIMER);
            }
        });
    }
    public static Accueil getInstance(){
        return accueilPrivate;
    }
    
    /**
     * Remet la liste à vide
     */
    public void resetList(){
    	panel.remove(list);
    	list = new ListBox();
        list.setVisibleItemCount(5);
        list.setWidth("350px");
    	panel.add(list);
    }
    
    /**
     * Ajoute un contact dans la liste
     * @param contact
     */
    public void addContact(String contact){
    	panel.remove(list);
    	list.addItem(contact);
    	panel.add(list);
    }
}
