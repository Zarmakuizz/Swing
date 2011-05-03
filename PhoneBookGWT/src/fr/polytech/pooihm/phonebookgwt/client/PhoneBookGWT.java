package fr.polytech.pooihm.phonebookgwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

import fr.polytech.pooihm.phonebookgwt.client.controler.AccueilControler;
import fr.polytech.pooihm.phonebookgwt.client.controler.AjouterControler;
import fr.polytech.pooihm.phonebookgwt.client.controler.DescriptionControler;
import fr.polytech.pooihm.phonebookgwt.client.controler.ModifierControler;
import fr.polytech.pooihm.phonebookgwt.client.controler.SupprimerControler;
import fr.polytech.pooihm.phonebookgwt.client.modele.Modele;
import fr.polytech.pooihm.phonebookgwt.client.view.Accueil;
import fr.polytech.pooihm.phonebookgwt.client.view.Ajouter;
import fr.polytech.pooihm.phonebookgwt.client.view.Description;
import fr.polytech.pooihm.phonebookgwt.client.view.Modifier;
import fr.polytech.pooihm.phonebookgwt.client.view.Supprimer;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PhoneBookGWT implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";
    /**
     * Message à afficher en fonction des opérations tentées par l'utilisateur
     */
    public static HTML MESSAGE= new HTML("");
    
    /**
     * Vue de l'accueil
     */
    public static final Accueil ACCUEIL = Accueil.getInstance();
    /**
     * Vue de l'ajout d'un contact
     */
    public static final Ajouter AJOUTER = Ajouter.getInstance();
    /**
     * Vue de la modification d'un contact
     */
	public static final Modifier MODIFIER = Modifier.getInstance();
	/**
	 * Vue de la description d'un contact
	 */
	public static final Description DESCRIPTION = Description.getInstance();
	/**
	 * Vue de la suppression d'un contact
	 */
	public static final Supprimer SUPPRIMER = Supprimer.getInstance();

	/** Le modèle */
	private Modele modele;
	
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
    private final GreetingServiceAsync greetingService = GWT
            .create(GreetingService.class);
    
    
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
    	//le modèle
    	modele = new Modele();
    	//controlers
    	AccueilControler accueilControler = new AccueilControler(modele);
    	AjouterControler ajouterControler = new AjouterControler(modele);
    	DescriptionControler descriptionControler = new DescriptionControler(modele);
    	ModifierControler modifierControler = new ModifierControler(modele);
    	SupprimerControler supprimerControler = new SupprimerControler(modele);
    	Accueil.groupeConsulte = Modele.ALL_CONTACTS_GROUP_NAME;
    	accueilControler.refresh();
    	
    	
        RootPanel.get("message").add(MESSAGE);
        RootPanel.get("display").add(ACCUEIL);
        
        //final Button sendButton = new Button("Send");
        //final TextBox nameField = new TextBox();
        //nameField.setText("GWT Mangeur");
        //final Label errorLabel = new Label();
        //final Accueil accueil = new Accueil();
        //final Button add  = new Button();add.setText("Ajouter");
        // We can add style names to widgets
        //sendButton.addStyleName("sendButton");
        
        // Add the nameField and sendButton to the RootPanel
        // Use RootPanel.get() to get the entire body element
        //RootPanel.get("nameFieldContainer").add(nameField);
        //RootPanel.get("sendButtonContainer").add(sendButton);
        //RootPanel.get("errorLabelContainer").add(errorLabel);
        //RootPanel.get("display").add(add);

        // Focus the cursor on the name field when the app loads
        /*nameField.setFocus(true);
        nameField.selectAll();

        // Create the popup dialog box
        final DialogBox dialogBox = new DialogBox();
        dialogBox.setText("Remote Procedure Call");
        dialogBox.setAnimationEnabled(true);
        final Button closeButton = new Button("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");
        final Label textToServerLabel = new Label();
        final HTML serverResponseLabel = new HTML();
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
        dialogVPanel.add(textToServerLabel);
        dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);

        // Add a handler to close the DialogBoxs
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dialogBox.hide();
                sendButton.setEnabled(true);
                sendButton.setFocus(true);
            }
        });*/

        // Create a handler for the sendButton and nameField
        
//        class MyHandler implements ClickHandler, KeyUpHandler {
//            /**
//             * Fired when the user clicks on the sendButton.
//             */
//            public void onClick(ClickEvent event) {
//                sendNameToServer();
//            }
//
//            /**
//             * Fired when the user types in the nameField.
//             */
//            public void onKeyUp(KeyUpEvent event) {
//                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
//                    sendNameToServer();
//                }
//            }
//
//            /**
//             * Send the name from the nameField to the server and wait for a response.
//             */
//            private void sendNameToServer() {
//                // First, we validate the input.
//                errorLabel.setText("");
//                String textToServer = nameField.getText();
//                if (!FieldVerifier.isValidName(textToServer)) {
//                    errorLabel.setText("Please enter at least four characters");
//                    return;
//                }
//
//                // Then, we send the input to the server.
//                sendButton.setEnabled(false);
//                textToServerLabel.setText(textToServer);
//                serverResponseLabel.setText("");
//                greetingService.greetServer(textToServer,
//                        new AsyncCallback<String>() {
//                            public void onFailure(Throwable caught) {
//                                // Show the RPC error message to the user
//                                dialogBox
//                                        .setText("Remote Procedure Call - Failure");
//                                serverResponseLabel
//                                        .addStyleName("serverResponseLabelError");
//                                serverResponseLabel.setHTML(SERVER_ERROR);
//                                dialogBox.center();
//                                closeButton.setFocus(true);
//                            }
//
//                            public void onSuccess(String result) {
//                                dialogBox.setText("Remote Procedure Call");
//                                serverResponseLabel
//                                        .removeStyleName("serverResponseLabelError");
//                                serverResponseLabel.setHTML(result);
//                                dialogBox.center();
//                                closeButton.setFocus(true);
//                            }
//                        });
//            }
//        }
//
//        // Add a handler to send the name to the server
//        MyHandler handler = new MyHandler();
//        sendButton.addClickHandler(handler);
//        nameField.addKeyUpHandler(handler);
//        
    }
}
