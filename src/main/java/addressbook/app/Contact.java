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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        validateContactName(contactName);
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        validateEmailAddress(emailAddress);
        this.emailAddress = emailAddress;
    }
    private static void validateContactName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Contact name cannot be null or empty");
        }

        if(!name.trim().matches("^[a-zA-Z]+( [a-zA-Z]+){1,}$")){
            throw new IllegalArgumentException("Name must start with a letter and contains at least 3 letters, " +
                    "allowing for spaces between names in the format first-last");
        }
    }

    private static void validatePhoneNumber(String phoneNumber){
        if(!phoneNumber.trim().matches("^07[2-9][0-9]{8}$")){
            throw new IllegalArgumentException("The phone number must start with 07, followed by a digit from " +
                    "2 to 9 and contain a total of 11 digits");}
    }

    private static void validateEmailAddress(String emailAddress){
        if(!emailAddress.trim().matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z-.]{2,5}$")){
            throw new IllegalArgumentException("The email address should contain an @ symbol and " +
                    "end with the domain name (such as gmail) followed by the top-level domain (such as .com)");}
    }
}
