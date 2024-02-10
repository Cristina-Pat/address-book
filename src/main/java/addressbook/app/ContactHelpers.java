package addressbook.app;

public class ContactHelpers {
    public static String formatContact(Contact contact) {
        return String.format("Name: %s"+ System.lineSeparator() +"Phone Number: %s"+
                        System.lineSeparator() +"Email Address: %s"+ System.lineSeparator(),
                contact.getContactName(), contact.getPhoneNumber(), contact.getEmailAddress());
    }


}
