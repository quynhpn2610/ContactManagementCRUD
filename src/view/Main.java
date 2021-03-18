package view;

import entity.Contact;
import service.ContactService;

import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ContactService contactService = new ContactService();

    static void showMenu(){
        System.out.println("Welcome to the Contact Service app!");
        System.out.println("1 - Add new contact info");
        System.out.println("2 - Search for contact info");
        System.out.println("3 - Update contact info");
        System.out.println("4 - Delete contact info");
        System.out.println("5 - Show all contact info");
        System.out.println("6 - Quit");
    }

    public static void main(String[] args) {
        boolean condition = true;
        while (condition){
            showMenu();
            int userInput = Integer.parseInt(sc.nextLine());
            switch (userInput){
                case 1: // Add new contact info
                    System.out.println("---Add new contact info---");

                    System.out.println("Enter id: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.println("Enter name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter address: ");
                    String address = sc.nextLine();

                    System.out.println("Enter phone number: ");
                    String phoneNumber = sc.nextLine();

                    Contact contactToAdd = new Contact(id, name, phoneNumber, address);

                    contactService.addContact(contactToAdd);

                    break;
                case 2: // Search for a contact // git add .
                    System.out.println("---Search for contact info---");
                    System.out.println("Enter id: ");
                    int idToSearch = Integer.parseInt(sc.nextLine());
                    contactService.searchContact(idToSearch);
                    break;
                case 3: // Update contact info
                    System.out.println("---Update contact info---");
                    System.out.println("Enter id: ");
                    int idToUpdate = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter new name: ");
                    String nameToUpdate = sc.nextLine();
                    System.out.println("Enter new address: ");
                    String addressToUpdate = sc.nextLine();
                    System.out.println("Enter new phone number");
                    String phoneNumberToUpdate = sc.nextLine();
                    contactService.updateContact(idToUpdate, nameToUpdate, addressToUpdate, phoneNumberToUpdate);
                    break;
                case 4: // Delete contact info
                    System.out.println("---Delete contact info---");
                    System.out.println("Enter id: ");
                    int idToDelete = Integer.parseInt(sc.nextLine());
                    contactService.deleteContact(idToDelete);
                    break;
                case 5: //Show all contacts
                    System.out.println("---Show all contact info---");
                    contactService.showAll();
                    break;

                case 6: // Quit
                    System.out.println("Program closing. Bye!");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number from 1 to 6.");

            }
        }
    sc.close();
    }
}
