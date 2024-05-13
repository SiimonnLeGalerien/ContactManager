package fr.galeriens.contactmanager;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static ContactManager contactManager = new ContactManager();
    private static FileManager fileManager = new FileManager();

	public static void main(String[] args) throws NumberFormatException, IOException {
        boolean running = true;
        
        fileManager.loadContacts("contacts.csv", contactManager);

        while (running) {
            System.out.println("\nGestionnaire de Contacts");
            System.out.println("1. Ajouter un contact");
            System.out.println("2. Supprimer un contact");
            System.out.println("3. Afficher les contacts");
            System.out.println("4. Rechercher un contact");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option: ");

            int choice = Integer.parseInt(reader.readLine());
            reader.readLine();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                	deleteContact();
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    searchContact();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
        reader.close();
        fileManager.saveContacts("contacts.csv", contactManager.getList());
        System.out.println("Application terminée.");
	}

	private static void searchContact() throws IOException {
		System.out.println("Entrer le nom du contact :");
		String name = reader.readLine();
		int i = contactManager.getIdByName(name);
		if (i != -1) {
			System.out.println(contactManager.getList().get(i));
		} else {
			System.out.println("Le contact " + name + " n'as pas été trouvé");
		}
	}

	private static void displayContacts() {
		contactManager.display();
		
	}

	private static void deleteContact() throws IOException {
		System.out.println("Entrer le nom du contact :");
		String name = reader.readLine();
		if (contactManager.remove(name)) {
			System.out.println("Suppression de " + name + " réussie.");
		} else {
			System.out.println("Suppression de " + name + " échouée.");
		}
		
	}

	private static void addContact() throws IOException {
        System.out.println("Entrer le nom du contact :");
        String name = reader.readLine();
        System.out.println("Entrer le numéro de téléphone :");
        String phone = reader.readLine();
        System.out.println("Entrer l'adresse email ou entrer non si non communiqué");
        String email = reader.readLine();
        if (!email.toLowerCase().equals("non")) {
        	contactManager.add(phone, name, email);
        	System.out.println(contactManager.getList().get(contactManager.getList().size()-1).toString());
        	return;
        }
        contactManager.add(phone, name);
        System.out.println("Contact ajouté : " + name + " - " + phone);
        
        
    }

}
