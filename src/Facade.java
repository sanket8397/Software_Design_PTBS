public class Facade {

    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;

    private UserInfoItem userInfoItem;

    public boolean login(){
        Login loginScreen = new Login();
        if (loginScreen.isLoggedIn()){
            userInfoItem.setUsername(loginScreen.getUser());
            userInfoItem.setUserType(loginScreen.getUserType());
            UserType = loginScreen.getUserType();
        }
        return loginScreen.isLoggedIn();
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

    public void createUser(UserInfoItem userinfoitem){

    }

    public void createProductList(){

    }

    public void AttachProductToUser(){

    }

    public Product SelectProduct(){
        return new Product();
    }

    public void productOperation(){

    }
}
