package refactor;

import java.util.*;

public class Function {
    private final Map<String, List<Address_Book_Main>> addressbookmainmap = new HashMap<>();

    public void addContact(Address_Book_Main contact) {
        String city = contact.getCity();
        List<Address_Book_Main> contacts = addressbookmainmap.getOrDefault(city, new ArrayList<>());
        contacts.add(contact);
        addressbookmainmap.put(city, contacts);
        System.out.println("Contact Added Successfully");
    }

    public void displayContacts() {
        if (addressbookmainmap.isEmpty()) {
            System.out.println("No contacts found!");
        } else {
            for (List<Address_Book_Main> contacts : addressbookmainmap.values()) {
                for (Address_Book_Main contact : contacts) {
                    System.out.println(contact);
                }
            }
        }
    }

    public void searchContact(String city) {
        List<Address_Book_Main> contacts = addressbookmainmap.get(city);
        if (contacts == null) {
            System.out.println("No contact found in " + city);
        } else {
            for (Address_Book_Main contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void searchByCity(String city) {
        List<Address_Book_Main> contacts = addressbookmainmap.get(city);
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("No contacts found in " + city);
        } else {
            System.out.println("Contacts in " + city + ":");
            for (Address_Book_Main contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void deleteContact(String firstName) {
        boolean removed = false;
        for (String city : addressbookmainmap.keySet()) {
            List<Address_Book_Main> contacts = addressbookmainmap.get(city);
            for (int i = 0; i < contacts.size(); i++) {
                Address_Book_Main contact = contacts.get(i);
                if (contact.getFirstName().equals(firstName)) {
                    contacts.remove(i);
                    removed = true;
                    break;
                }
            }
            if (removed) {
                System.out.println("Contact deleted successfully!");
                break;
            }
        }
        if (!removed) {
            System.out.println("Contact not found!");
        }
    }
}

