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

    }
}
