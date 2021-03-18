package service;

import entity.Contact;

public interface IContactService {
    // Create or Add
    void addContact(Contact contact);

    // Read or Search
    void searchContact(int id);

    // Update
    void updateContact(int id, String newName, String newAddress, String newPhoneNumber);

    // Delete
    void deleteContact(int id);

    // Read all or Show all contacts
    void showAll();

}
