public class Contact {

    private String contactName;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String aContactName, String aPhoneNumber, String anEmailAddress) {
        validateContactName(aContactName);
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
        if(!name.trim().matches("^[a-zA-Z]{3,}")){
            throw new IllegalArgumentException("Name must start with a letter and contain at least 3 letters");
        }
    }
}

