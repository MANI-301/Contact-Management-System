

import java.util.ArrayList;
import java.util.List;

public class ContactsManager {
    private List<Contact> contacts;

    public ContactsManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
            System.out.println("");
            System.out.println("");
            return;
        }
        System.out.println("");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("");
            System.out.println("");
        }
    }

    public Contact searchContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public boolean deleteContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                return true;
            }
        }
        return false;
    }
}