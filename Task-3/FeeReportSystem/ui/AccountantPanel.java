package ui;

import java.util.Scanner;

public class AccountantPanel {
    public static void accountantMenu(Scanner sc) {
        while (true) {
            System.out.println("\n===== Accountant Panel =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Check Due Fees");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    StudentOperations.addStudent(sc);
                    break;
                case 2:
                    StudentOperations.viewStudents();
                    break;
                case 3:
                    StudentOperations.editStudent(sc);
                    break;
                case 4:
                    StudentOperations.deleteStudent(sc);
                    break;
                case 5:
                    StudentOperations.checkDueFees();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
