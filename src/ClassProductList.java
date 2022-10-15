import java.util.ArrayList;

public class ClassProductList extends ArrayList {

    private ProductIterator productIterator;

    public ClassProductList(){
        productIterator = new ProductIterator(this);
    }

    public void accept(NodeVisitor visitor){

    }
}
