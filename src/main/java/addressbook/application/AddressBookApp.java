package addressbook.application;
import addressbook.app.*;


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
        

    }
}
