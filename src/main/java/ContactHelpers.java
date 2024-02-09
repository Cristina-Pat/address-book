public class ContactHelpers {
    public static String formatContact(Contact contact) {
        return String.format("Name: %s\nPhone Number: %s\nEmail Address: %s\n",
                contact.getContactName(), contact.getPhoneNumber(), contact.getEmailAddress());
    }
}
