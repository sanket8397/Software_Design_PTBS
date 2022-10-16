import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

    private ProductIterator productIterator;

    public ClassProductList(){
        productIterator = new ProductIterator(this);
    }

    public Product getProductByName(String name){
        return productIterator.findByUserName(name);
    }

    public void accept(NodeVisitor visitor){

    }
}
