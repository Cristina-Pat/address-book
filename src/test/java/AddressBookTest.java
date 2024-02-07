import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}
