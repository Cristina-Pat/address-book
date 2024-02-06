import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

//    @Test
//    void testContactNameSetByConstructor(){
//        // Arrange
//        String testContactName = "Test Contact Name";
//        Contact testContact = new Contact(testContactName, "12345678",
//                "testContact@gmail.com");
//        // Act
//        String actualContactName = testContact.getContactName();
//        // Assert
//        assertEquals(testContactName, actualContactName);
//    }
    @Nested
    @DisplayName("Construct tests")
    class ConstructorTests{
        @Test
        @DisplayName("Contact construct sets expected values when valid")
        public void testConstructorSetsValuesWhenValid(){
            // Arrange
            String testContactName = "John Doe";
            String testPhoneNumber = "0789456123"; // remember to transform the user input(long) into a String
            String testEmail = "john.doe@gmail.com";

            // Act
            Contact testContact = new Contact(testContactName, testPhoneNumber, testEmail);

            //Assert
            assertAll("Constructor sets values when valid"),
                    () -> assertEquals(testContactName, testContact.getContactName()),
                    () -> assertEquals(testPhoneNumber, testContact.getPhoneNumber()),
                    () -> assertEquals(testEmail, testContact.getEmailAddress()));
        }
    }
}
