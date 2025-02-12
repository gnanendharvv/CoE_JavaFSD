package ui;

import java.util.List;
import java.util.Scanner;
import dao.StudentDAO;
import model.Student;

public class StudentOperations {
    
    public static void addStudent(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Total Fee: ");
        double fee = sc.nextDouble();
        System.out.print("Enter Amount Paid: ");
        double paid = sc.nextDouble();
        double due = fee - paid;
        sc.nextLine(); 
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        Student student = new Student(0, name, email, course, fee, paid, due, address, phone);
        int status = StudentDAO.save(student);

        if (status > 0) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student!");
        }
    }

    
    public static void viewStudents() {
        List<Student> list = StudentDAO.getAllStudents();
        if (list.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }

   
    public static void editStudent(Scanner sc) {
        System.out.print("Enter Student ID to Edit: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Email: ");
        String email = sc.nextLine();
        System.out.print("Enter New Course: ");
        String course = sc.nextLine();
        System.out.print("Enter New Fee: ");
        double fee = sc.nextDouble();
        System.out.print("Enter Amount Paid: ");
        double paid = sc.nextDouble();
        double due = fee - paid;
        sc.nextLine(); 
        System.out.print("Enter New Address: ");
        String address = sc.nextLine();
        System.out.print("Enter New Phone: ");
        String phone = sc.nextLine();

        Student student = new Student(id, name, email, course, fee, paid, due, address, phone);
        int status = StudentDAO.update(student);

        if (status > 0) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student update failed!");
        }
    }


    public static void deleteStudent(Scanner sc) {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        int status = StudentDAO.delete(id);

        if (status > 0) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student deletion failed!");
        }
    }

  
    public static void checkDueFees() {
        List<Student> list = StudentDAO.getDueFees();
        if (list.isEmpty()) {
            System.out.println("No due fees found.");
        } else {
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }
}
