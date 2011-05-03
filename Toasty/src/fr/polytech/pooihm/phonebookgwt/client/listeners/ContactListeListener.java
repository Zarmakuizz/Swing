package fr.polytech.pooihm.phonebookgwt.client.listeners;

import java.util.EventListener;

public interface ContactListeListener extends EventListener {

	public void update(ContactListeChangedEvent evt);

}
