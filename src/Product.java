/**
 * This class is created for storing product details.
 * @author sanketkapse
 */
public class Product {
    private String name;
    private int category;

    public Product(){

    }
    public Product(String name, int category){
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getCategory() {
        return category;
    }
}
