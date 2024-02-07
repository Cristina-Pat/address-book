import java.util.HashMap;

public class AddressBook {
    private HashMap<String, Contact> contacts;


    public AddressBook() {
        this.contacts = new HashMap<String, Contact>();
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getContactName(), contact);
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
