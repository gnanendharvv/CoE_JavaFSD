import java.util.*;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Welcome to the Warehouse Inventory Management System ===");
            System.out.println("1. Register a New Product");
            System.out.println("2. Create a New Order");
            System.out.println("3. Process All Pending Orders");
            System.out.println("4. Display Current Inventory");
            System.out.println("5. Save & Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProductFromUserInput(inventoryManager, scanner);
                    break;
                case 2:
                    placeOrderFromUserInput(inventoryManager, scanner);
                    break;
                case 3:
                    System.out.println("Processing all pending orders...");
                    inventoryManager.processOrders();
                    break;
                case 4:
                    System.out.println("Fetching inventory details...");
                    inventoryManager.viewInventory();
                    break;
                case 5:
                    inventoryManager.saveInventoryToFile();
                    inventoryManager.saveOrdersToFile();
                    System.out.println("All changes saved successfully. Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Oops! Invalid selection. Please try again.");
            }
        }
    }

    private static void addProductFromUserInput(InventoryManager inventoryManager, Scanner scanner) {
        System.out.println("\n--- Product Registration ---");
        System.out.print("Enter Product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Available Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Aisle Number: ");
        int aisle = scanner.nextInt();
        System.out.print("Enter Shelf Number: ");
        int shelf = scanner.nextInt();
        System.out.print("Enter Bin Number: ");
        int bin = scanner.nextInt();
        scanner.nextLine();

        Location location = new Location(aisle, shelf, bin);
        Product product = new Product(productID, name, quantity, location);
        inventoryManager.addProduct(product);
        System.out.println("Product successfully added to inventory!");
    }

    private static void placeOrderFromUserInput(InventoryManager inventoryManager, Scanner scanner) {
        System.out.println("\n--- Order Placement ---");
        System.out.print("Enter Order ID: ");
        String orderID = scanner.nextLine();
        System.out.print("Enter Product IDs (comma-separated): ");
        String productIDsInput = scanner.nextLine();
        List<String> productIDs = Arrays.asList(productIDsInput.split(","));
        System.out.print("Select Priority (1 for STANDARD, 2 for EXPEDITED): ");
        int priorityChoice = scanner.nextInt();
        scanner.nextLine();

        Order.Priority priority = (priorityChoice == 2) ? Order.Priority.EXPEDITED : Order.Priority.STANDARD;
        Order order = new Order(orderID, productIDs, priority);
        inventoryManager.addOrder(order);
        System.out.println("Order has been placed successfully!");
    }
}