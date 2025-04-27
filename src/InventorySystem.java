import java.util.Scanner;

public class InventorySystem {
    Scanner scanner = new Scanner(System.in);
    private Inventory inventory = new Inventory();

    public void start() {

        boolean running = true;

        while (running) {
            System.out.println("1. Termék raktárba helyezése");
            System.out.println("2. Termék törlése a raktárból (vonalkód beolvasás)");
            System.out.println("3. Termék mennyiségének növelése");
            System.out.println("4. Termék eladás a raktárból (vonalkód beolvasás)");
            System.out.println("5. Teljes készlet megtekintése");
            System.out.println("6. Keresés azonosító alapján");
            System.out.print("7. Kilépés (mentés)");

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
                    handleAddingProductQuantity();
                    break;
                case 4:
                    handleSellProduct();

                case 5:
                    inventory.listProducts();
                    break;
                case 6:
                    HandleSearchingById();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
 /// 1. menu
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

///  2. menu
    private void handleRemoveProduct() {
        System.out.print("Enter Product ID: ");
        int Id = scanner.nextInt();
        inventory.removeProductById(Id);
        System.out.println("Product Removed successfully!");
    }
///  3. menu
    private void handleAddingProductQuantity() {
        System.out.print("Enter Product ID: ");
        int Id = scanner.nextInt();
        System.out.print("How many would you like to add?");
        int quantity = scanner.nextInt();
        inventory.AddingProductQuantity(Id,quantity);
        System.out.println("Quantity of product added " + quantity + " successfully!");
    }

///  4. menu
    private void  handleSellProduct() {
        System.out.print("Enter Product ID: ");
        int Id = scanner.nextInt();
        System.out.print("How many would you like to sell?");
        int quantity = scanner.nextInt();
        inventory.sellProductById(Id,quantity);
        System.out.println("Product sold " + quantity + " successfully!");
    }

///  6. menu
    private void HandleSearchingById() {
        System.out.print("Enter Product ID: ");
        int Id = scanner.nextInt();
        inventory.listProductsById(Id);
    }

}
