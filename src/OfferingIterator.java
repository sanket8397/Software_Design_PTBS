public class OfferingIterator implements ListIterator<Offering>{

    OfferingList list;
    int index = 0;

    public OfferingIterator(OfferingList list){
        this.list = list;
    }
    @Override
    public boolean hasNext() {
        return index <= (list.size() - 1);
    }

    @Override
    public Object Next() {
        return hasNext() ? list.get(index++) : null;
    }

    @Override
    public void MoveToHead() {
        index = 0;
    }

    @Override
    public void Remove() {
        if (index <= 0)
            list.remove(index);
    }

}
