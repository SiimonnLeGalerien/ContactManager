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
		this("00 00 00 00 00", "NoName", "empty@email.com");
	}
	
	/**
	 * Constructor with only a telephone number
	 * 
	 * @param number Contact's telephone number
	 */
	public Contact(String number) {
		if (isValidPhoneNumber(number)) {
			this.number = number;
		} else {
			this.number = "00 00 00 00 00";
		}
		this.name = "NoName";
		this.email = "empty@email.com";
	}
	
	/**
	 * Constructor with a telephone number and a name
	 * 
	 * @param number Contact's telephone number
	 * @param name Contact's name
	 */
	public Contact(String number, String name) {
		if (isValidPhoneNumber(number)) {
			this.number = number;
		} else {
			this.number = "00 00 00 00 00";
		}
			
		if (isValidName(name)) {
			this.name = name;
		} else {
			this.name = "invalidName";
		}
		this.email = "empty@email.com";
	}
	
	/**
	 * Constructor with a telephone number, a name and an email
	 * 
	 * @param number Contact's telephone number
	 * @param name Contact's name
	 * @param email Contact's email
	 */
	public Contact(String number, String name, String email) {
		
		if (isValidPhoneNumber(number)) {
			this.number = number;
		} else {
			this.number = "00 00 00 00 00";
		}
			
		if (isValidName(name)) {
			this.name = name;
		} else {
			this.name = "invalidName";
		}
		
		if (isValidEmail(email)) {
			this.email = email;
		} else {
			this.email = "invalid@email.com";
		}
	}
	// Validations methods

    private boolean isValidPhoneNumber(String number) {
        // phone number's regular expression
        String regex = "^[+]?[0-9 ]+$";
        return number.matches(regex);
    }

    private boolean isValidName(String name) {
        // name's regular expression
        String regex = "^[a-zA-Z\\s-']+$";
        return name.matches(regex);
    }

    private boolean isValidEmail(String email) {
        // email's regular expression
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,63}$";
        return email.matches(regex);
    }
    
	//SETTERS
	public void setNumber(String number) {
		if (isValidPhoneNumber(number))
			this.number = number;
		
	}
	
	public void setName(String name) {
		if (isValidName(name))
			this.name = name;
	}
	
	public void setEmail(String email) {
		if (isValidEmail(email))
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
	/**
	 * format Contact to saving
	 * @return formatted String
	 */
	public String toSave() {
		return name+","+number+","+email;
	}
}
