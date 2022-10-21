import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Facade facade = Facade.getInstance();
        try {
            facade.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}