
public class AddressBookApp {
    public static void main(String[] args) {
        Contact contactJD = new Contact("John Doe", "0758941051",
                "john.doe@gmail.com");

        String formattedContact = String.format(" %s:%n phone number: %s %n " +
                "email: %s", contactJD.getContactName(), contactJD.getPhoneNumber(), contactJD.getEmailAddress());
        System.out.println(formattedContact);

    }
}
