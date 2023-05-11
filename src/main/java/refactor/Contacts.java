package refactor;
import java.util.*;
public class Contacts
{
    private Map<String,Address_Book_Main> addressBookMainMap = new HashMap<>();
    public void addContact(Address_Book_Main contact) {
        String firstName = contact.getFirstName();
        String lastName = contact.getLastName();
        String email = contact.getEmailId();
        ArrayList<Address_Book_Main> contacts = new ArrayList<>();

        if (addressBookMainMap.containsKey(firstName))
        {
            System.out.println("Contact is Already Exists!" + "\n" + "It's Not Add in Contacts!");
                }
            else {
                contacts.add(contact);
            addressBookMainMap.put(firstName, contact);
            System.out.println("Contact Added Successfully");
        }
    }

    public void displayContacts() {
        if (addressBookMainMap.isEmpty()) {
            System.out.println("No contacts found!");
        } else {
            for (Address_Book_Main contact : addressBookMainMap.values()) {
                System.out.println(contact);
            }
        }
    }

    public Address_Book_Main search(String firstName) {
        if (addressBookMainMap.containsKey(firstName)){
            return addressBookMainMap.get(firstName);
        }
        return null;
    }

    public void deleteContact(String firstName)
    {
        addressBookMainMap.remove(firstName);
        System.out.println("Contact deleted successfully!");
    }

    public static void main(String[] args) {
        Contacts contact = new Contacts();
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

                contact.addContact(new Address_Book_Main(firstName, lastName, address, city, state, zipcode, phonenum, emailid));
            } else if (ch == 2) {
                contact.displayContacts();
            } else if (ch == 3) {
                System.out.println("Enter First Name: ");
                String firstName = sc.next();
                ArrayList<Address_Book_Main> contact2 = contact.search(firstName);
                if (contact == null) {
                    System.out.println("Contact not found!");
                } else {
                    System.out.println(contact2);
                }
            } else if (ch == 4) {
                System.out.println("Enter First Name: ");
                String firstName = sc.next();
                if (contact == null) {
                    System.out.println("Contact not found!");
                } else {
                    contact.deleteContact(firstName);
                }
            }
        } while (ch != 0);

        sc.close();
    }
}

