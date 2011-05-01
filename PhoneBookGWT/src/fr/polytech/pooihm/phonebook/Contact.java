package fr.polytech.pooihm.phonebook;

/**
 * Class representing a contact.
 * A contact is identified by a person and holds telephone numbers (home number, office number and cellular number).
 * @author Occello Audrey
 *
 */
public class Contact implements Comparable<Contact> {
	private Person person;
	private String homenum;
	private String officenum;
	private String cellnum;
    
	/**
	 * The person (p) first name and last name are mandatory.
	 * @param p a person.
	 * @param hn a home number.
	 * @param on a office number.
	 * @param cn a cellular number.
	 */
	public Contact(Person p, String hn, String on, String cn){
	  	person = p;
	  	setHomenum(hn);
	    setOfficenum(on);
	  	setCellnum(cn);
	}
	
	/**
	 * Two contacts are identical if they are associated with the same person.
	 */
	public int compareTo(Contact c) {
		return this.getPerson().compareTo(c.getPerson());
	}
	
	/**
	 * Two contacts are identical if they are associated with the same person.
	 */	
	public boolean equals(Object o) {
		if (o instanceof Contact) return this.getPerson().equals(((Contact)o).getPerson());
		else return false;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setHomenum(String homenum) {
		this.homenum = homenum;
	}

	public String getHomenum() {
		return homenum;
	}

	public void setOfficenum(String officenum) {
		this.officenum = officenum;
	}

	public String getOfficenum() {
		return officenum;
	}

	public void setCellnum(String cellnum) {
		this.cellnum = cellnum;
	}

	public String getCellnum() {
		return cellnum;
	}
	
	/**
	 * Return the person identity concatenated to the phone numbers.
	 */
	public String toString() {
		String s = person.toString() +"\n";
		s += ((homenum=="")?"n/a":homenum) +"\n";
		s += ((officenum=="")?"n/a":officenum) +"\n";
		s += ((cellnum=="")?"n/a":cellnum) +"\n";
		return s;
	}
}
