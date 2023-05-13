package com.bl.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class Function {
    private final Map<String, List<Address_Book_Main>> addressbookmainmap = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void addContact(Address_Book_Main contact) {
        String city = contact.getCity();
        String state = contact.getState();

        if (addressbookmainmap.containsKey(city)) {
            addressbookmainmap.get(city).add(contact);
        } else {
            List<Address_Book_Main> cityContacts = new ArrayList<>();
            cityContacts.add(contact);
            addressbookmainmap.put(city, cityContacts);
        }


        if (addressbookmainmap.containsKey(state)) {
            addressbookmainmap.get(state).add(contact);
        } else {
            List<Address_Book_Main> stateContacts = new ArrayList<>();
            stateContacts.add(contact);
            addressbookmainmap.put(state, stateContacts);
        }
    }

    public void displayContacts() {
        if (addressbookmainmap.isEmpty()) {
            System.out.println("No contacts found!");
        } else for (List<Address_Book_Main> contacts : addressbookmainmap.values()) {
            for (Address_Book_Main contact : contacts) {
                System.out.println(contact);
            }
        }
    }
    public void searchByState() {
        System.out.println("Enter State to Search");
        String state = sc.next();
        List<Address_Book_Main> contacts = addressbookmainmap.values().stream()
                .flatMap(List::stream)
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
        if (contacts.isEmpty()) {
            System.out.println("No contacts found in " + state);
        } else {
            contacts.forEach(p -> System.out.println(p.getFirstName()));
        }
    }
    public void searchByCity() {
        System.out.println("Enter city to search:");
        String city = sc.next();
        List<Address_Book_Main> contacts = addressbookmainmap.values().stream()
                .flatMap(List::stream)
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        if (contacts.isEmpty()) {
            System.out.println("No contacts found in " + city);
        } else {
            contacts.forEach(p -> System.out.println(p.getFirstName()));
        }
    }


    public void deleteContact(String remove)
    {
        addressbookmainmap.remove(remove);
        System.out.println("Contact deleted successfully!");
    }
}

