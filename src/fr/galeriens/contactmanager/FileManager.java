package fr.galeriens.contactmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
	public FileManager () {
		
	}
	
	public void loadContacts (String filename, ContactManager manager) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
			String line;
			while ((line = reader.readLine()) != null) {
				Contact contact = parseContact(line);
				if (contact != null)
					manager.add(contact);
			}
		} catch (IOException e) {
			System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
		}
		
	}
	
	private Contact parseContact(String line) {
		String[] parts = line.split(",");
		if (parts.length == 3)
			return new Contact(parts[1], parts[0], parts[2]);
		return null;
	}
	
	public boolean saveContacts (String filename, List<Contact> contacts) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			String line;
			for (int i = 0; i < contacts.size(); i++) {
				line = contacts.get(i).toSave();
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erreur lors de l'écriture du fichier : " + e.getMessage());
		}
		return true;
	}
	
}
