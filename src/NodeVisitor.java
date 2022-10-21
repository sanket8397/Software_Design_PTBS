/**
 * This is abstract class which has declared visiting methods.
 * Implementation of visitor pattern.
 * @author sanketkapse
 */
public abstract class NodeVisitor {

    public abstract void visitProduct(Product product);
    public abstract void visitTrading(Trading trading);
    public abstract void visitFacade(Facade facade);
}
