package refactor;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Function {
    private final Map<String, List<Address_Book_Main>> addressbookmainmap = new HashMap<>();
    Scanner sc = new Scanner(System.in);


    static Address_Book_Main getContactDetailsFromUser(Scanner scanner) {
        System.out.println("Enter first name:");
        String firstName = scanner.next();
        System.out.println("Enter last name:");
        String lastName = scanner.next();
        System.out.println("Enter address:");
        String address = scanner.next();
        System.out.println("Enter city:");
        String city = scanner.next();
        System.out.println("Enter state:");
        String state = scanner.next();
        System.out.println("Enter zip code:");
        int zipCode = scanner.nextInt();
        System.out.println("Enter phone number:");
        long phoneNumber = scanner.nextLong();
        System.out.println("Enter email:");
        String email = scanner.next();
        return new Address_Book_Main(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
    }

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

        writeContactToFile(contact);

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


    public void searchByState(String state) {
        List<Address_Book_Main> contacts = addressbookmainmap.get(state);
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("No contacts found in " + state);
        } else {
            System.out.println("Contacts in " +state + ":");
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
    public void countCity(){
        System.out.println("Enter City Name:");
        String city = sc.next();
        long count = addressbookmainmap.values().stream()
                .flatMap(List::stream)
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .count();
        System.out.println("Number of Contact In " + city + " = " + count);
    }

    public void countState(){
        System.out.println("Enter the State Name:");
        String state = sc.next();
        long count = addressbookmainmap.values().stream().
                flatMap(List::stream)
                .filter(states -> states.getState().equalsIgnoreCase(state))
                .count();
        System.out.println("Number of Contact In " + state + " = " + count);
    }
    public void deleteContact(String remove)
    {
        addressbookmainmap.remove(remove);
        System.out.println("Contact deleted successfully!");
    }
    public void sortContacts(String field) {
        Comparator<Address_Book_Main> comparator;
        switch (field.trim().toLowerCase()) {
            case "city":
                comparator = Comparator.comparing(Address_Book_Main::getCity);
                break;
            case "state":
                comparator = Comparator.comparing(Address_Book_Main::getState);
                break;
            case "zip":
                comparator = Comparator.comparing(Address_Book_Main::getZipCode);
                break;
            default:
                System.out.println("Invalid field!");
                return;
        }

        List<Address_Book_Main> contacts = new ArrayList<>();
        for (List<Address_Book_Main> cityContacts : addressbookmainmap.values()) {
            contacts.addAll(cityContacts);
        }
        contacts.sort(comparator);

        System.out.println("Sorted by " + field + ":");
        contacts.forEach(System.out::println);
    }

    public void writeContactToFile(Address_Book_Main contact) {
        String fileName = "Address_Book.txt";
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            bufferedWriter.write(contact.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();
            System.out.println("Contact added and written to the file successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the file: " + e.getMessage());
        }
    }


    public void readFromFile() {
        String fileName = "Address_Book.txt";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file: " + e.getMessage());
        }
    }

}



