package fr.galeriens.contactmanager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactManager manager = new ContactManager();
		manager.add("06 12 34 56 78", "Test", "test@test.com");
		manager.add("66 66 66 66 66", "Satan", "Satan@mail.com");
		manager.add("77 77 77 77 77", "Lucky Boy", "luckyboy@mail.com");
		System.out.println("------------------------------------");
		System.out.println("                DISPLAY             ");
		System.out.println("------------------------------------");
		manager.display();
		manager.remove(1);
		System.out.println("------------------------------------");
		System.out.println("                DISPLAY             ");
		System.out.println("------------------------------------");
		manager.display();
	}

}
