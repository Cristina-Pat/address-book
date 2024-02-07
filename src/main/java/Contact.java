public class Contact {

    private String contactName;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String aContactName, String aPhoneNumber, String anEmailAddress) {
        validateContactName(aContactName);
        validatePhoneNumber(aPhoneNumber);
        this.contactName = aContactName;
        this.phoneNumber = aPhoneNumber;
        this.emailAddress = anEmailAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    private static void validateContactName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Contact name cannot be null or empty");
        }
        /* the name starts with a letter and contains at least 3 letters, allowing for spaces between
        names in the format first-last
         */
        if(!name.trim().matches("^[a-zA-Z]+( [a-zA-Z]+){1,}$")){
            throw new IllegalArgumentException("Name must start with a letter and contain at least 3 letters");
        }
    }

    private static void validatePhoneNumber(String phoneNumber){

    }
}

