public class Product {
    private String Id;
    private String Name;
    private Double Price;
    private int Quantity;


    Product(String id, String name, Double price, int quantity) {
        this.Id = id;
        this.Name = name;
        this.Price = price;
        this.Quantity = quantity;
    }

    //Getters & Setters


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if(name == "" || name == null || name.isBlank()) {
            Name = "Név nélküli termék";
        }
        else this.Name = name;

    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        if (price < 0) {
            Price = null;
        } else this.Price = price;

    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        String seged = "Nincsen";
        if (quantity < 0) {
            System.out.println(seged);
        } else this.Quantity = quantity;
    }
}
