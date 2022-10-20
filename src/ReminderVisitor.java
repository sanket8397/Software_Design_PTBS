/**
 * @author sanketkapse
 */
@SuppressWarnings("unused")
public class ReminderVisitor extends NodeVisitor{

    private Reminder m_Reminder;

    @Override
    public void visitProduct(Product product) {
        System.out.println("Visit product and do operations on Product class");
    }

    @Override
    public void visitTrading(Trading trading) {
        System.out.println("Visit trading and do do operations on Trading class");
    }

    @Override
    public void visitFacade(Facade facade) {
        System.out.println("Visit facade and do operations on Facade class");
    }
}
