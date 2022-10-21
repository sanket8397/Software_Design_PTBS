import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ProductCategoryUI extends JFrame {
    private final Container productCatContainer = getContentPane();
    private final JLabel prdCatLabel = new JLabel("Product Category");
    JRadioButton meatRadio = new JRadioButton("Meat");
    JRadioButton produceRadio = new JRadioButton("Produce");
    private final ButtonGroup prdCatBtnGrp = new ButtonGroup();


    public ProductCategoryUI(){
        setContentPane(productCatContainer);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        prdCatLabel.setBounds(25,100,150,30);
        meatRadio.setBounds(200,100,100,30);
        prdCatBtnGrp.add(meatRadio);
        produceRadio.setBounds(275,100,100,30);
        prdCatBtnGrp.add(produceRadio);
        productCatContainer.add(prdCatLabel);
        productCatContainer.add(produceRadio);
        productCatContainer.add(meatRadio);
    }

    public int getProductCategory() throws InterruptedException {
        while(!meatRadio.isSelected() & !produceRadio.isSelected()){
            TimeUnit.SECONDS.sleep(1);
        }
        setVisible(false);
        return meatRadio.isSelected() ? 0 : 1;
    }
}
