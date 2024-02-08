import java.util.HashMap;
import java.util.HashSet;

public class AddressBook {
    private HashMap<String, Contact> contacts;
    private HashSet<String> phoneNumberSet;
    private HashSet<String> emailAddressSet;


    public AddressBook() {

        this.contacts = new HashMap<String, Contact>();
        this.phoneNumberSet = new HashSet<String>();
        this.emailAddressSet = new HashSet<String>();
    }

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

    public Boolean containsContact(String contactName) {
        return this.contacts.get(contactName) != null;
    }

    public Contact searchContact(String contactName) {
        return this.contacts.get(contactName);
    }

    public void removeContact(String contactName) {
        contacts.remove(contactName);
    }

    public void editContactName(String oldName, String newName) {
        Contact c = this.searchContact(oldName);
        c.setContactName(newName);
        this.contacts.remove(oldName);
        this.contacts.put(newName, c);
    }

    public void editPhoneNumber(String contactName, String newPhoneNumber) {
        Contact c = this.searchContact(contactName);
        c.setPhoneNumber(newPhoneNumber);
    }

    public void editEmailAddress(String contactName, String newEmail) {
        Contact c = this.searchContact(contactName);
        c.setEmailAddress(newEmail);
    }
}
