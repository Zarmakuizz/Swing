package fr.polytech.pooihm.phonebookgwt.client.views;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.LayoutPanel;

public class MainWindow extends Composite {

	public MainWindow(GroupView grView, ContactsView ctsView,
			ContactInfoView ctInfoView) {
		// Configuring frame

		LayoutPanel mainPanel = new LayoutPanel();
		HorizontalPanel panel = new HorizontalPanel();
		panel.setBorderWidth(1);
		// Adding views to the JFrame

		grView.setWidth("100%");
		grView.setSize("100%", "100%");
		panel.add(grView);

		ctsView.setWidth("100%");
		ctsView.setSize("100%", "100%");
		panel.add(ctsView);

		ctInfoView.setSize("100%", "100%");
		panel.add(ctInfoView);

		panel.setCellWidth(grView, "30%");
		panel.setCellWidth(ctsView, "30%");

		panel.setCellWidth(ctInfoView, "40%");

		panel.setSize("100%", "100%");
		mainPanel.add(panel);

		mainPanel.setWidgetLeftRight(panel, 10, Unit.PCT, 10, Unit.PCT);
		mainPanel.setWidgetTopBottom(panel, 10, Unit.PCT, 10, Unit.PCT);

		this.initWidget(mainPanel);
	}
}
