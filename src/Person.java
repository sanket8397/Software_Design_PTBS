
/**
 * This class is parent class for buyer and seller.
 * This class declares the factory method CreateProductMenu.
 * Factory and bridge design pattern is implemented here.
 * It has high level implementation of GUI. (Bridge)
 * @author sanketkapse
 */
@SuppressWarnings("UnusedReturnValue")
public abstract class Person {
    ProductMenu theProductMenu;
    int userType;
    String username;
    ClassProductList productList;
    public abstract void showMenu();
    public abstract ProductMenu CreateProductMenu(int productCategory);
    public void showAddButton(String btnText){
        theProductMenu.showAddButton(btnText);
    }
    public void showViewButton(){
        theProductMenu.showViewButton(productList);
    }
    public void showRadioButton(){
        theProductMenu.showRadioButton();
    }
    public void showLabels(){
        theProductMenu.showLabels();
    }
    public void showComboxes(){
//        theProductMenu = new ProduceProductMenu();
        theProductMenu.showComboxes();
    }

}
