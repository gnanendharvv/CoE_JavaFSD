
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
        LibraryManager libManager = new LibraryManager();
        Scanner sc = new Scanner(System.in);

        libManager.addBook(new Book("Book1", "Author1", "ISBN1"));
        libManager.addBook(new Book("Book2", "Author2", "ISBN2"));
        libManager.addBook(new Book("Book3", "Author3", "ISBN3"));
        
        libManager.addUser(new User("User1", "U1", new ArrayList<>()));
        libManager.addUser(new User("User2", "U2", new ArrayList<>()));

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Admin Login\n2. User Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            if (choice == 1) {
                while (true) {
                    System.out.println("Admin Menu:");
                    System.out.println("1. Add a Book\n2. Add a User\n3. View all the records\n4. Go Back");
                    int adminChoice = sc.nextInt();
                    sc.nextLine();
                    
                    if (adminChoice == 1) {
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = sc.nextLine();
                        libManager.addBook(new Book(title, author, isbn));
                    } else if (adminChoice == 2) {
                        System.out.print("Enter User Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter User ID: ");
                        String userID = sc.nextLine();
                        libManager.addUser(new User(name, userID, new ArrayList<>()));
                    } else if (adminChoice == 3) {
                        libManager.displayRecords();
                    } else if (adminChoice == 4) {
                        break;
                    }
                }
            } else if (choice == 2) {
                System.out.print("Enter User ID: ");
                String userID = sc.nextLine();
                User currentUser = null;
                
                for (User u : libManager.users) {
                    if (u.getUserID().equals(userID)) {
                        currentUser = u;
                        break;
                    }
                }
                
                if (currentUser == null) {
                    System.out.println("User not found!\n");
                    continue;
                }
                
                while (true) {
                    System.out.println("\nUser Menu:");
                    System.out.println("1. Borrow a Book\n2. Return a Book\n3. Search a Book\n4. View Borrowed Books\n5. Go Back");
                    int userChoice = sc.nextInt();
                    sc.nextLine();
                    
                    if (userChoice == 1) {
                        System.out.print("Enter Book ISBN: ");
                        String isbn = sc.nextLine();
                        try {
                            libManager.borrowBook(isbn, userID);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (userChoice == 2) {
                        System.out.print("Enter Book ISBN: ");
                        String isbn = sc.nextLine();
                        try {
                            libManager.returnBook(isbn, userID);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (userChoice == 3) {
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        Book book = libManager.searchBook(title);
                        System.out.println(book != null ? "Book found: " + book.getTitle()+"\nAuthor: "+book.getAuthor()+ "\nISBN: "+book.getISBN(): "Book not available");
                    } else if (userChoice == 4) {
                        System.out.print("Borrowed Books: " );
                    	currentUser.getBorrowedBooks().stream().forEach(p->System.out.print(p.getTitle()+" "));
                    } else if (userChoice == 5) {
                        break;
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting...\n");
                break;
            }
        }
        sc.close();
    }
}
