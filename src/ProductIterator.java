public class ProductIterator implements ListIterator<Product> {

    ClassProductList list;
    int index = -1;

    public ProductIterator(ClassProductList list){
        this.list = list;
    }
    @Override
    public boolean hasNext() {
        return index < (list.size() - 1);
    }

    @Override
    public Object Next() {
        return hasNext() ? list.get(++index) : null;
    }

    @Override
    public void MoveToHead() {
        index = -1;
    }

    @Override
    public void Remove() {
        if (index != -1)
            list.remove(index);
    }
}
