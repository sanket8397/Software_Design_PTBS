public class Buyer extends Person{

    public Buyer(String username){
        this.userType = 0;
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
