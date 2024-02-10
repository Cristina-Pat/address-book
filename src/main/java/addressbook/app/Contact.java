package addressbook.app;

public class Contact {
    /**
     * Represents a contact with a name, phone number, and email address.
     */

    private String contactName;
    private String phoneNumber;
    private String emailAddress;

    /**
     * Constructs a new Contact with the specified name, phone number, and email address.
     * The parameters are validated before being added.
     *
     * @param aContactName  the name of the contact
     * @param aPhoneNumber  the phone number of the contact
     * @param anEmailAddress the email address of the contact
     */
    public Contact(String aContactName, String aPhoneNumber, String anEmailAddress) {
        validateContactName(aContactName);
        validatePhoneNumber(aPhoneNumber);
        validateEmailAddress(anEmailAddress);
        this.contactName = aContactName;
        this.phoneNumber = aPhoneNumber;
        this.emailAddress = anEmailAddress;
    }
    /**
     * Retrieves the contact's name.
     *
     * @return The contact's name.
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the contact's name.
     *
     * @param contactName The new name for the contact.
     * @throws IllegalArgumentException If the provided name is null, empty, or does not match the required format.
     */
    public void setContactName(String contactName) {
        validateContactName(contactName);
        this.contactName = contactName;
    }

    /**
     * Retrieves the contact's phone number.
     *
     * @return The contact's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the contact's phone number.
     *
     * @param phoneNumber The new phone number for the contact.
     * @throws IllegalArgumentException If the provided phone number does not match the required format.
     */
    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Retrieves the contact's email address.
     *
     * @return The contact's email address.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the contact's email address.
     *
     * @param emailAddress The new email address for the contact.
     * @throws IllegalArgumentException If the provided email address does not match the required format.
     */
    public void setEmailAddress(String emailAddress) {
        validateEmailAddress(emailAddress);
        this.emailAddress = emailAddress;
    }

    /**
     * Validates the provided contact name.
     *
     * @param name The name to be validated.
     * @throws IllegalArgumentException If the provided name is null, empty, or does not match the required format.
     */
    private static void validateContactName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Contact name cannot be null or empty");
        }

        if(!name.trim().matches("^[a-zA-Z]+( [a-zA-Z]+){1,}$")){
            throw new IllegalArgumentException("Name must start with a letter and contains at least 3 letters, " +
                    "allowing for spaces between names in the format first-last");
        }
    }


    /**
     * Validates the provided phone number.
     *
     * @param phoneNumber The phone number to be validated.
     * @throws IllegalArgumentException If the provided phone number does not match the required format.
     */
    private static void validatePhoneNumber(String phoneNumber){
        if(!phoneNumber.trim().matches("^07[2-9][0-9]{8}$")){
            throw new IllegalArgumentException("The phone number must start with 07, followed by a digit from " +
                    "2 to 9 and contain a total of 11 digits");}
    }

    /**
     * Validates the provided email address.
     *
     * @param emailAddress The email address to be validated.
     * @throws IllegalArgumentException If the provided email address does not match the required format.
     */
    private static void validateEmailAddress(String emailAddress){
        if(!emailAddress.trim().matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z-.]{2,5}$")){
            throw new IllegalArgumentException("The email address should contain an @ symbol and " +
                    "end with the domain name (such as gmail) followed by the top-level domain (such as .com)");}
    }
}

