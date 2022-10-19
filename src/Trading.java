public class Trading {

    @SuppressWarnings("unused")
    public void accept(NodeVisitor visitor){
        visitor.visitTrading(this);
    }
}
