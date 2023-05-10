package com.bl.address_book;

import java.util.*;

public class AddContact {

    private Map<Object, ArrayList<AddressBookMain>> addressBookMap = new HashMap<>();

    public List<ArrayList<AddressBookMain>> getFirst(String firstName) {
        if (!addressBookMap.containsKey(firstName)) {
            System.out.println("No contacts found for first name: " + firstName);
            return Collections.emptyList();
        }
        return Collections.singletonList(addressBookMap.get(firstName));
    }


    public void addContact(AddressBookMain contact) {
        String firstName = contact.getFirstName();
        ArrayList<AddressBookMain> contacts = addressBookMap.getOrDefault(firstName, new ArrayList<>());
        contacts.add(contact);
        addressBookMap.put(firstName, contacts);
        System.out.println("Contact added successfully!");
    }

    public void displayContacts() {
        if (addressBookMap.isEmpty()) {
            System.out.println("No contacts found!");
        } else {
            for (ArrayList<AddressBookMain> contact : addressBookMap.values()) {
                System.out.println(contact);
            }
        }
    }

    public ArrayList<AddressBookMain> search(String firstName) {
        return addressBookMap.get(firstName);
    }

    public void deleteContact(String firstName) {
        addressBookMap.remove(firstName);
        System.out.println("Contact deleted successfully!");
    }

    public static void main(String[] args) {
        AddContact contacts = new AddContact();
        Scanner sc = new Scanner(System.in);

        int ch;
        do {
            System.out.println("Press 1 to add contact");
            System.out.println("Press 2 to display contacts");
            System.out.println("Press 3 to search for a contact");
            System.out.println("Press 4 to delete a contact");
            System.out.println("Press 0 to exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            if (ch == 1) {
                System.out.println("Enter First Name: ");
                String firstName = sc.next();
                System.out.println("Enter Last Name: ");
                String lastName = sc.next();
                System.out.println("Enter Address: ");
                String address = sc.next();
                System.out.println("Enter State: ");
                String state = sc.next();
                System.out.println("Enter City: ");
                String city = sc.next();
                System.out.println("Enter Zip Code: ");
                int zipcode = sc.nextInt();
                System.out.println("Enter Phone Number: ");
                long phonenum = sc.nextLong();
                System.out.println("Enter E-mail: ");
                String emailid = sc.next();

                contacts.addContact(new AddressBookMain(firstName, lastName, address, city, state, zipcode, phonenum, emailid));
            } else if (ch == 2) {
                contacts.displayContacts();
            } else if (ch == 3) {
                System.out.println("Enter First Name: ");
                String firstName = sc.next();
                ArrayList<AddressBookMain> contact = contacts.search(firstName);
                if (contact != null) {
                    System.out.println(contact);
                } else {
                    System.out.println("Contact not found!");
                }
            } else if (ch == 4) {
                System.out.println("Enter First Name: ");
                String firstName = sc.next();
                ArrayList<AddressBookMain> contact = contacts.search(firstName);
                if (contact != null) {
                    contacts.deleteContact(firstName);
                } else {
                    System.out.println("Contact not found!");
                }
            }
        } while (ch != 0);

        sc.close();
    }

                    }
