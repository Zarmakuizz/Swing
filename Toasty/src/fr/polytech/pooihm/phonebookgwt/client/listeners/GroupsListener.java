package fr.polytech.pooihm.phonebookgwt.client.listeners;

import java.util.EventListener;

public interface GroupsListener extends EventListener {

	public void contactAddedToGroup(ContactAddedToGroupEvent evt);

}
