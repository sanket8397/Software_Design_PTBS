import java.util.ArrayList;

/**
 * This is class is used for storing collection of products.
 * Iterator Pattern is utilized here.
 * @author sanketkapse
 */
public class ClassProductList extends ArrayList<Product> {

    private final ProductIterator productIterator;

    public ClassProductList(){
        productIterator = new ProductIterator(this);
    }

    public Product getProductByName(String name){
        return productIterator.findByUserName(name);
    }

    public void accept(NodeVisitor visitor){
        productIterator.MoveToHead();
        while (productIterator.hasNext()){
            visitor.visitProduct(productIterator.Next());
        }
    }
}
