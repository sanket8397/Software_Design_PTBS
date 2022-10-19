import javax.swing.*;
import java.awt.*;

public class MeatProductMenu extends JFrame implements ProductMenu{

    public Container productContainer = getContentPane();
    private final JLabel prdCatLabel = new JLabel("Product Category");
    JRadioButton meatRadio = new JRadioButton("Meat");
    JRadioButton produceRadio = new JRadioButton("Produce");
    public ButtonGroup prdCatBtnGrp = new ButtonGroup();
    JComboBox<String> productsCombo = new JComboBox<String>();
    JButton viewButton = new JButton("View");
    JButton addButton = new JButton("Add");
    @Override
    public void showMenu(){
        setContentPane(productContainer);
        setSize(500,500);
//        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void showAddButton(){
        addButton.setBounds(50, 400,90,20);
        productContainer.add(addButton);
    }

    @Override
    public void showViewButton(){
        System.out.println("Hi");
        viewButton.setBounds(150, 400,90,20);
        productContainer.add(viewButton);
    }

    @Override
    public void showRadioButton(){
        meatRadio.setBounds(150,100,100,30);
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
        prdCatLabel.setBounds(25,100,125,30);
    }

    @Override
    public void showComboxes(ClassProductList products){
        System.out.println(products);

        for (Product product : products){
            if (product.getCategory() == 0)
                productsCombo.addItem(product.getName());
        }
        System.out.println(products);
        productsCombo.setBounds(new Rectangle(50, 250, 200, 20));
        productContainer.add(productsCombo);
    }

    public void makeFrameVisible(){
        setVisible(true);
    }
}
