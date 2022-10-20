import java.util.ArrayList;

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
