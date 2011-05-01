package fr.polytech.pooihm.phonebook;

/**
 * Class representing a person.
 * @author Occello Audrey
 *
 */
public class Person implements Comparable<Person> {
    private String firstname;
	private String lastname;
	
	/**
	 * @param first is the first name of the person.
	 * @param last is the last name of the person.
	 */
	public Person(String first, String last) {
		firstname = first;
		lastname = last;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

    /**
     * Two persons are identical if they hold the same last name and same first name.
     */
	public int compareTo(Person p) {
		if (p.getLastname().equals(this.getLastname()))
			if (p.getFirstname().equals(this.getFirstname())) return 0;
			else return getFirstname().compareTo(p.getFirstname());
		else return getLastname().compareTo(p.getLastname());
	}
	
    /**
     * Two persons are identical if they hold the same last name and same first name.
     */
	public boolean equals(Object o) {
		if (o instanceof Person) return (((Person) o).getLastname().equals(this.getLastname()) && ((Person) o).getFirstname().equals(this.getFirstname()));
		else return false;
	}
	
	/**
	 * Return the last name concatenated to the first name.
	 */
	public String toString() {
		return firstname + " " + lastname;
	}
	
}
