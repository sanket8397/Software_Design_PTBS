import java.util.ArrayList;

/**
 * This is class is used for storing collection of offerings.
 * @author sanketkapse
 */
@SuppressWarnings("unused")
public class OfferingList extends ArrayList<Offering> {
    private OfferingIterator offeringIterator;
    public OfferingList(){
        offeringIterator = new OfferingIterator(this);
    }


}
