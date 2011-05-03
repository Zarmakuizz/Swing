package fr.polytech.pooihm.phonebookgwt.client;

import fr.polytech.pooihm.phonebookgwt.client.view.Accueil;
import fr.polytech.pooihm.phonebookgwt.client.view.Ajouter;
import fr.polytech.pooihm.phonebookgwt.client.view.Modifier;
import fr.polytech.pooihm.phonebookgwt.client.view.Description;
import fr.polytech.pooihm.phonebookgwt.client.view.Supprimer;
import fr.polytech.pooihm.phonebookgwt.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

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
    private final HTML message= new HTML("");
    
    /**
     * Vue de l'accueil
     */
    public static final Accueil accueil = Accueil.getInstance();
    /**
     * Vue de l'ajout d'un contact
     */
    private Ajouter ajouter;
    /**
     * Vue de la modification d'un contact
     */
    private Modifier modifier;
    /**
     * Vue de la description d'un contact
     */
    private Description description;
    /**
     * Vue de la suppression d'un contact
     */
    private Supprimer supprimer;
    
    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    private final GreetingServiceAsync greetingService = GWT
            .create(GreetingService.class);
    
    /**
     * Initialise les handlers de la vue d'accueil
     */
    private void initAccueil(){
        accueil.getAddButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(accueil);
                // Enlever le message précédemment affiché, s'il y en avait un
                RootPanel.get("message").remove(message);
                message.setHTML("");
                RootPanel.get("message").add(message);
                RootPanel.get("display").add(ajouter);
            }
        });
        accueil.getModifierButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(accueil);
                // Enlever le message précédemment affiché, s'il y en avait un
                RootPanel.get("message").remove(message);
                message.setHTML("");
                RootPanel.get("message").add(message);
                RootPanel.get("display").add(modifier);
            }
        });
        accueil.getDescriptionButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(accueil);
                // Enlever le message précédemment affiché, s'il y en avait un
                RootPanel.get("message").remove(message);
                message.setHTML("");
                RootPanel.get("message").add(message);
                RootPanel.get("display").add(description);
            }
        });
        accueil.getSupprimerButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(accueil);
                // Enlever le message précédemment affiché, s'il y en avait un
                RootPanel.get("message").remove(message);
                message.setHTML("");
                RootPanel.get("message").add(message);
                RootPanel.get("display").add(supprimer);
            }
        });
    }
    /**
     * Initialise les handlers de la vue Ajouter
     */
    private void initAjouter(){
        ajouter.getAjouterButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(ajouter);
                // Confirmer l'action de l'utilisateur
                RootPanel.get("message").remove(message);
                message.setHTML("Le contact a bien été ajouté.");
                RootPanel.get("message").add(message);
                RootPanel.get("display").add(accueil);
            }
        });
        ajouter.getAnnulerButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(ajouter);
                RootPanel.get("display").add(accueil);
            }
        });
    }
    /**
     * Initialise les handlers de la vue Modifier
     */
    private void initModifier(){
        modifier.getModifierButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(modifier);
                // Confirmer l'action de l'utilisateur
                RootPanel.get("message").remove(message);
                message.setHTML("Le contact a bien été modifié.");
                RootPanel.get("message").add(message);
                RootPanel.get("display").add(accueil);
            }
        });
        modifier.getAnnulerButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(modifier);
                RootPanel.get("display").add(accueil);
            }
        });
    }
    /**
     * Initialise les handlers de la vue Description
     */
    private void initDescription(){
        description.getQuitterButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(description);
                RootPanel.get("display").add(accueil);
            }
        });
    }
    /**
     * Initialise les handlers de la vue Supprimer
     */
    private void initSupprimer(){
        supprimer.getConfirmerButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(supprimer);
                // Confirmer l'action de l'utilisateur
                RootPanel.get("message").remove(message);
                message.setHTML("Le contact a bien été supprimé.");
                RootPanel.get("message").add(message);
                RootPanel.get("display").add(accueil);
            }
        });
        supprimer.getAnnulerButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                RootPanel.get("display").remove(supprimer);
                RootPanel.get("display").add(accueil);
            }
        });
    }
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        RootPanel.get("message").add(message);
        accueil = new Accueil();
        RootPanel.get("display").add(accueil);
        ajouter = new Ajouter();
        modifier = new Modifier();
        description = new Description();
        supprimer = new Supprimer();
        
        initAccueil();
        initAjouter();
        initModifier();
        initDescription();
        initSupprimer();
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
