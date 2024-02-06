public class Contact {

    private String contactName;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String aContactName, String aPhoneNumber, String anEmailAddress) {
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
}
