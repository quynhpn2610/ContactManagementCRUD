package service;

import entity.Contact;

import java.util.ArrayList;

public class ContactService implements IContactService{
    // Array List to hold the contacts
    ArrayList<Contact> myContact = new ArrayList<>();

    // Methods
    @Override // add
    public void addContact(Contact contact) {
        myContact.add(contact);
    }

    @Override // read or show
    public void searchContact(int id) {
        int count = 0;
        // in case the list is empty --> unable to search
        if (myContact.isEmpty()) {
            System.out.println("Empty list. Cannot find.");
            return; // this is to end the function
        }
        // else: myContact list is not empty
        for (int i = 0; i < myContact.size(); i++) {
            if (myContact.get(i).getId() == id) {
                System.out.println(myContact.get(i).toString());
                count++;
            }
        }
        // in case after searching there is no such id in the list
        if (count == 0) {
            System.out.println("Invalid id. Cannot find.");
        }
    }


    @Override // update
    public void updateContact(int id, String newName, String newAddress, String newPhoneNumber) {
        int count = 0;
        if (myContact.isEmpty()){
            System.out.println("Empty list. Cannot update");
            return;
        }

        for (int i = 0; i < myContact.size(); i++) {
            if (myContact.get(i).getId() == id){
                myContact.get(i).setName(newName);
                myContact.get(i).setAddress(newAddress);
                myContact.get(i).setPhoneNumber(newPhoneNumber);
                count ++;
            }
        }

        if (count == 0){
            System.out.println("Invalid id. Cannot update.");
        }
        else {
            System.out.println("Updated successfully");
        }
    }

    @Override //delete
    public void deleteContact(int id) {
        int count = 0;
        if(myContact.isEmpty()){
            System.out.println("Empty list. Cannot delete");
            return;
        }

        for (int i = 0; i < myContact.size(); i++) {
            if (myContact.get(i).getId() == id){
                myContact.remove(i);
                count ++;
            }
        }
        if (count == 0){
            System.out.println("Invalid id. Cannot delete.");
        }
        System.out.println("Successfully deleted.");
    }

    @Override //show all
    public void showAll() {
        if (myContact.isEmpty()){
            System.out.println("Sorry. There's nothing to show here!");
            return;
        }
        for (int i = 0; i < myContact.size(); i++) {
            System.out.println(myContact.get(i).toString());
        }
    }
    //

}
