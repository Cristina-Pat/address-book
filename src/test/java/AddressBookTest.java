import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {


    @Test
    @DisplayName("When a contact is added to the address book, the contacts list contains that contact's details")
    public void testContactAdded() {
        // Arrange
        Contact johnDoe = new Contact("John Doe", "07894561231",
                "john.doe@hello.co.uk");
        AddressBook addressBook = new AddressBook();

        // Act
        addressBook.addContact(johnDoe);
        // Assert
        assertTrue(addressBook.containsContact("John Doe"));
    }

    @Test
    @DisplayName("When a name is provided, that contact's details are displayed")
    public void testContactSearch() {
        // Arrange
        Contact johnDoe = new Contact("John Doe", "07894561231",
                "john.doe@hello.co.uk");
        AddressBook addressBook = new AddressBook();
        addressBook.addContact(johnDoe);

        // Act
        Contact actualOutput = addressBook.searchContact("John Doe");
        // Assert
        assertEquals(johnDoe, actualOutput);
    }

    @Test
    @DisplayName("When a contact is removed from the list, it no longer appears in the contact list")
    public void testContactRemove() {
        // Arrange
        Contact johnDoe = new Contact("John Doe", "07894561231",
                "john.doe@hello.co.uk");
        Contact evaLongoria = new Contact("Eva Longoria", "07259634825",
                "eva.longoria@gmail.com");
        AddressBook addressBook = new AddressBook();
        addressBook.addContact(johnDoe);
        addressBook.addContact(evaLongoria);


        // Act
        addressBook.removeContact("Eva Longoria");
        // Assert
        assertFalse(addressBook.containsContact("Eva Longoria"));
    }

    @Test
    @DisplayName("When the contact's name is changed, it is displayed accordingly in the contact list")
    public void testEditContactName() {
        // Arrange
        Contact evaLongoria = new Contact("Eva Longoria", "07259634825",
                "eva.longoria@gmail.com");
        AddressBook addressBook = new AddressBook();
        addressBook.addContact(evaLongoria);
        String newName = "Ava Longoria";

        // Act
        addressBook.editContactName("Eva Longoria", newName);
        // Assert
        assertTrue(addressBook.containsContact(newName));
    }

    @Test
    @DisplayName("When the contact's phone number is changed, it is displayed accordingly in the contact list")
    public void testEditPhoneNumber() {
        // Arrange
        Contact evaLongoria = new Contact("Eva Longoria", "07259634825",
                "eva.longoria@gmail.com");
        AddressBook addressBook = new AddressBook();
        addressBook.addContact(evaLongoria);
        String newPhoneNumber = "07259634820";

        // Act
        addressBook.editPhoneNumber("Eva Longoria", newPhoneNumber);
        // Assert
        assertEquals(newPhoneNumber, addressBook.searchContact("Eva Longoria").getPhoneNumber());
    }

    @Test
    @DisplayName("When the contact's email is changed, it is displayed accordingly in the contact list")
    public void testEditEmail() {
        // Arrange
        Contact evaLongoria = new Contact("Eva Longoria", "07259634825",
                "eva.longoria@gmail.com");
        AddressBook addressBook = new AddressBook();
        addressBook.addContact(evaLongoria);
        String newEmail = "eva.longoria.2@gmail.com";

        // Act
        addressBook.editEmailAddress("Eva Longoria", newEmail);
        // Assert
        assertEquals(newEmail, addressBook.searchContact("Eva Longoria").getEmailAddress());
    }
}
