import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {


    @Test
    @DisplayName("When a contact is added to the address book, the contacts list contains that contact's details")
    public void testContactAdded() throws Exception {
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
    public void testContactSearch() throws Exception {
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
    public void testContactRemove() throws Exception {
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
    public void testEditContactName() throws Exception {
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
    public void testEditPhoneNumber() throws Exception {
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
    public void testEditEmail() throws Exception {
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

    @Nested
    @DisplayName("Adding Contact with Duplicate Phone Numbers and Emails Test")
    class AddWithDuplicateTests {
        @Test
        @DisplayName("Adding a contact with an already existing phone number throws an error")
        void testAddContactWithDuplicatePhoneNumber() throws Exception {
            // Arrange
            Contact johnDoe = new Contact("John Doe", "07894561231",
                    "john.doe@hello.co.uk");

            AddressBook addressBook = new AddressBook();
            addressBook.addContact(johnDoe);

            // Act
            Contact evaLongoria = new Contact("Eva Longoria", "07894561231",
                    "eva.longoria@gmail.com");

            // Assert
            assertThrows(DuplicatePhoneNumberException.class, () -> {
                addressBook.addContact(evaLongoria);
            });

        }

        @Test
        @DisplayName("Adding a contact with an already existing email address throws an error")
        void testAddContactWithDuplicateEmailAddress() throws Exception {
            // Arrange
            Contact johnDoe = new Contact("John Doe", "07894561231",
                    "john.doe@hello.co.uk");

            AddressBook addressBook = new AddressBook();
            addressBook.addContact(johnDoe);

            // Act
            Contact evaLongoria = new Contact("Eva Longoria", "07894561242",
                    "john.doe@hello.co.uk");

            // Assert
            assertThrows(DuplicateEmailAddressException.class, () -> {
                addressBook.addContact(evaLongoria);
            });
        }
    }

    @Nested
    @DisplayName("Updating Contact with Duplicate Phone Numbers and Emails Test")
    class UpdateWithDuplicateTests {
        @Test
        @DisplayName("Updating a contact with an already existing phone number throws an error")
        void testUpdateContactWithDuplicatePhoneNumber() throws Exception{
            // Arrange
            Contact johnDoe = new Contact("John Doe", "07894561231",
                    "john.doe@hello.co.uk");

            AddressBook addressBook = new AddressBook();
            addressBook.addContact(johnDoe);

            // Act
            Contact evaLongoria = new Contact("Eva Longoria", "07894561425",
                    "eva.longoria@gmail.com");
            addressBook.addContact(evaLongoria);

            // Assert
            assertThrows(DuplicatePhoneNumberException.class, () -> {
                addressBook.editPhoneNumber("Eva Longoria", "07894561231");
            });
        }

        @Test
        @DisplayName("Updating a contact with an already existing email address throws an error")
        void testUpdateContactWithDuplicateEmailAddress() throws Exception {
            // Arrange
            Contact johnDoe = new Contact("John Doe", "07894561231",
                    "john.doe@hello.co.uk");

            AddressBook addressBook = new AddressBook();
            addressBook.addContact(johnDoe);

            // Act
            Contact evaLongoria = new Contact("Eva Longoria", "07894561425",
                    "eva.longoria@gmail.com");
            addressBook.addContact(evaLongoria);

            // Assert
            assertThrows(DuplicateEmailAddressException.class, () -> {
                addressBook.editEmailAddress("Eva Longoria", "john.doe@hello.co.uk");
            });
        }
    }
}
