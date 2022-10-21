/**
 * Trading Class implements the acceptance method for visitor pattern.
 * @author sanketkapse
 */
public class Trading {

    @SuppressWarnings("unused")
    public void accept(NodeVisitor visitor){
        visitor.visitTrading(this);
    }
}
