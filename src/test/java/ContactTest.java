import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

    @Test
    void testContactNameSetByConstructor(){
        // Arrange
        String testContactName = "Test Contact Name";
        Contact testContact = new Contact(testContactName, "12345678",
                "testContact@gmail.com");
        // Act
        String actualContactName = testContact.getContactName();
        // Assert
        assertEquals(testContactName, actualContactName);
    }
}
