package fr.galeriens.contactmanager;

/**
 * This class represents a contact with a telephone number, a name and an email.
 */
public class Contact {
	private String number;
	private String name;
	private String email;
	
	/**
	 * Default constructor creates empty contact
	 */
	public Contact() {
		this("", "", "");
	}
	
	/**
	 * Constructor with only a telephone number
	 * 
	 * @param number Contact's telephone number
	 */
	public Contact(String number) {
		this(number, "", "");
	}
	
	/**
	 * Constructor with a telephone number and a name
	 * 
	 * @param number Contact's telephone number
	 * @param name Contact's name
	 */
	public Contact(String number, String name) {
		this(number, name, "");
	}
	
	/**
	 * Constructor with a telephone number, a name and an email
	 * 
	 * @param number Contact's telephone number
	 * @param name Contact's name
	 * @param email Contact's email
	 */
	public Contact(String number, String name, String email) {
		
		this.number = number;
		this.name = name;
		this.email = email;
	}
	
	//SETTERS
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//GETTERS
	public String getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return name + " : " + number + " | " + email;
	}
}
