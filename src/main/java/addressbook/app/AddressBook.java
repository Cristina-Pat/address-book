package addressbook.app;
import java.util.*;

/**
 * Represents an address book that stores contacts. Users can add, edit, search for, and remove contacts.
 * The application prevents duplicates phone numbers and email address.
 */
public class AddressBook {
    // HashMap to store contacts with name as key and Contact object as value, preventing duplicate contacts
    private HashMap<String, Contact> contacts;
    // HashSet to store unique phone numbers, preventing duplicate phone numbers

    private HashSet<String> phoneNumberSet;
    // HashSet to store unique email addresses, preventing duplicate email addresses
    private HashSet<String> emailAddressSet;

    /**
     * Constructor to initialize an empty AddressBook.
     */
    public AddressBook() {

        this.contacts = new HashMap<String, Contact>();
        this.phoneNumberSet = new HashSet<String>();
        this.emailAddressSet = new HashSet<String>();
    }
    /**
     * Adds a contact to the address book.
     *
     * @param contact the contact to be added
     * @throws DuplicatePhoneNumberException if the contact's phone number already exists in the address book
     * @throws DuplicateEmailAddressException if the contact's email address already exists in the address book
     */
    public void addContact(Contact contact) throws DuplicatePhoneNumberException, DuplicateEmailAddressException {
        validateUniquePhoneNumber(contact);
        validateUniqueEmailAddress(contact);
        phoneNumberSet.add(contact.getPhoneNumber());
        emailAddressSet.add(contact.getEmailAddress());
        contacts.put(contact.getContactName(), contact);
    }

    private void validateUniquePhoneNumber(Contact contact) throws DuplicatePhoneNumberException {
        if (phoneNumberSet.contains(contact.getPhoneNumber())) {
            throw new DuplicatePhoneNumberException();
        }
    }

    private void validateUniqueEmailAddress(Contact contact) throws DuplicateEmailAddressException {
        if (emailAddressSet.contains(contact.getEmailAddress())) {
            throw new DuplicateEmailAddressException();
        }
    }

    /**
     * Checks if the address book contains a contact with the given name.
     *
     * @param contactName the name of the contact to search for
     * @return true if the address book contains the contact, otherwise false
     */
    public Boolean containsContact(String contactName) {
        return this.contacts.get(contactName) != null;
    }

    /**
     * Searches for a contact by name in the address book.
     *
     * @param contactName the name of the contact to search for
     * @return the contact object if found, otherwise null
     */
    public Contact searchContactByName(String contactName) {
        return this.contacts.get(contactName);
    }

    /**
     * Removes a contact from the address book.
     *
     * @param contactName the name of the contact to be removed
     */
    public void removeContact(String contactName) {
        contacts.remove(contactName);
    }

    /**
     * Edits the name of a contact in the address book.
     *
     * @param oldName the current name of the contact
     * @param newName the new name to be set for the contact
     */
    public void editContactName(String oldName, String newName) {
        Contact c = this.searchContactByName(oldName);
        c.setContactName(newName);
        this.contacts.remove(oldName);
        this.contacts.put(newName, c);
    }

    /**
     * Edits the phone number of a contact in the address book.
     *
     * @param contactName the name of the contact whose phone number is to be edited
     * @param newPhoneNumber the new phone number to be set for the contact
     * @throws DuplicatePhoneNumberException if the new phone number already exists in the address book
     */
    public void editPhoneNumber(String contactName, String newPhoneNumber) throws DuplicatePhoneNumberException {
        Contact c = this.searchContactByName(contactName);
        c.setPhoneNumber(newPhoneNumber);
        validateUniquePhoneNumber(contacts.get(contactName));
    }

    /**
     * Edits the email address of a contact in the address book.
     *
     * @param contactName the name of the contact whose email address is to be edited
     * @param newEmail the new email address to be set for the contact
     * @throws DuplicateEmailAddressException if the new email address already exists in the address book
     */
    public void editEmailAddress(String contactName, String newEmail) throws DuplicateEmailAddressException {
        Contact c = this.searchContactByName(contactName);
        c.setEmailAddress(newEmail);
        validateUniqueEmailAddress(contacts.get(contactName));
    }

    /**
     * View all contacts in the address book.
     * Prints each contact's details using ContactHelpers.formatContact().
     * If the contact list is empty, it prints "No contacts".
     */
    public void viewAllContacts() {
        if (isContactListEmpty()) System.out.println("No contacts");
        System.out.println("All Contacts:");
        for (HashMap.Entry<String, Contact> aContact : contacts.entrySet()) {
            Contact contact = aContact.getValue();
            String formattedContact = ContactHelpers.formatContact(contact);
            System.out.println(formattedContact);
        }
    }

    /**
     * Checks if the contact list is empty.
     *
     * @return true if the contact list is empty, otherwise false
     */
    private boolean isContactListEmpty() {
        return this.contacts.isEmpty();
    }


    /**
     * Searches for a contact by phone number in the address book.
     *
     * @param phoneNumber the phone number to search for
     * @return the contact object if found, or {@code null} if no contact with the provided phone number exists
     */
    public Contact searchContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts.values()) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    /**
     * Searches for a contact in the address book by the provided email address.
     *
     * @param emailAddress The email address to search for
     * @return The contact object if found, or null if no contact matches the provided email address
     */
    public Contact searchContactByEmailAddress(String emailAddress) {
        for (Contact contact : contacts.values()) {
            if (contact.getEmailAddress().equals(emailAddress)) {
                return contact;
            }
        }
        return null;
    }

    /**
     * Searches for contacts by name, phone number, or email address in the address book and displays them in alphabetical order.
     *
     * @param searchString the name, phone number, or email address to search for
     */
    public void searchContactsByStringAndDisplayInAlphabeticalOrder(String searchString) {
        List<Contact> foundContacts = new ArrayList<>();

        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            Contact contact = entry.getValue();
            if (contact.getContactName().contains(searchString) || contact.getPhoneNumber().contains(searchString) || contact.getEmailAddress().contains(searchString)) {
                foundContacts.add(contact);
            }
            //System.out.println(foundContacts.size());
        }

        Collections.sort(foundContacts, Comparator.comparing(Contact::getContactName));

        for (Contact contact : foundContacts) {
            String formattedContact = ContactHelpers.formatContact(contact);
            System.out.println(formattedContact);
        }
    }
}
