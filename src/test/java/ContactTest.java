import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
            String testPhoneNumber = "07894561231"; // remember to transform the user input(long) into a String
            String testEmail = "john.doe@gmail.com";

            // Act
            Contact testContact = new Contact(testContactName, testPhoneNumber, testEmail);

            //Assert
            assertAll("Constructor sets values when valid",
                    () -> assertEquals(testContactName, testContact.getContactName()),
                    () -> assertEquals(testPhoneNumber, testContact.getPhoneNumber()),
                    () -> assertEquals(testEmail, testContact.getEmailAddress()));
        }

        @Nested
        @DisplayName("Name tests using Contact")
        class ContactNameTest {
            @Test
            @DisplayName("Constructor throws exception when the name is null")
            public void testConstructorThrowsExceptionWhenNameIsNull(){
                // Arrange
                String testContactName = null;
                String testPhoneNumber = "07894561231";
                String testEmail = "john.doe@gmail.com";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testContactName, testPhoneNumber, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws exception when the name is empty string")
            public void testConstructorThrowsExceptionWhenNameIsEmptyString(){
                // Arrange
                String testContactName = "";
                String testPhoneNumber = "07894561231";
                String testEmail = "john.doe@gmail.com";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testContactName, testPhoneNumber, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws exception when the name is whitespace")
            public void testConstructorThrowsExceptionWhenNameIsWhitespace(){
                // Arrange
                String testContactName = " ";
                String testPhoneNumber = "07894561231";
                String testEmail = "john.doe@gmail.com";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testContactName, testPhoneNumber, testEmail);
                });
            }

            @Test
            @DisplayName("Constructor throws exception when the name does not meet pattern")
            public void testConstructorThrowsExceptionWhenNameDoesNotMeetPattern(){
                // Arrange
                String testContactName = "Ar";
                String testPhoneNumber = "07894561231";
                String testEmail = "john.doe@gmail.com";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testContactName, testPhoneNumber, testEmail);
                });
            }
        }

        @Nested
        @DisplayName("Phone Number Test")
        class PhoneNumberTest {
            @Test
            @DisplayName("Construct throws exception when phone number is less the 11 characters")
            public void testConstructorThrowsExceptionWhenPhoneNumberIsLessThan11() {
                // Arrange
                String testContactName = "John Doe";
                String testPhoneNumber = "07894561";
                String testEmail = "john.doe@gmail.com";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testContactName, testPhoneNumber, testEmail);
                });
            }

            @Test
            @DisplayName("Construct throws exception when phone number is more the 11 characters")
            public void testConstructorThrowsExceptionWhenPhoneNumberIsMoreThan11() {
                // Arrange
                String testContactName = "John Doe";
                String testPhoneNumber = "07894561465578";
                String testEmail = "john.doe@gmail.com";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testContactName, testPhoneNumber, testEmail);
                });
            }
        }

        @Nested
        @DisplayName("Email Address Test")
        class EmailAddressTest {
            @Test
            @DisplayName("Construct throws exception when email address does not meet pattern")
            public void testConstructorThrowsExceptionWhenEmailAddressDoesNotMeetPattern() {
                // Arrange
                String testContactName = "John Doe";
                String testPhoneNumber = "07894561461";
                String testEmail = "john.doe@gmail.com";
                // Act
                // Assert
                assertThrows(IllegalArgumentException.class, () -> {
                    new Contact(testContactName, testPhoneNumber, testEmail);
                });
            }
        }
    }
}

