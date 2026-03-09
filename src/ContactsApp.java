

import java.util.Scanner;

public class ContactsApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ContactsManager manager = new ContactsManager();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    handleAddContact();
                    break;
                case 2:
                    handleDisplayContacts();
                    break;
                case 3:
                    handleSearchContact();
                    break;
                case 4:
                    handleDeleteContact();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                	System.out.println("");
                    System.out.println("Invalid choice. Please select a valid option");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== Contact Management System ===");
        System.out.println("");
        System.out.println("1. Add a new contact");
        System.out.println("2. Display all contacts");
        System.out.println("3. Search for a contact by name");
        System.out.println("4. Delete a contact by name");
        System.out.println("5. Exit");
        System.out.println("");
        System.out.print("Please enter your choice: ");
    }

    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {

        }
        return choice;
    }

    private static void handleAddContact() {
        System.out.println("\n--- Add New Contact ---");
        String name = promptForInput("Enter name: ");
        String phone = promptForInput("Enter phone: ");
        String email = promptForInput("Enter email: ");
        Contact contact = new Contact(name, phone, email);
        manager.addContact(contact);
        System.out.println("");
        System.out.println("Contact added successfully!");
        System.out.println("");
        System.out.println("");
    }

    private static void handleDisplayContacts() {
        System.out.println("\n--- All Contacts ---");
        manager.displayAllContacts();
    }

    private static void handleSearchContact() {
        System.out.print("\nEnter the name to search: ");
        String name = scanner.nextLine().trim();
        Contact contact = manager.searchContactByName(name);
        if (contact != null) {
        	 System.out.println("");
            System.out.println("Contact found: " + contact);
            System.out.println("");
            System.out.println("");
        } else {
        	 System.out.println("");
            System.out.println("No contact found with the name: " + name);
            System.out.println("");
            System.out.println("");
        }
    }

    private static void handleDeleteContact() {
        System.out.print("\nEnter the name of the contact to delete: ");
        String name = scanner.nextLine().trim();
        Contact contact = manager.searchContactByName(name);
        if (contact != null) {
        	 System.out.println("");
            System.out.println("Contact found: " + contact);
            System.out.println("");
            System.out.print("Are you sure you want to delete this contact? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();
            if (confirmation.equals("yes") || confirmation.equals("y")) {
                if (manager.deleteContactByName(name)) {
                	System.out.println("");
                    System.out.println("Contact deleted successfully.");
                    System.out.println("");
                    System.out.println("");
                } else {
                	 System.out.println("");
                    System.out.println("Failed to delete contact. Please try again.");
                    System.out.println("");
                    System.out.println("");
                }
            } else {
                System.out.println("Deletion canceled.");
                System.out.println("");
                System.out.println("");
            }
        } else {
            System.out.println("No contact found with the name: " + name);
            System.out.println("");
            System.out.println("");
        }
    }

    private static String promptForInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                break;
            } else {
                System.out.println("Input cannot be empty. Please try again.");
                System.out.println("");
                System.out.println("");
            }
        }
        return input;
    }
}
