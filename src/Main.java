import java.io.IOException;

/**
 * This class is used for calling run method in Facade class.
 * @author sanketkapse
 */
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