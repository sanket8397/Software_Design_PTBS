import javax.swing.*;
import java.awt.*;

public class MeatProductMenu extends JFrame implements ProductMenu{

    Container productContainer = getContentPane();
    private final JLabel prdCatLabel = new JLabel("Product Category");
    JRadioButton meatRadio = new JRadioButton("Meat");
    JRadioButton produceRadio = new JRadioButton("Produce");
    private final ButtonGroup prdCatBtnGrp = new ButtonGroup();
    JComboBox<String> productsCombo1 = new JComboBox<String>();
    JLabel selectProduct = new JLabel("Select Product");
    JButton viewButton = new JButton("View");
    JButton addButton = new JButton("Add");
    @Override
    public void showMenu(){
        setContentPane(productContainer);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void showAddButton(){
        addButton.setBounds(50, 50,90,20);
        productContainer.add(addButton);
    }

    @Override
    public void showViewButton(){
        System.out.println("Hi");
        viewButton.setBounds(150, 50,90,20);
        productContainer.add(viewButton);
    }

    @Override
    public void showRadioButton(){
        meatRadio.setBounds(200,100,100,30);
        prdCatBtnGrp.add(meatRadio);
        produceRadio.setBounds(275,100,100,30);
        prdCatBtnGrp.add(produceRadio);
        meatRadio.setSelected(true);
        productContainer.add(prdCatLabel);
        productContainer.add(produceRadio);
        productContainer.add(meatRadio);
    }

    @Override
    public void showLabels(){
        prdCatLabel.setBounds(25,100,150,30);
    }

    @Override
    public void showComboxes(ClassProductList products){
        System.out.println(products);
        for (Product product : products){
            if (product.getCategory() == 0)
                productsCombo1.addItem(product.getName());
            System.out.println("abc");
        }
        System.out.println(products);
        selectProduct.setBounds(50, 300,200,20);
        productsCombo1.setBounds(300, 300,90,20);
        productContainer.add(selectProduct);
        productContainer.add(productsCombo1);
    }
}
