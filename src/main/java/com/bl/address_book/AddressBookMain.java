package com.bl.address_book;
import java.util.ArrayList;
import java.util.Scanner;
public class AddressBookMain
{
    public static void main(String[] args) {
        System.out.println("welcome to the address_book project");
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Enter a command (add, quit): ");
            String cm = sc.nextLine();

            if (cm.equals("add")) {
                System.out.println("Enter first name: ");
                String firstName = sc.nextLine();

                System.out.println("Enter last name: ");
                String lastName = sc.nextLine();

                System.out.println("Enter address: ");
                String address = sc.nextLine();

                System.out.println("Enter city: ");
                String city = sc.nextLine();

                System.out.println("Enter state: ");
                String state = sc.nextLine();

                System.out.println("Enter zip: ");
                String zip = sc.nextLine();

                System.out.println("Enter phone number: ");
                String phoneNumber = sc.nextLine();

                System.out.println("Enter email: ");
                String email = sc.nextLine();

                Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                contacts.add(contact);
                System.out.println("Contact added.");
                System.out.println("Contact: " +
                        contact.getFirstName() +" "+
                        contact.getLastName() +" "+
                        contact.getCity() +" "+
                        contact.getPhoneNumber() +" "+
                        contact.getState() +" "+
                        contact.getEmail() +" "+
                        contact.getZip() +" "+
                        contact.getAddress());

            }
            else if (cm.equals("quit")) {
                running = false;
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Invalid command.");
            }
        }

        sc.close();
    }
}

class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}

