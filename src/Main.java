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
//        TempFile tempFile = new TempFile();
//        tempFile.write_to_SellerOffering("BAD","B", "C" , 20);
//        tempFile.read_SellerOffering();
    }
}