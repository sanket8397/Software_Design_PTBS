/**
 * This class is used to traverse products without exposing underlying representation.
 * Implementation of Iterator design pattern.
 * @author sanketkapse
 */
public class ProductIterator implements ListIterator<Product> {

    ClassProductList list;
    int position = -1;

    public ProductIterator(ClassProductList list){
        this.list = list;
    }
    @Override
    public boolean hasNext() {
        return position < (list.size() - 1);
    }

    @Override
    public Product Next() {
        return hasNext() ? list.get(++position) : null;
    }

    @Override
    public void MoveToHead() {
        position = -1;
    }

    @Override
    public void Remove() {
        if (position != -1)
            list.remove(position);
    }

    public Product findByUserName(String productName){
        MoveToHead();
        while(hasNext()){
            Next();
            if(productName.equals(list.get(position).getName())){
                return list.get(position);
            }
        }
        return null;
    }
}
