package refactor;

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
    public void SortBook(){
        List<String> contacts = addressbookmainmap.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Address_Book_Main::getFirstName))
                .map(Address_Book_Main::getFirstName)
                .collect(Collectors.toList());
        contacts.stream().forEach(System.out::println);
    }

}


