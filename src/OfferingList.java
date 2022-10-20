import java.util.ArrayList;

@SuppressWarnings("unused")
public class OfferingList extends ArrayList<Offering> {
    private OfferingIterator offeringIterator;
    public OfferingList(){
        offeringIterator = new OfferingIterator(this);
    }


}
