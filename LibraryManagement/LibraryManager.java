
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibraryManager extends LibrarySystem {
    private Map<Book, Integer> bookStatus = new HashMap<>();

    public LibraryManager() {
        this.books = LibraryIO.loadBooks();
        this.users = LibraryIO.loadUsers();
        initializeBookStatus();
    }

    private void initializeBookStatus() {
        for (Book b : books) {
            bookStatus.put(b, 0); 
        }
    }

    @Override
    public void borrowBook(String ISBN, String userID)
            throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {

        for (User u : users) {
            if (u.getUserID().equals(userID)) { 
                if (u.getBorrowedBooks().size() > 2) throw new MaxBooksAllowedException();

                for (Book b : books) {
                    if (b.getISBN().equals(ISBN)) { 
                        if (bookStatus.get(b) == 0) {
                            u.setBorrowedBooks(b);
                            bookStatus.put(b, 1);
                            LibraryIO.saveUsers(users);
                            LibraryIO.saveBooks(books);
                            return;
                        } else if (bookStatus.get(b) == 1) {
                            System.out.println("Book is already rented. Do you wish to reserve it?\n1. Yes  2. No");
                            Scanner sc = new Scanner(System.in);
                            if (sc.nextInt() == 1) reserveBook(ISBN, userID);
                            sc.close();
                            return;
                        }
                    }
                }
                throw new BookNotFoundException();
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        for (User u : users) {
            if (u.getUserID().equals(userID)) {
                for (Book b : books) {
                    if (b.getISBN().equals(ISBN)) {
                        if ((bookStatus.get(b) == 1 || bookStatus.get(b) == 3) && u.getBorrowedBooks().contains(b)) {
                            u.getBorrowedBooks().remove(b);
                            bookStatus.put(b, (bookStatus.get(b) == 1) ? 0 : 1);
                            LibraryIO.saveUsers(users);
                            LibraryIO.saveBooks(books);
                            return;
                        } else if (bookStatus.get(b) == 0) {
                            System.out.println("Book is not rented yet");
                            return;
                        }
                    }
                }
                throw new BookNotFoundException();
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        for (User u : users) {
            if (u.getUserID().equals(userID)) {
                for (Book b : books) {
                    if (b.getISBN().equals(ISBN)) {
                        u.setBorrowedBooks(b);
                        bookStatus.put(b, 3);
                        LibraryIO.saveUsers(users);
                        LibraryIO.saveBooks(books);
                        return;
                    }
                }
                throw new BookNotFoundException();
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public Book searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found");
                return b;
            }
        }
        System.out.println("Book Not Found");
        return null;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        bookStatus.put(book, 0);
        LibraryIO.saveBooks(books);
        System.out.println("Book added Successfully");
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        LibraryIO.saveUsers(users);
        System.out.println("User added Successfully");
    }

    public void displayRecords() {
        for (Map.Entry<Book, Integer> hm : bookStatus.entrySet()) {
            System.out.println(hm.getKey().getTitle() + " " + hm.getValue());
        }
    }
}
