/**
 * This is interface for Iterator pattern
 * @author sanketkapse
 * @param <O> Object
 */
public interface ListIterator<O> {

    boolean hasNext();
    Object Next();
    void MoveToHead();
    void Remove();

}
