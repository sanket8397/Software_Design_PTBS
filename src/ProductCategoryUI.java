import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * This is additional task created for getting product category for first time when user logs in.
 * @author sanketkapse
 */
public class ProductCategoryUI extends JFrame {
    JRadioButton meatRadio = new JRadioButton("Meat");
    JRadioButton produceRadio = new JRadioButton("Produce");


    public ProductCategoryUI(){
        Container productCatContainer = getContentPane();
        setContentPane(productCatContainer);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        JLabel prdCatLabel = new JLabel("Product Category");
        prdCatLabel.setBounds(25,100,150,30);
        meatRadio.setBounds(200,100,100,30);
        ButtonGroup prdCatBtnGrp = new ButtonGroup();
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
