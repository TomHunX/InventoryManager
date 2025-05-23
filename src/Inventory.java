import java.util.Map;
import java.util.HashMap;

public class Inventory {
    private Map<Integer, Product> products;


    public Inventory() {
        products = new HashMap<>();

    }

    // Adding Product to map
    public void addProduct(Product product) {
        products.put(product.getId(), product);

    }

    // Delete Product
    public void removeProductById(int id) {
        products.remove(id);
    }


    public void AddingProductQuantity(int id, int quantity) {
        Product product = products.get(id);

        int currentQuantity = product.getQuantity();
        if (product!=null) {
            product.setQuantity(currentQuantity+quantity);
            System.out.println("Quantity of product in inventory: " + product.getQuantity() + "!");
        }

    }



    public void sellProductById(int id, int quantity) {
        Product product = products.get(id);

        if (product != null) { // If exist this product

            int currentQuantity = product.getQuantity();

            if (currentQuantity >= quantity) {
                product.setQuantity(currentQuantity - quantity);
                System.out.println(quantity + " units sold. Remaining: " + product.getQuantity());
            } else if (currentQuantity < quantity) {
                int need_quantity = quantity - currentQuantity;
                System.out.println("Not enough products left. need " + currentQuantity);

            }
            else products.remove(id);


        }

    }
    // List elements of inventory --- 5. menu
    public void listProducts() {
        for (Product p : products.values()) {
            System.out.println(p.getId() + " - " + p.getName()+ " " + p.getPrice()+" Ft"+" (" + p.getQuantity() + " db)");
        }
    }
    // List elements of inventory by Id --- 6. menu
    public void listProductsById(int id) {
        for (Product p : products.values()) {
            if (p.getId() == id) {
                System.out.println(p.getId() + " - " + p.getName() + " " + p.getPrice()+" Ft"+" ( " + p.getQuantity() + " db )");
            }

        }
    }


}
