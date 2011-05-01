package fr.polytech.pooihm.phonebookgwt.client.view;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Définit la vue d'accueil de l'application.
 * 
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
    /** l'arbre contenant le répertoire */
    // private JTree tree;
    /** Noeuds */
    // DefaultMutableTreeNode racine, groupes, personnes;

    private TextBox textboxtest;

    /**
     * Renvoie le bouton Ajouter
     * 
     * @return Button Le bouton Ajouter
     */
    public Button getAddButton() {
        return add;
    }

    /**
     * Renvoie le bouton Modifier
     * 
     * @return Button le bouton Modifier
     */
    public Button getModifierButton() {
        return mod;
    }

    /**
     * Renvoie le bouton Description
     * 
     * @return Button le bouton Description
     */
    public Button getDescriptionButton() {
        return desc;
    }

    /**
     * Renvoie le bouton Supprimer
     * 
     * @return Button le bouton Supprimer
     */
    public Button getSupprimerButton() {
        return supp;
    }
    
    /**
     * Génère la vue Accueil
     */
    public Accueil() {
        add = new Button();
        add.setText("Ajouter");

        mod = new Button();
        mod.setText("Modifier");
        desc = new Button();
        desc.setText("Description");
        supp = new Button();
        supp.setText("Supprimer");

        pBoutons = new HorizontalPanel();
        pBoutons.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        pBoutons.add(add);
        pBoutons.add(mod);
        pBoutons.add(desc);
        pBoutons.add(supp);
        // panel.add(rb0);
        // panel.add(rb1);
        // panel.add(rb2);
        textboxtest = new TextBox();
        textboxtest.setText("1 2 1 2 this is a test");

        panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        panel.add(pBoutons);
        panel.add(textboxtest);
        panel.add(new HTML("<p>Bonjour mon enfant !</p>"));
        initWidget(panel);
    }
}
