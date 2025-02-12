package ui;

import java.util.Scanner;
import service.AdminService;
import service.AccountantService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Welcome to Fee Report System =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Accountant Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    adminLogin(sc);
                    break;
                case 2:
                    accountantLogin(sc);
                    break;
                case 3:
                    System.out.println(" Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println(" Invalid choice! Please enter a valid option.");
            }
        }
    }

   
    private static void adminLogin(Scanner sc) {
        System.out.print("Enter Admin Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = sc.nextLine();

        if (AdminService.login(username, password)) {
            System.out.println(" Admin Login successful!");
            AdminPanel.adminMenu(sc); 
        } else {
            System.out.println(" Invalid Admin credentials! Try again.");
        }
    }

   
    private static void accountantLogin(Scanner sc) {
        System.out.print("Enter Accountant Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Accountant Password: ");
        String password = sc.nextLine();

        if (AccountantService.login(email, password)) {
            System.out.println(" Accountant Login successful!");
            AccountantPanel.accountantMenu(sc); 
        } else {
            System.out.println(" Invalid Accountant credentials! Try again.");
        }
    }
}
