import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Facade facade = new Facade();
        try {
            facade.createProductList();
            System.out.println("Hello world!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}