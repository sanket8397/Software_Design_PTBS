import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Facade {

    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;

    private UserInfoItem userInfoItem;
    private Login loginScreen;

    private ProductCategoryUI productCategoryUI;

    public boolean login(UserInfoItem userInfoItem){
        if (loginScreen.isLoggedIn){
            userInfoItem.setUsername(loginScreen.getUser());
            userInfoItem.setUserType(loginScreen.getUserType());
            UserType = loginScreen.getUserType();
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

    }

    public void accept(NodeVisitor visitor){
        visitor.visitFacade(this);
    }

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
            if (new String("Meat").equals(tokens[0]))
                theProductList.add(new Product(tokens[1], 0));
            else if (new String("Produce").equals(tokens[0]))
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

    public void productOperation(){
        productCategoryUI = new ProductCategoryUI();
        int productCategory = 0;
        try {
            productCategory = productCategoryUI.getProductCategory();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thePerson.CreateProductMenu(productCategory);
        thePerson.showMenu();
    }

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
    }
}
