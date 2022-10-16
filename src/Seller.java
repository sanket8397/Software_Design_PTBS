public class Seller extends Person{

    public Seller(String username){
        this.userType = 1;
        this.username = username;
        this.productList = new ClassProductList();
    }
    @Override
    public void showMenu() {

    }

    @Override
    public ProductMenu CreateProductMenu() {
        return null;
    }
}

