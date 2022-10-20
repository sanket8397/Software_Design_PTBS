import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Facade facade = Facade.getInstance();
        try {
            facade.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}