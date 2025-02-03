import java.util.Scanner;

public class SafeDivision {
    public static void handleInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter a number: ");
                double number = scanner.nextDouble();
                
                if (number == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }

                double reciprocal = 1 / number;
                System.out.println("Reciprocal: " + reciprocal);
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numerical value.");
                scanner.next(); // Clear the invalid input
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        handleInput();
    }
}
