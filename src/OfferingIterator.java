/**
 * This class is used to traverse offerings without exposing underlying representation.
 * Implementation of Iterator design pattern.
 * @author sanketkapse
 */
public class OfferingIterator implements ListIterator<Offering>{

    OfferingList list;
    int position = -1;

    public OfferingIterator(OfferingList list){
        this.list = list;
    }
    @Override
    public boolean hasNext() {
        return position < (list.size() - 1);
    }

    @Override
    public Offering Next() {
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

}
