package ui;

import java.util.Scanner;
import dao.AccountantDAO;
import model.Accountant;
import java.util.List;

public class AdminPanel {
    public static void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("\n===== Admin Panel =====");
            System.out.println("1. Add Accountant");
            System.out.println("2. View Accountants");
            System.out.println("3. Edit Accountant");
            System.out.println("4. Delete Accountant");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    addAccountant(sc);
                    break;
                case 2:
                    viewAccountants();
                    break;
                case 3:
                    editAccountant(sc);
                    break;
                case 4:
                    deleteAccountant(sc);
                    break;
                case 5:
                    System.out.println(" Logging out...");
                    return; 
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

   
    private static void addAccountant(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Accountant acc = new Accountant(0, name, email, phone, password);
        int status = AccountantDAO.save(acc);

        if (status > 0) {
            System.out.println("Accountant added successfully!");
        } else {
            System.out.println("Failed to add accountant!");
        }
    }

    
    private static void viewAccountants() {
        List<Accountant> list = AccountantDAO.getAllAccountants();
        if (list.isEmpty()) {
            System.out.println("No accountants found.");
        } else {
            for (Accountant acc : list) {
                System.out.println(acc);
            }
        }
    }

  
    private static void editAccountant(Scanner sc) {
        System.out.print("Enter Accountant ID to Edit: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Email: ");
        String email = sc.nextLine();
        System.out.print("Enter New Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter New Password: ");
        String password = sc.nextLine();

        Accountant acc = new Accountant(id, name, email, phone, password);
        int status = AccountantDAO.update(acc);

        if (status > 0) {
            System.out.println("Accountant updated successfully!");
        } else {
            System.out.println("Accountant update failed!");
        }
    }

   
    private static void deleteAccountant(Scanner sc) {
        System.out.print("Enter Accountant ID to Delete: ");
        int id = sc.nextInt();

        int status = AccountantDAO.delete(id);
        if (status > 0) {
            System.out.println("Accountant deleted successfully!");
        } else {
            System.out.println("Accountant deletion failed!");
        }
    }
}
