package fr.polytech.pooihm.phonebookgwt.client.views;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.polytech.pooihm.phonebookgwt.client.controllers.MainViewController;

public class ContactInfoView extends Composite {

	// Graphical Attributes
	private Label contactName;
	private Label homeNumber;
	private Label mobileNumber;
	private Label workNumber;
	private Button modifyContact;

	// Attributes
	private String contactFirstName;
	private String contactLastName;
	private MainViewController controller;

	// Constructor
	public ContactInfoView(MainViewController mainViewController) {
		this.controller = mainViewController;
		builFrame();
	}

	// Methods
	private void builFrame() {
		VerticalPanel panel = new VerticalPanel();
		contactName = new Label(" ");
		contactName.getElement().setId("contactName");
		homeNumber = new Label(" ");
		homeNumber.getElement().setClassName("contactInfos");
		workNumber = new Label(" ");
		workNumber.getElement().setClassName("contactInfos");
		mobileNumber = new Label(" ");
		mobileNumber.getElement().setClassName("contactInfos");

		panel.add(contactName);
		panel.setCellHorizontalAlignment(contactName,
				HorizontalPanel.ALIGN_LEFT);
		panel.setCellVerticalAlignment(contactName,
				HorizontalPanel.ALIGN_MIDDLE);
		panel.setCellHeight(contactName, "20%");
		panel.add(homeNumber);
		panel.setCellHorizontalAlignment(homeNumber, HorizontalPanel.ALIGN_LEFT);
		panel.setCellVerticalAlignment(homeNumber, HorizontalPanel.ALIGN_MIDDLE);
		panel.setCellHeight(homeNumber, "10%");
		panel.add(workNumber);
		panel.setCellHorizontalAlignment(workNumber, HorizontalPanel.ALIGN_LEFT);
		panel.setCellVerticalAlignment(workNumber, HorizontalPanel.ALIGN_MIDDLE);
		panel.setCellHeight(workNumber, "10%");
		panel.add(mobileNumber);
		panel.setCellHorizontalAlignment(mobileNumber,
				HorizontalPanel.ALIGN_LEFT);
		panel.setCellVerticalAlignment(mobileNumber,
				HorizontalPanel.ALIGN_MIDDLE);
		panel.setCellHeight(mobileNumber, "10%");

		modifyContact = new Button("Modify");
		modifyContact.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.modifyContact(contactFirstName, contactLastName);
			}
		});

		panel.add(modifyContact);
		panel.setCellHorizontalAlignment(modifyContact,
				HorizontalPanel.ALIGN_RIGHT);
		panel.setCellVerticalAlignment(modifyContact,
				HorizontalPanel.ALIGN_BOTTOM);

		panel.setSize("100%", "100%");
		modifyContact.setEnabled(false);
		this.initWidget(panel);
	}

	public void setContactToDisplay(String fName, String lName, String hNum,
			String wNum, String mNum) {

		contactFirstName = fName;
		contactLastName = lName;
		contactName.setText(contactFirstName + " " + contactLastName);
		homeNumber.setText("Home : " + hNum);
		workNumber.setText("Work : " + wNum);
		mobileNumber.setText("Mobile : " + mNum);
		modifyContact.setEnabled(true);
	}

	public void clearView() {
		contactName.setText("");
		homeNumber.setText("");
		workNumber.setText("");
		mobileNumber.setText("");
		modifyContact.setEnabled(false);
	}

}
