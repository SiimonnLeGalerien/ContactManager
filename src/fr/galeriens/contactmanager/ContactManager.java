package fr.galeriens.contactmanager;

import java.util.ArrayList;

public class ContactManager {
	private ArrayList<Contact> list;
	
	/**
	 * Basic constructor
	 */
	public ContactManager() {
		list = new ArrayList<Contact>();
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
	}
	
	public void add(String number) {
		list.add(new Contact(number));
	}
	
	public void add(String number, String name) {
		list.add(new Contact(number, name));
	}
	
	public void add(String number, String name, String email) {
		list.add(new Contact(number, name, email));
	}
	
	/**
	 * Removes a contact by index
	 * @param index
	 */
	public void remove(int index) {
		list.remove(index);
	}
	
}
