public class Seller extends Person{

    public Seller(String username){
        this.userType = 1;
        this.username = username;
        this.productList = new ClassProductList();
    }
    @Override
    public void showMenu() {
        theProductMenu.showMenu();
        showLabels();
        showViewButton();
        showAddButton();
        showRadioButton();
        showComboxes(productList);
//        theProductMenu.showMenu();
    }

    @Override
    public ProductMenu CreateProductMenu(int productCategory){
        if (productCategory == 1){
            System.out.println("Show Produce");
            theProductMenu = new ProduceProductMenu();
        }
        else if (productCategory == 0){
            System.out.println("Show Meat");
            theProductMenu = new MeatProductMenu();
        }
        return theProductMenu;
    }
}

