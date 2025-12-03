// Lucas Phillips, CIS 340 T/TH 1:30-2:45, SDLC Project - Deliverable 4: Implementation/Prototyping

import java.util.ArrayList;
import java.util.Scanner;

public class LoginAndEventCreationRegistration {

	static ArrayList<User> users = new ArrayList<>();
	static ArrayList<Event> events = new ArrayList<>();

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		Boolean running = true;
		User currentUser = null;
		
		while(running) {
			System.out.println("\n === Login ===");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Please choose an option: ");
			
			String  choice = scanner.nextLine().toLowerCase();
			
			switch (choice) {
			case "register":
				registerUser(scanner);
				 break;
			case "login":
				currentUser = login(scanner);
				break;
			case "exit":
				running = false;
				break;
			default:
				System.out.println("\nInvalid option.");
			}
			while (currentUser != null) {
				System.out.println("\n === Main Menu ===");
				System.out.println("1. Create Event");
				System.out.println("2. Browse Events");
				System.out.println("3. Logout");
				System.out.print("Please choose an option: ");
				
				String eventChoice = scanner.nextLine().toLowerCase();
				
				switch (eventChoice) {
				case "create": 
				case "create event": 
				case "create events": 
					if (currentUser.canCreateEvents()) {
					eventCreation(scanner);
				} else {
					System.out.println("\nYou are not authorized to create events.");
				}
					break;
				case "browse": 
				case "browse events":
					eventBrowser(scanner);
					break;
				case "logout":
					currentUser = null;
					break;
				default:
					System.out.println("\nInvalid option.");
				}
			}
		}
	}
	public static void registerUser(Scanner scanner) {
		System.out.print("Enter username: ");
		String user = scanner.nextLine();
		
		System.out.print("Enter password: ");
		String password = scanner.nextLine();
		
		System.out.print("Enter role (admin/officer/student): ");
		String role = scanner.nextLine();
		
		if (!role.equals("admin") && !role.equals("officer") && !role.equals("student")) {
			role = "student";
		}
		
		users.add(new User(user, password, role));
		
		System.out.printf("\nUser %s registered as %s. \n", user, role);
	}
	public static User login(Scanner scanner) {
		if (users.size() == 0) {
			System.out.println("\nNo users registered yet. Please register first.");
			return null;
		}
		
		System.out.print("Username: ");
		String username = scanner.nextLine();
		
		System.out.print("Password: ");
		String password = scanner.nextLine();
		
		User foundUser = null;
		for (User u : users) {
			if (u.getUsername().equals(username)) {
				foundUser = u;
				break;
			}
		}
		if (foundUser == null) {
			System.out.println("\nUsername not found. Please register first.");
			return null;
		}
		if (foundUser.checkPassword(password)) {
			System.out.println("\nLogin succesful!");
			return foundUser;
		} else {
			System.out.println("\nIncorrect password.");
			return null;
		}
	}
	public static void eventCreation(Scanner scanner) {
		System.out.print("Enter event name: ");
		String eventName = scanner.nextLine();
		
		System.out.print("Enter event date (MM/DD/YYYY): ");
		String date = scanner.nextLine();
		
		System.out.print("Enter event building: ");
		String building = scanner.nextLine();
		
		System.out.print("Enter event room: ");
		String room = scanner.nextLine();
		
		Event newEvent = new Event(eventName, date, building, room);
		events.add(newEvent);
		
		System.out.printf("\nEvent %s created succesfully!", eventName);
	}
	public static void eventBrowser(Scanner scanner) {
		if (events.size() == 0) {
			System.out.println("\nNo events currently.");
			return;
		}
		System.out.println("\n=== Events ===");
		for (int i = 0; i < events.size(); i++) {
			System.out.println((i + 1) + ". " + events.get(i));
		}
	}
}