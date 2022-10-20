import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ProduceProductMenu extends JFrame implements ProductMenu{

    Container productContainer = getContentPane();
    private JLabel prdCatLabel;
    JRadioButton meatRadio;
    JRadioButton produceRadio;
    private final ButtonGroup prdCatBtnGrp = new ButtonGroup();
    JComboBox<String> productsCombo;
    JLabel selectProduct;
    JButton viewButton;
    JButton addButton;

    @Override
    public void showMenu(){
        setContentPane(productContainer);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void showAddButton(String btnText){
        addButton = new JButton(btnText);
        addButton.setBounds(50, 50,90,20);
        productContainer.add(addButton);
    }

    @Override
    public void showViewButton(){
        viewButton = new JButton("View");
        viewButton.setBounds(150, 50,90,20);
        productContainer.add(viewButton);
    }

    @Override
    public void showRadioButton(){
        meatRadio = new JRadioButton("Meat");
        meatRadio.setBounds(200,100,100,30);
        produceRadio = new JRadioButton("Produce");
        prdCatBtnGrp.add(meatRadio);
        produceRadio.setBounds(275,100,100,30);
        prdCatBtnGrp.add(produceRadio);
        produceRadio.setSelected(true);
        productContainer.add(produceRadio);
        productContainer.add(meatRadio);
    }

    @Override
    public void showLabels(){
        prdCatLabel = new JLabel("Product Category");
        prdCatLabel.setBounds(25,100,150,30);
        productContainer.add(prdCatLabel);
        selectProduct = new JLabel("Select Product");
        selectProduct.setBounds(50, 250,90,20);
        productContainer.add(selectProduct);
    }

    @Override
    public void showComboxes(ClassProductList products){
        productsCombo = new JComboBox<String>();
        for (Product product : products){
            if (product.getCategory() == 1)
                productsCombo.addItem(product.getName());
        }
        productsCombo.setBounds(new Rectangle(100, 300,90,20));
//        productsCombo.setSize(90,20);
        productContainer.add(productsCombo);
    }

    public void makeFrameVisible(){
        setVisible(true);
    }
}
