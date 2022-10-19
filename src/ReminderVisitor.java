public class ReminderVisitor extends NodeVisitor{

    private Reminder m_Reminder;

    @Override
    public void visitProduct(Product product) {
        System.out.println("Do operations on Product class");
    }

    @Override
    public void visitTrading(Trading trading) {
        System.out.println("Do operations on Trading class");
    }

    @Override
    public void visitFacade(Facade facade) {
        System.out.println("Do operations on Facade class");
    }
}
