import javax.swing.*;
import java.awt.*;

public abstract class Person {
    ProductMenu theProductMenu;
    int userType;
    String username;
    ClassProductList productList;
    public abstract void showMenu();
    public abstract ProductMenu CreateProductMenu(int productCategory);
    public void showAddButton(){
        theProductMenu.showAddButton();
    }
    public void showViewButton(){
        theProductMenu.showViewButton();
    }
    public void showRadioButton(){
        theProductMenu.showRadioButton();
    }
    public void showLabels(){
        theProductMenu.showLabels();
    }
    public void showComboxes(ClassProductList products){
        theProductMenu = new ProduceProductMenu();
        theProductMenu.showComboxes(products);
    }
}
