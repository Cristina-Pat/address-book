# Domain Models, Class Diagrams and Test Plan
## User Stories

### Core Features
**US1**\
As an Address Book app user, I want to be able to add a contact to the address book, so that I can maintain a record of 
the contacts, each containing a name, phone number and email address.

**US2**\
As an Address Book app user, I want to be able to search by a name, so that I can view the contact details associated 
with this name.

**US3**\
As an Address Book app user, I want to be able to remove a contact, so that I can maintain my record clean and updated.

**US4**\
As an Address Book app user, I want to be able to edit the contact's details, so that I can maintain my contact list
updated. 

**US5**\
As an Address Book app user,I want the application to prevent duplicated phone numbers or emails to ensure accuracy in
my contact list and avoid errors. (HasSet for unique emails and phone numbers???)

**US6**\
As an Address Book app user, I want to be able to view my all contacts, to have a comprehensive overview about my
contact list.

**US7**\
As an Address Book app user, I want to be able to interact with the system so that I can request information about my 
contact list.


## Class diagram
``` mermaid
classDiagram
  class AddressBook {
    %% these are the core features
    -contacts: HashMap<String, Contact> 
    -phoneNumberSet: UniquePhoneNumberSet
    -emailSet: UniqueEmailSet
    +addContact(contactName: String, phoneNumber: String, emailAddress: String): boolean
    +searchContactByName(contactName: String): Contact
    +removeContact(contactName: String): boolean
    +editContact(contactName: String, newPhoneNumber: String, newEmailAddress: String): boolean
    +viewAllContacts(): HashMap<String, Contact>
    %% these are the aditional features
    +searchContactByPhoneNumber(phoneNumber: String): Contact
    +searchContactByEmailAddress(emailAddress: String): Contact
    +removeAllContacts(): boolean
  }

  class Contact {
    -contactName: String
    -phoneNumber: String
    -emailAddress: String
    +Contact(contactname: String, phoneNumber: String, emailAddress: String)
    +getPhoneNumber(): String
    +getEmailAddress(): String
    +setPhoneNumber(phoneNumber: String): void
    +setEmailAddress(emailAddress: String): void
  }

  %% This class ensures that duplicate phone numbers are not allowed, as the HashSet contains unique elements
  class UniquePhoneNumberSet {
    -phoneNumbers: HashSet<String>
    +addPhoneNumber(phoneNumber: String): boolean
    +containsPhoneNumber(phoneNumber: String): boolean
    +removePhoneNumber(phoneNumber: String): boolean
  }
  %% This class ensures that emails are not allowed, as the HashSet contains unique elements
  class UniqueEmailSet {
    -emailAddresses: HashSet<String>
    +addEmailAddress(emailAddress: String): boolean
    +containsEmailAddress(emailAddress: String): boolean
    +removeEmailAddress(emailAddress: String): boolean
  }

  class AdressBookApp {
    +displayMessage(message: String): void
    +getUserInput(): String
    %% This is a part of the aditional features
    +getConfirmation(message: String): boolean
  }

  AddressBook --* Contact
  AddressBook --* UniquePhoneNumberSet
  AddressBook --* UniqueEmailSet
  AddressBook *-- AdressBookApp

