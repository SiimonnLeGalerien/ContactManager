package fr.galeriens.contactmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactManager {
	private List<Contact> list;
	private Map<String, Contact>map;
	
	/**
	 * Basic constructor
	 */
	public ContactManager() {
		list = new ArrayList<Contact>();
		map = new HashMap<String, Contact>();
	}
	
	public List<Contact> getList () {
		return this.list;
	}
	
	/**
	 * Displays all contacts by lines with the toString() method
	 * 
	 * @return void
	 */
	public void display() {
		for (int i = 0 ; i < list.size(); i++)
			System.out.println(list.get(i).toString());
	}
	
	/**
	 * These methods add a contact with each parameter needed
	 * 
	 * @param (optional) Strings number, name, email
	 * @return void
	 */
	public void add() {
		list.add(new Contact());
		map.put("noname", new Contact());
	}
	
	/**
	 * add method with a number only
	 * @param number Contact's Number
	 */
	public void add(String number) {
		list.add(new Contact(number));
		map.put("noname", new Contact(number));
	}
	
	/**
	 * add method with contact's number and contact's name
	 * @param number Contact's Number
	 * @param name Contact's Name
	 */
	public void add(String number, String name) {
		list.add(new Contact(number, name));
		map.put(name.toLowerCase(), new Contact(number, name));
	}
	
	/**
	 * add method with all contact's informations
	 * @param number Contact's Number
	 * @param name Contact's Name
	 * @param email Contact's Email
	 */
	public void add(String number, String name, String email) {
		list.add(new Contact(number, name.toLowerCase(), email));
		map.put(name.toLowerCase(), new Contact(number, name, email));
	}
	
	/**
	 * add a contact to list and map
	 * @param contact's Contact's object
	 */
	public void add(Contact contact) {
		list.add(contact);
		map.put(contact.getName().toLowerCase(), contact);
	}
	/**
	 * Removes a contact by index
	 * @param index
	 */
	public void remove(int index) {
		map.remove(list.get(index).getName().toLowerCase());
		list.remove(index);
	}
	
	/**
	 * Remove a contact by name
	 * @param name
	 * @return Success Statement
	 */
	public boolean remove(String name) {
		map.containsKey(name.toLowerCase());
		int id = getIdByName(name.toLowerCase());
		if ( id != -1) {
			list.remove(id);
			map.remove(name.toLowerCase());
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * get contact's ID by name
	 * @param name of contact
	 * @return ID, -1 if id's not found
	 */
	public int getIdByName(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (name.toLowerCase().equals(list.get(i).getName().toLowerCase()))
				return i;
			
		}
		return -1;
	}
	
	/**
	 * Id's validation by size or < 0
	 * @param id Contact's Id
	 * @return validation or not
	 */
	private boolean isValidId(int id) {
		return id >= list.size() || id < 0?false:true;
	}
	/**
	 * modify Contact's Name by Id
	 * @param id Contact's Id
	 * @param name New Contact's Name
	 * @return Success Statement
	 */
	public boolean modifyContactName(int id, String name) {
		if (!isValidId(id))
			return false;
		list.get(id).setName(name);
		return name.equals(list.get(id).getName());
	}
	
	/**
	 * modify Contact's Name by previous name
	 * @param contactName Contact's previous Name
	 * @param name New Contact's Name
	 * @return Success Statement
	 */
	public boolean modifyContactName(String contactName, String name) {
		int id = getIdByName(contactName);
		if (!isValidId(id))
			return false;
		list.get(id).setName(name);
		return name.equals(list.get(id).getName());
	}
	
	/**
	 * modify Contact's Number by Id
	 * @param id Contact's Id
	 * @param number New Contact's Number 
	 * @return Success Statement
	 */
	public boolean modifyContactNumber(int id, String number) {
		if (!isValidId(id))
			return false;
		list.get(id).setNumber(number);
		return number.equals(list.get(id).getNumber());
	}
	
	/**
	 * modify Contact's Number by Contact's Name
	 * @param contactName Contact's Name
	 * @param number New Contact's Number
	 * @return Success Statement
	 */
	public boolean modifyContactNumber(String contactName, String number) {
		int id = getIdByName(contactName);
		if (!isValidId(id))
			return false;
		list.get(id).setNumber(number);
		return number.equals(list.get(id).getNumber());
	}
	
	/**
	 * modify Contact's Email by Contact's Id
	 * @param id Contact's Id
	 * @param email New Contact's Email
	 * @return Success Statement
	 */
	public boolean modifyContactEmail(int id, String email) {
		if (!isValidId(id))
			return false;
		list.get(id).setEmail(email);
		return email.equals(list.get(id).getEmail());
	}
	
	/**
	 * modify Contact's Email by Contact's Name
	 * @param contactName Contact's Name
	 * @param email New Contact's Email
	 * @return Success Statement
	 */
	public boolean modifyContactEmail(String contactName, String email) {
		int id = getIdByName(contactName);
		if (!isValidId(id))
			return false;
		list.get(id).setEmail(email);
		return email.equals(list.get(id).getEmail());
	}
	
}
