package fr.polytech.pooihm.phonebookgwt.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.polytech.pooihm.phonebookgwt.client.PhoneBookGWT;
import fr.polytech.pooihm.phonebookgwt.client.controler.AccueilControler;
import fr.polytech.pooihm.phonebookgwt.client.controler.SupprimerControler;

public class Supprimer extends Composite {
    /** Le panel central */
    private VerticalPanel panel;
    /** Bouton pour confirmer la suppression */
    private Button confirmer;
    /** Bouton pour annuler la suppression */
    private Button annuler;
    
    
    private static final Supprimer supprimerPrivate = new Supprimer();
    private static String member;
    /**
     * Renvoit le bouton de confirmation de suppression
     * @return Button le bouton de confirmation de suppression
     */
    public Button getConfirmerButton(){
        return confirmer;
    }
    /**
     * Renvoit le bouton d'annulation de suppression
     * @return Button le bouton pour annuler la suppression
     */
    public Button getAnnulerButton(){
        return annuler;
    }
    
    /**
     * Génère la vue Supprimer
     */
    private Supprimer(){
        panel = new VerticalPanel();
        panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        
        confirmer = new Button("Supprimer");
        annuler = new Button("Annuler");
        initSupprimer();
        
        panel.add(new HTML("<p>Êtes-vous sûr de vouloir supprimer ce contact ?</p>"));
        panel.add(confirmer);
        panel.add(annuler);
        
        initWidget(panel);
    }
    public static Supprimer getInstance(){
        return supprimerPrivate;
    }
    /**
     * Initialise les handlers de la vue Supprimer
     */
    private void initSupprimer(){
        confirmer.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
				try {
					SupprimerControler.deleteContact(member);

					RootPanel.get("display").remove(PhoneBookGWT.SUPPRIMER);
					// Confirmer l'action de l'utilisateur
					RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
					PhoneBookGWT.MESSAGE
							.setHTML("Le contact a bien été supprimé.");
					RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
				} catch (Exception e) {
					RootPanel.get("display").remove(PhoneBookGWT.SUPPRIMER);
					RootPanel.get("message").remove(PhoneBookGWT.MESSAGE);
					PhoneBookGWT.MESSAGE
							.setHTML("Il y a eu un problème.");
					RootPanel.get("message").add(PhoneBookGWT.MESSAGE);
				}
				RootPanel.get("display").add(PhoneBookGWT.ACCUEIL);
				AccueilControler.refresh();
            }
        });
        annuler.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(PhoneBookGWT.SUPPRIMER);
                RootPanel.get("display").add(PhoneBookGWT.ACCUEIL);
            }
        });
    }
    
    public static void setMemberToDelete(String m){
    	member = m;
    }
}
