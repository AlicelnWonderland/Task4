// product class that implements cloneable to support cloning
// cloning allows to create copies of objects without altering original
class Product implements Cloneable {
    private String name;
    private double price;

    // constructor for creating product with name and price
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // method for cloning the product
    // it uses Object's clone() to return a shallow copy of the product
    @Override
    public Product clone() {
        try {
            return (Product) super.clone();  // creates a shallow copy of the product
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  // should not happen since we implement cloneable
        }
    }

    // method to change price of cloned product
    public void setPrice(double price) {
        this.price = price;
    }

    // overriding toString to display product details
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + '}';
    }
}

// test code that demonstrates prototype pattern with cloning
public class PrototypePatternExample {
    public static void main(String[] args) {
        // creating original product
        Product originalProduct = new Product("Laptop", 500000);
        System.out.println("Original Product: " + originalProduct);

        // creating clone of the original product
        Product clonedProduct = originalProduct.clone();  // clone the product
        clonedProduct.setPrice(450000);  // we change the price for the cloned version

        // displaying original and cloned products
        System.out.println("Original Product (unchanged): " + originalProduct);
        System.out.println("Cloned Product (with price changed): " + clonedProduct);
    }
}
