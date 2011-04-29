package polytech.gwt.client.view;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;

public class Accueil implements EntryPoint{
	public void onModuleLoad() {
	    // Make some radio buttons, all in one group.
	    RadioButton rb0 = new RadioButton("myRadioGroup", "foo");
	    RadioButton rb1 = new RadioButton("myRadioGroup", "bar");
	    RadioButton rb2 = new RadioButton("myRadioGroup", "baz");

	    // Check 'baz' by default.
	    rb2.setChecked(true);

	    // Add them to the root panel.
	    FlowPanel panel = new FlowPanel();
	    panel.add(rb0);
	    panel.add(rb1);
	    panel.add(rb2);
	    RootPanel.get().add(panel);
	  }
}
