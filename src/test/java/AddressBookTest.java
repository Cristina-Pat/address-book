import addressbook.app.AddressBook;
import addressbook.app.Contact;
import addressbook.app.DuplicateEmailAddressException;
import addressbook.app.DuplicatePhoneNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Supplier;

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
    @DisplayName("Adding addressbook.app.Contact with Duplicate Phone Numbers and Emails Test")
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
            assertThrows(DuplicatePhoneNumberException.class, () -> addressBook.addContact(evaLongoria));

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
            assertThrows(DuplicateEmailAddressException.class, () -> addressBook.addContact(evaLongoria));
        }
    }

    @Nested
    @DisplayName("Updating addressbook.app.Contact with Duplicate Phone Numbers and Emails Test")
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
            assertThrows(DuplicatePhoneNumberException.class, () -> addressBook.editPhoneNumber("Eva Longoria", "07894561231"));
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
            assertThrows(DuplicateEmailAddressException.class, () -> addressBook.editEmailAddress("Eva Longoria", "john.doe@hello.co.uk"));
        }
    }

    @Nested
    @DisplayName("View All Contacts")
    class ViewAllContactsTests {
        @Test
        @DisplayName("When viewing all contacts, a detailed overview is provided")
        void testDetailedAllContactsOverview() throws Exception {
            // Arrange
            Contact johnDoe = new Contact("John Doe", "07894561231",
                    "john.doe@hello.co.uk");

            AddressBook addressBook = new AddressBook();
            addressBook.addContact(johnDoe);

            PrintStream mockedPrintStream = mock(PrintStream.class);
            System.setOut(mockedPrintStream);

            // Act
            addressBook.viewAllContacts();

            // Assert
            verify(mockedPrintStream).println("All Contacts:");
            verify(mockedPrintStream).println(
                    "Name: John Doe\n" +
                    "Phone Number: 07894561231\n" +
                    "Email Address: john.doe@hello.co.uk\n");

            //Clear
            System.setOut(System.out);

        }

        @Test
        @DisplayName("When viewing all contacts, all contacts are displayed")
        void testViewAllContacts() throws Exception {
                // Arrange
                Contact johnDoe = mock(Contact.class);
                Contact evaLongoria= mock(Contact.class);

                // Mock contact details
                when(johnDoe.getContactName()).thenReturn("John Doe");
                when(johnDoe.getPhoneNumber()).thenReturn("07894561231");
                when(johnDoe.getEmailAddress()).thenReturn("john.doe@hello.co.uk");

                when(evaLongoria.getContactName()).thenReturn("Eva Longoria");
                when(evaLongoria.getPhoneNumber()).thenReturn("07894561425");
                when(evaLongoria.getEmailAddress()).thenReturn("eva.longoria@gmail.com");

                AddressBook addressBook = new AddressBook();
                addressBook.addContact(johnDoe);
                addressBook.addContact(evaLongoria);

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));


            String expectedOutput = "All Contacts:" + System.lineSeparator() +
                        "Name: John Doe" +System.lineSeparator() +
                        "Phone Number: 07894561231" + System.lineSeparator() +
                        "Email Address: john.doe@hello.co.uk" + System.lineSeparator() +System.lineSeparator() +
                        "Name: Eva Longoria" + System.lineSeparator() +
                        "Phone Number: 07894561425" + System.lineSeparator() +
                        "Email Address: eva.longoria@gmail.com"+ System.lineSeparator() +System.lineSeparator();

                // Act
                addressBook.viewAllContacts();

                // Assert
                 assertEquals(expectedOutput, outContent.toString());
        }

        @Test
        @DisplayName("When no contacts, notify the user")
        void testEmptyContacts() throws Exception {
            // Arrange
            AddressBook addressBook = new AddressBook();

            PrintStream mockedPrintStream = mock(PrintStream.class);
            System.setOut(mockedPrintStream);

            // Act
            addressBook.viewAllContacts();

            // Assert
            verify(mockedPrintStream).println("No contacts");

            //Clear
            System.setOut(System.out);

        }

    }

    @Nested
    @DisplayName("Search by Number")
    class SearchByNumber {
        @Test
        @DisplayName("When a phone number is provided, its contact's details are displayed")
        public void testSearchContactByPhoneNumber() throws Exception {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact johnDoe = new Contact("John Doe",
                    "07894561232", "john.doe@example.com");
            Contact evaLongoria = new Contact("Eva Longoria", "07259634825",
                    "eva.longoria@gmail.com");
            addressBook.addContact(johnDoe);
            addressBook.addContact(evaLongoria);

            // Act
            Contact foundContact = addressBook.searchContactByPhoneNumber("07259634825");

            // Assert
            assertEquals("Eva Longoria", foundContact.getContactName());
        }

        @Test
        @DisplayName("When an invalid phone number is provided, no contact is displayed")
        public void testSearchContactByInvalidPhoneNumber() throws Exception {
            // Arrange
            AddressBook addressBook = new AddressBook();

            Contact evaLongoria = new Contact("Eva Longoria", "07259634825",
                    "eva.longoria@gmail.com");
            addressBook.addContact(evaLongoria);

            // Act
            Contact foundContact = addressBook.searchContactByPhoneNumber("07891232");

            // Assert
            if (foundContact == null) System.out.println("No contact found for the provided phone number.");
        }
    }
}


