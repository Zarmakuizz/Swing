package fr.polytech.pooihm.phonebookgwt.client.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.polytech.pooihm.phonebookgwt.client.controllers.ModifAddContactController;

public class ModifyAddContactView extends PopupPanel {

	// Graphical Attributes
	private Label firstNameLabel = new Label("First Name");
	private Label lastNameLabel = new Label("Last Name");
	private Label homeNumberLabel = new Label("Home Number");
	private Label workNumberLabel = new Label("Work Number");
	private Label mobileNumberLabel = new Label("Mobile Number");
	private TextBox firstNameText = new TextBox();
	private TextBox lastNameText = new TextBox();
	private TextBox homeNumberText = new TextBox();
	private TextBox workNumberText = new TextBox();
	private TextBox mobileNumberText = new TextBox();
	private Button cancelButton = new Button("Cancel");
	private Button okButton = new Button("Ok");
	private Button deleteButton = new Button("Delete");

	private DialogBox dialogBox;

	// Attributes
	private ModifAddContactController controller;
	private String firstName;
	private String lastName;
	private String homeNumber;
	private String workNumber;
	private String mobileNumber;

	private Boolean modifContact;

	public ModifyAddContactView(
			ModifAddContactController modifAddContactController,
			String firstName, String lastName, String homeNumber,
			String workNumber, String mobileNumber) {

		this.controller = modifAddContactController;
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeNumber = homeNumber;
		this.workNumber = workNumber;
		this.mobileNumber = mobileNumber;
		this.modifContact = true;
		builPopup();
	}

	public ModifyAddContactView(
			ModifAddContactController modifAddContactController) {
		super(false);
		this.controller = modifAddContactController;
		this.modifContact = false;
		builPopup();
	}

	private void builPopup() {
		dialogBox = new DialogBox();
		dialogBox.setGlassEnabled(true);
		dialogBox.setAnimationEnabled(true);

		VerticalPanel panel = new VerticalPanel();

		HorizontalPanel p1 = new HorizontalPanel();
		p1.add(firstNameLabel);
		p1.add(firstNameText);
		firstNameText.setEnabled(false);
		p1.setCellHorizontalAlignment(firstNameLabel,
				HorizontalPanel.ALIGN_LEFT);
		p1.setCellHorizontalAlignment(firstNameText,
				HorizontalPanel.ALIGN_RIGHT);
		p1.setCellWidth(firstNameLabel, "90px");
		p1.setCellWidth(firstNameText, "140px");
		panel.add(p1);

		HorizontalPanel p2 = new HorizontalPanel();
		p2.add(lastNameLabel);
		p2.add(lastNameText);
		lastNameText.setEnabled(false);
		p2.setCellHorizontalAlignment(lastNameLabel, HorizontalPanel.ALIGN_LEFT);
		p2.setCellHorizontalAlignment(lastNameText, HorizontalPanel.ALIGN_RIGHT);
		p2.setCellWidth(lastNameLabel, "90px");
		p2.setCellWidth(lastNameText, "140px");
		panel.add(p2);

		HorizontalPanel p3 = new HorizontalPanel();
		p3.add(homeNumberLabel);
		p3.add(homeNumberText);
		p3.setCellHorizontalAlignment(homeNumberLabel,
				HorizontalPanel.ALIGN_LEFT);
		p3.setCellHorizontalAlignment(homeNumberText,
				HorizontalPanel.ALIGN_RIGHT);
		p3.setCellWidth(homeNumberLabel, "90px");
		p3.setCellWidth(homeNumberText, "140px");
		panel.add(p3);

		HorizontalPanel p4 = new HorizontalPanel();
		p4.add(workNumberLabel);
		p4.add(workNumberText);
		p4.setCellHorizontalAlignment(workNumberLabel,
				HorizontalPanel.ALIGN_LEFT);
		p4.setCellHorizontalAlignment(workNumberText,
				HorizontalPanel.ALIGN_RIGHT);
		p4.setCellWidth(workNumberLabel, "90px");
		p4.setCellWidth(workNumberText, "140px");
		panel.add(p4);

		HorizontalPanel p5 = new HorizontalPanel();
		p5.setWidth("100%");
		p5.add(mobileNumberLabel);
		p5.add(mobileNumberText);
		p5.setCellHorizontalAlignment(mobileNumberLabel,
				HorizontalPanel.ALIGN_LEFT);
		p5.setCellHorizontalAlignment(mobileNumberText,
				HorizontalPanel.ALIGN_RIGHT);
		p5.setCellWidth(mobileNumberLabel, "90px");
		p5.setCellWidth(mobileNumberText, "140px");
		panel.add(p5);

		HorizontalPanel p6 = new HorizontalPanel();
		p6.setWidth("100%");
		p6.add(deleteButton);
		p6.add(cancelButton);
		p6.add(okButton);
		p6.setCellWidth(deleteButton, "100px");
		p6.setCellHorizontalAlignment(okButton, HorizontalPanel.ALIGN_RIGHT);
		p6.setCellHorizontalAlignment(cancelButton, HorizontalPanel.ALIGN_RIGHT);

		panel.add(p6);
		panel.setSpacing(4);
		dialogBox.add(panel);
		dialogBox.setText("Add modify");

		finalInit();
		setHandlers();

		dialogBox.center();
		dialogBox.show();
	}

	private void finalInit() {
		if (modifContact) {
			dialogBox.setText("Modify Contact");
			firstNameText.setText(firstName);
			lastNameText.setText(lastName);
			workNumberText.setText(workNumber);
			homeNumberText.setText(homeNumber);
			mobileNumberText.setText(mobileNumber);
		} else {
			firstNameText.setEnabled(true);
			lastNameText.setEnabled(true);
			dialogBox.setText("Add Contact");
			deleteButton.setVisible(false);
			okButton.setEnabled(false);
		}

	}

	private void setHandlers() {
		firstNameText.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				checkEntry();

			}
		});
		lastNameText.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				checkEntry();
			}
		});
		homeNumberText.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				checkEntry();
			}
		});
		workNumberText.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				checkEntry();
			}
		});
		mobileNumberText.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				checkEntry();
			}
		});

		deleteButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.deleteContact(firstNameText.getText(),
						lastNameText.getText());
				dialogBox.hide();
			}
		});
		cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});
		okButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (!modifContact)
					controller.addContact(firstNameText.getText(),
							lastNameText.getText(), homeNumberText.getText(),
							workNumberText.getText(),
							mobileNumberText.getText());
				else
					controller.modifyContact(firstName, lastName,
							homeNumberText.getText(), workNumberText.getText(),
							mobileNumberText.getText());
				dialogBox.hide();
			}
		});

	}

	private void checkEntry() {
		if (!modifContact) {
			if (firstNameText.getText().isEmpty())
				okButton.setEnabled(false);
			if (lastNameText.getText().isEmpty())
				okButton.setEnabled(false);
			if (controller.personExist(firstNameText.getText(),
					lastNameText.getText()))
				okButton.setEnabled(false);
			if (!firstNameText.getText().isEmpty()
					&& !lastNameText.getText().isEmpty()
					&& !controller.personExist(firstNameText.getText(),
							lastNameText.getText()))
				okButton.setEnabled(true);
		}
	}

}
