package fr.polytech.pooihm.phonebook;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;

/**
 * Class representing a phone book. 
 * @author Occello Audrey
 *
 */
public class PhoneBook {
	private Person owner;
	private ArrayList<Contact> contactList;
	private HashMap<String, Group> groupList;
	
	/**
	 * Create an empty phone book whose owner is p.
	 * @param p the person owning the phone book.
	 */
	public PhoneBook(Person p) {
		owner = p;
		contactList = new ArrayList<Contact>();
		groupList = new HashMap<String, Group>();
	}
	
	/**
	 * Default constructor that creates the phone book of Abraham Simpson (the father of Homer).
	 * Three groups (family, business, friends) are added as well as a set of default contacts.
	 * To use for test purpose.
	 */
	public PhoneBook() {
		owner = new Person("Abraham", "Simpson");
		
		contactList = new ArrayList<Contact>();
		groupList = new HashMap<String, Group>();
		
		Person tom = new Person("Tom", "Sawyer");
		Person alice = new Person("Alice", "Wonderland");
		Person mickey = new Person("Mickey", "Mouse");
		Person mini = new Person("Mini", "Mouse");
		Person donald = new Person("Donal", "Duck");
		Person roger = new Person("Roger", "Rabbit");
		Person homer = new Person("Homer", "Simpson");
		Person marge = new Person("Marge", "Simpson");
		Person bart = new Person("Bart", "Simpson");
		Person lisa = new Person("Lisa", "Simpson");
		Person maggie = new Person("Maggie", "Simpson");
		
		Contact tomc = new Contact(tom, "", "0400000001", "");
		Contact alicec = new Contact(alice, "", "0400000002", "0600000002");
		Contact mickeyc = new Contact(mickey, "0900000003", "", "0600000003");
		Contact minic = new Contact(mini, "0900000003", "", "0600000004");
		Contact donaldc = new Contact(donald, "0900000005", "", "");
		Contact rogerc = new Contact(roger, "", "", "0600000006");
		Contact homerc = new Contact(homer, "0900000007", "0400000007", "0600000007");
		Contact margec = new Contact(marge, "0900000007", "", "0600000008");
		Contact bartc = new Contact(bart, "0900000007", "", "0600000009");
		Contact lisac = new Contact(lisa, "0900000007", "", "0600000010");
		Contact maggiec = new Contact(maggie, "0900000007", "", "");
		
		contactList.add(tomc);
		contactList.add(alicec);
		contactList.add(mickeyc);
		contactList.add(minic);
		contactList.add(donaldc); 
		contactList.add(rogerc);
		contactList.add(homerc);
		contactList.add(margec);
		contactList.add(bartc);
		contactList.add(lisac);
		contactList.add(maggiec);
		
		Group family = new Group("Family");
		Group friends = new Group("Friends");
		Group business = new Group("Business");
		
		groupList.put(family.getGroupName(), family);
		groupList.put(friends.getGroupName(), friends);
		groupList.put(business.getGroupName(), business);
		
		business.addToGroup(tomc);
		business.addToGroup(alicec);
		friends.addToGroup(donaldc);
		friends.addToGroup(rogerc);
		friends.addToGroup(mickeyc);
		friends.addToGroup(minic);
		family.addToGroup(homerc);
		family.addToGroup(margec);
		family.addToGroup(bartc);
		family.addToGroup(lisac);
		family.addToGroup(maggiec);
	}
	
	/**
	 * Retrieve the owner identity of the phone book.
	 * @return the owner.
	 */
	public Person phoneBookOwner() {
		return owner;
	}
	
	/**
	 * Add a new contact to the phone book.
	 * An exception is thrown if the contact already exists.
	 * @param c the contact to be added.
	 * @throws ContactAlreadyDefinedException
	 */
	public void addContact(Contact c) throws ContactAlreadyDefinedException {
		if (contactList.contains(c)) throw new ContactAlreadyDefinedException("Contact info for "+c.getPerson()+ " already defined!");
		contactList.add(c);
	}
	/** 
	 * Delete a contact from the phone book.
	 * An exception is thrown if attempting to remove a contact that does not exists.
	 * @param c the contact to be deleted.
	 * @throws ContactNotDefinedException
	 */
	public void deleteContact(Contact c) throws ContactNotDefinedException {
		if (!contactList.contains(c)) throw new ContactNotDefinedException("Contact "+c.getPerson()+ " not defined!");
		Collection<Group> gc = groupList.values();
		Iterator<Group> it = gc.iterator();
		while (it.hasNext()) it.next().removeFromGroup(c);
		contactList.remove(c);
	}
	/**
	 * 
	 * @param c the old content of the contact
	 * @param newc the new content of the contact
	 * @throws ContactNotDefinedException
	 * @throws ContactAlreadyDefinedException
	 * @throws ContactUpdateException
	 */
	public void modifyContact(Contact c, Contact newc) throws ContactNotDefinedException, ContactAlreadyDefinedException, ContactUpdateException {
		if (!c.getPerson().equals(newc.getPerson())) throw new ContactUpdateException("The firstname and lastname of a contact cannot be changed!");
		deleteContact(c);
		addContact(newc);
	}
	
	/**
	 * Retrieve all the contacts of the phone book.
	 * @return the list of contacts.
	 */
	public Collection<Contact> getAllContacts() {
		return contactList;
	}
	
	/**
	 * Retrieve all the contact identities (Person) of the phone book.
	 * @param contacts is the list of contacts with phone number details.
	 * @return the list of persons.
	 */
	public Collection<Person> getContactsWithoutDetails(Collection<Contact> contacts) {
		Collection<Person> cp = new ArrayList<Person>();
		Iterator<Contact> it = contacts.iterator();
		while (it.hasNext()) cp.add(it.next().getPerson());
		return cp;
	}
	
	/**
	 * Retrieve all the group names.
	 * @return the list of existing group names.
	 */
	public Set<String> getGroupNames() {
		return groupList.keySet();
	}
	/**
	 * Retrieve the contacts belonging to a given group.
	 * An exception is thrown if the group does not exists.
	 * @param groupname the name of the group whose contacts will be retrieved.
	 * @return the list of contacts associated with the given group.
	 * @throws GroupNotDefinedException
	 */
	public Collection<Contact> getContactsByGroup(String groupname) throws GroupNotDefinedException {
		if (! groupList.containsKey(groupname)) throw new GroupNotDefinedException(groupname+" does not correspond to a group");
		return (groupList.get(groupname)).getGroupList();
	}
}
