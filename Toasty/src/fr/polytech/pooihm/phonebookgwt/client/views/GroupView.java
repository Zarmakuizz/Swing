package fr.polytech.pooihm.phonebookgwt.client.views;

import java.util.Set;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.polytech.pooihm.phonebookgwt.client.controllers.MainViewController;
import fr.polytech.pooihm.phonebookgwt.client.listeners.ContactAddedToGroupEvent;
import fr.polytech.pooihm.phonebookgwt.client.listeners.GroupsListener;

public class GroupView extends Composite implements GroupsListener {

	// Graphical attributes
	private ListBox liste;
	private Label label;
	private Set<String> groups;
	private MainViewController controller;

	// Constructor
	public GroupView(MainViewController mainViewController, Set<String> groups) {
		this.groups = groups;
		this.controller = mainViewController;
		buildFrame();
	}

	// Methods
	private void buildFrame() {
		// Configuring the JPanel
		VerticalPanel panel = new VerticalPanel();

		// Initializing graphical components
		liste = new ListBox(false);
		liste.setVisibleItemCount(2);
		liste.setSize("100%", "100%");

		liste.addItem("All");
		for (String group : groups)
			liste.addItem(group);
		liste.setSelectedIndex(0);

		liste.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				int i = liste.getSelectedIndex();
				controller.selectedGroupChanged(liste.getItemText(i));
			}
		});
		label = new Label("Groups");
		panel.add(label);
		panel.add(liste);

		panel.setCellHeight(label, "24px");
		panel.setCellHeight(liste, "100%");
		this.initWidget(panel);

	}

	@Override
	public void contactAddedToGroup(ContactAddedToGroupEvent evt) {
		int i;
		for (i = 0; i < liste.getItemCount(); i++) {
			if (liste.getItemText(i).equals(evt.getGroupName())) {
				break;
			}
		}
		liste.setSelectedIndex(i);
		controller.selectedGroupChanged(evt.getGroupName());
	}
}