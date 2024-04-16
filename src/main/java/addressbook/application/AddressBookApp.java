package addressbook.application;
import addressbook.app.*;

import java.util.Scanner;

public class AddressBookApp {
    public static void main(String[] args) {
        // Create an instance of the AddressBook
         AddressBook addressBook = new AddressBook();

        // Add some contacts to the address book
        try {
            addressBook.addContact(new Contact("John Doe", "07598254745", "john@example.com"));
            addressBook.addContact(new Contact("Eva Longoria", "07598251234", "eva@example.com"));
            addressBook.addContact(new Contact("Mary Lin", "07298258549", "mary@example.co.uk"));
        } catch (DuplicatePhoneNumberException | DuplicateEmailAddressException e) {
            System.out.println("Error adding contact: " + e.getMessage());
        }

        // View all contacts in the address book
        addressBook.viewAllContacts();
        System.out.println("=============================");

        // Search for a contact by name (assuming searchContact method is implemented)
        String searchName = "John Doe";
        Contact foundContact = addressBook.searchContact(searchName);
        if (foundContact != null) {
            System.out.println("Found contact: " + foundContact.getContactName());
            System.out.println("Phone Number: " + foundContact.getPhoneNumber());
            System.out.println("Email Address: " + foundContact.getEmailAddress());
        } else {
            System.out.println("Contact not found with name: " + searchName);
        }
        System.out.println("=============================");

        // Remove a contact from the address book
        String contactToRemove = "Mary Lin";
        addressBook.removeContact(contactToRemove);
        System.out.println("Contact removed: " + contactToRemove);
        System.out.println("=============================");

        // View all contacts again after removal
        addressBook.viewAllContacts();
        System.out.println("=============================");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book Application");
            System.out.println("1. Add contact");
            System.out.println("2. Search contact by name");
            System.out.println("3. Search contact by phone number");
            System.out.println("4. Remove contact");
            System.out.println("5. View all contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    if (addContact(addressBook, scanner)) {
                        continue;
                    }
                    break;
                case 2:
                    searchContactByName(addressBook, scanner);
                    break;
                case 3:
                    searchContactByPhone(addressBook, scanner);
                    break;
                case 4:
                    removeContact(addressBook, scanner);
                    break;
                case 5:
                    viewAllContacts(addressBook);
                    break;
                case 6:
                    System.out.println("Exiting Address Book Application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static boolean addContact(AddressBook addressBook, Scanner scanner) {
        boolean isValidContactAdded = false;
        do {
            try {
                System.out.print("Enter contact name: ");
                String name = scanner.nextLine();

                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();

                System.out.print("Enter email address: ");
                String emailAddress = scanner.nextLine();

                // Check if contact details are valid
                addressBook.addContact(new Contact(name, phoneNumber, emailAddress));
                System.out.println("Contact added successfully.");
                isValidContactAdded = true;

            } catch (Exception e) {
                System.out.println("Error adding contact: " + e.getMessage());
            }
        } while(!isValidContactAdded);

        return true;
    }

    private static void searchContactByName(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter contact name to search: ");
        String searchName = scanner.nextLine();
        Contact foundContact = addressBook.searchContact(searchName);
        if (foundContact != null) {
            System.out.println("Contact found:");
            System.out.println("Name: " + foundContact.getContactName());
            System.out.println("Phone Number: " + foundContact.getPhoneNumber());
            System.out.println("Email Address: " + foundContact.getEmailAddress());
        } else {
            System.out.println("Contact not found with name: " + searchName);
        }
    }

    private static void searchContactByPhone(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter phone number to search: ");
        String searchPhoneNumber = scanner.nextLine();
        Contact foundContact = addressBook.searchContactByPhoneNumber(searchPhoneNumber);
        if (foundContact != null) {
            System.out.println("Contact found:");
            System.out.println("Name: " + foundContact.getContactName());
            System.out.println("Phone Number: " + foundContact.getPhoneNumber());
            System.out.println("Email Address: " + foundContact.getEmailAddress());
        } else {
            System.out.println("Contact not found with phone number: " + searchPhoneNumber);
        }
    }

    private static void removeContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter contact name to remove: ");
        String removeName = scanner.nextLine();
        addressBook.removeContact(removeName);
        System.out.println("Contact removed successfully.");
    }

    private static void viewAllContacts(AddressBook addressBook) {
        System.out.println("All contacts:");
        addressBook.viewAllContacts();
    }
}
