import java.util.Scanner;

public class InventorySystem {
    Scanner scanner = new Scanner(System.in);
    private Inventory inventory = new Inventory();

    public void start() {

        boolean running = true;

        while (running) {
            System.out.println("1. Termék raktárba helyezése");
            System.out.println("2. Termék törlése a raktárból (vonalkód beolvasás)");
            System.out.println("2. Termék eladás a raktárból (vonalkód beolvasás)");
            System.out.println("3. Teljes készlet megtekintése");
            System.out.println("4. Keresés vonalkód alapján");
            System.out.print("5. Kilépés (mentés)");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleAddProduct();
                    break;
                case 2:
                    handleRemoveProduct();
                    break;
                case 3:
                    handleSellProduct();
                case 4:
                    inventory.listProducts();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void handleRemoveProduct() {
        System.out.print("Enter Product ID: ");
        int Id = scanner.nextInt();
        inventory.removeProductById(Id);
        System.out.println("Product Removed successfully!");
    }


    private void handleAddProduct() {
        System.out.print("Enter Product ID: ");
        int Id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String Name = scanner.nextLine();

        System.out.print("Enter Price: ");
        double Price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int Quantity = scanner.nextInt();
        scanner.nextLine();


        //Creating an object with data
        Product product = new Product(Id, Name, Price, Quantity);
        //Add to inventory
        inventory.addProduct(product);

        System.out.println("Product added successfully!");
    }

    private void  handleSellProduct() {
        System.out.print("Enter Product ID: ");
        int Id = scanner.nextInt();
        System.out.print("How many would you like to sell?");
        int quantity = scanner.nextInt();
        inventory.sellProductById(Id,quantity);
        System.out.println("Product sold " + quantity + " successfully!");
    }



}
