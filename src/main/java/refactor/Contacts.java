package refactor;
import java.util.*;
public class Contacts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Function function = new Function();

        int choice;
        do {
            System.out.println("1. Add contact");
            System.out.println("2. Display contacts");
            System.out.println("3. Search by city");
            System.out.println("4. Deleting Contact");
            System.out.println("5. Search by State");
            System.out.println("6. Total in city");
            System.out.println("7. Total in State")

            switch (choice) {
                case 1:
                    System.out.println("Enter first name:");
                    String firstName = sc.next();
                    System.out.println("Enter last name:");
                    String lastName = sc.next();
                    System.out.println("Enter address:");
                    String address = sc.next();
                    System.out.println("Enter city:");
                    String city = sc.next();
                    System.out.println("Enter state:");
                    String state = sc.next();
                    System.out.println("Enter zip code:");
                    int zipCode = sc.nextInt();
                    System.out.println("Enter phone number:");
                    long phoneNumber = sc.nextLong();
                    System.out.println("Enter email:");
                    String email = sc.next();
                    Address_Book_Main addressBook = new Address_Book_Main(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
                    function.addContact(addressBook);
                    break;
                case 2:
                    function.displayContacts();
                    break;
                case 3:
                    System.out.println("Enter city to search:");
                    String searchCity = sc.next();
                    function.searchByCity(searchCity);
                    break;
                case 4:
                    System.out.println("Enter the First Name");
                    String remove = sc.next();
                    function.deleteContact(remove);
                    break;
                case 5:
                    System.out.println("Enter State to Search");
                    String searchState = sc.next();
                    function.searchByState(searchState);
                case 6:
                    function.countCity();
                    break;
                case 7:
                    function.countState();
                    break;
                case 8:
                    System.out.println("Enter field to sort by (City/State/Zip):");
                    String field = sc.next();
                    function.sortContacts(field);
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        sc.close();
    }
}