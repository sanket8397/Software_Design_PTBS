import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This class is implementation of Facade pattern.*
 * @author sanketkapse
 */
@SuppressWarnings("unused")
public class Facade {

    private static Facade facadeInstance;

    private Product theSelectedProduct;
    private ClassProductList theProductList;
    private Person thePerson;

    private UserInfoItem userInfoItem;
    private Login loginScreen;

    private Facade(){

    }

    //Singleton pattern is implemented.
    //Facade instance is passed to MeatProductMenu and ProduceProductMenu for theProductList and username.
    public static Facade getInstance(){
        if (facadeInstance == null){
            facadeInstance = new Facade();
        }
        return facadeInstance;
    }

    public boolean login(UserInfoItem userInfoItem){
        if (loginScreen.isLoggedIn){
            userInfoItem.setUsername(loginScreen.getUser());
            userInfoItem.setUserType(loginScreen.getUserType());
            int userType = loginScreen.getUserType();
        }
        return loginScreen.isLoggedIn;
    }

    public void login(){
        loginScreen = new Login();
    }

    public void addTrading(){

    }

    public void viewTrading(){

    }

    public void decideBidding(){

    }

    public void discussBidding(){

    }

    public void submitBidding(){

    }

    public void remind(){
        ReminderVisitor reminderVisitor = new ReminderVisitor();
        theProductList.accept(reminderVisitor);
        facadeInstance.accept(reminderVisitor);
    }

    public void accept(NodeVisitor visitor){
        visitor.visitFacade(this);
    }

    //Factory method is implemented to create buyer or seller.
    public void createUser(UserInfoItem userinfoitem){
        if (userinfoitem.getUserType() == 0){
            thePerson = new Buyer(userInfoItem.getUsername());
        }
        else if (userinfoitem.getUserType() == 1){
            thePerson = new Seller(userInfoItem.getUsername());
        }
    }

    public void createProductList() throws FileNotFoundException {
        theProductList = new ClassProductList();
        Scanner scanner = new Scanner(new File("resources/ProductInfo.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(":");
            if ("Meat".equals(tokens[0]))
                theProductList.add(new Product(tokens[1], 0));
            else if ("Produce".equals(tokens[0]))
                theProductList.add(new Product(tokens[1], 1));
        }
        scanner.close();
    }

    public void AttachProductToUser() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("resources/UserProduct.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(":");
            if(thePerson.username.equals(tokens[0])){
                thePerson.productList.add(theProductList.getProductByName(tokens[1]));
            }
        }
        scanner.close();
    }

    public Product SelectProduct(){
        return new Product();
    }

    // Creates Product Menu depending on Menu Category
    public void productOperation(){
        ProductCategoryUI productCategoryUI = new ProductCategoryUI();
        int productCategory;
        try {
            productCategory = productCategoryUI.getProductCategory();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.createMenu(productCategory);
    }

    public void createMenu(int productCategory){
        thePerson.CreateProductMenu(productCategory);
        thePerson.showMenu();
    }

    //This method gets called first.
    public void run() throws FileNotFoundException, InterruptedException {
        System.out.println("Run");
        createProductList();
        userInfoItem = new UserInfoItem();
        this.login();
        while(true){
            TimeUnit.SECONDS.sleep(1);
            if (login(userInfoItem))
                break;
        }
        this.createUser(userInfoItem);
        this.AttachProductToUser();
        this.productOperation();
        System.out.println("------------------------------------------");
        System.out.println("Implementing Visitor Pattern");
        remind();
        System.out.println("------------------------------------------");
    }

    public ClassProductList getTheProductList(){
        return theProductList;
    }

    public String getUserName(){
        return userInfoItem.getUsername();
    }
}
