package Bai8_PhoneNumberManagement;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        int choice;
    do{
        System.out.println("PHONEBOOK MANAGEMENT SYSTEM");
        System.out.println("1.Insert Phone");
        System.out.println("2. Remove Phone");
        System.out.println("3. Update Phone");
        System.out.println("4. Search Phone");
        System.out.println("5. Sort");
        System.out.println("6. Exit");
        choice = sc.nextInt();
        sc.nextLine();
    switch(choice){
        case 1:
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter phone: ");
        String phone = sc.nextLine();
        phoneBook.insertPhone(name, phone);
        break;

        case 2:
        System.out.println("Enter name to remove: ");
        name = sc.nextLine();
        phoneBook.removePhone(phone);

        case 3:
        System.out.println("Enter name to update: ");
        name = sc.nextLine();
        System.out.println("Enter new phone: ");
        String newphone = sc.nextLine();
        phoneBook.updatePhone(name, newphone);
        break;

        case 4:
        System.out.println("Enter name to search: ");
        name = sc.nextLine();
        phoneBook.updatePhone(name, newphone);
        break;

        case 5:
        phoneBook.sort();
        System.out.println("Phone sorted by name.");
        break;

        case 6:
        System.out.println("Exiting...");
        break;
        default:
        System.out.println("Invalid choice. Try again");
    }
}
    while(choice!=6);
    sc.close();
    }
}

