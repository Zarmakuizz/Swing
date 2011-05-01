package fr.polytech.pooihm.phonebook;

import java.util.ArrayList;

/**
 * Class representing a group.
 * @author Occello Audrey
 *
 */
public class Group {
	private ArrayList<Contact> groupList;
	private String groupName;
	
	public Group(String name) {
		this(new ArrayList<Contact>(), name);		
	}
	public Group(ArrayList<Contact> gp, String name) {
		groupName=name;
		groupList = gp;
	}

	public ArrayList<Contact> getGroupList() {
		return groupList;
	}
	
	public boolean addToGroup(Contact c) {
		if (groupList.contains(c)) return false;
		groupList.add(c);
		return true;
	}
	
	public boolean removeFromGroup(Contact c) {
		if (!groupList.contains(c)) return false;
		return groupList.remove(c);
	}

	public String getGroupName() {
		return groupName;
	}
	
	public String toString() {
		return groupName;
	}
}
