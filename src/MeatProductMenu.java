import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MeatProductMenu extends JFrame implements ProductMenu {

    public Container productContainer = getContentPane();
    JRadioButton meatRadio;
    JRadioButton produceRadio;
    public ButtonGroup prdCatBtnGrp = new ButtonGroup();
    JComboBox<String> productsCombo;
    JButton viewButton;
    JButton addButton;

    private String selectedProduct;
    @Override
    public void showMenu(){
        setContentPane(productContainer);
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void showAddButton(String btnText){
        addButton = new JButton(btnText);
        addButton.addActionListener(e -> {
            try {
                addProduct();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        addButton.setBounds(50, 400,90,20);
        productContainer.add(addButton);
    }

    @Override
    public void showViewButton(){
        viewButton = new JButton("View");
        viewButton.setBounds(150, 400,90,20);
        productContainer.add(viewButton);
    }

    @Override
    public void showRadioButton(){
        meatRadio = new JRadioButton("Meat");
        produceRadio = new JRadioButton("Produce");
        meatRadio.setBounds(150,100,100,30);
        prdCatBtnGrp.add(meatRadio);
        produceRadio.setBounds(275,100,100,30);
        prdCatBtnGrp.add(produceRadio);
        meatRadio.setSelected(true);
        productContainer.add(produceRadio);
        productContainer.add(meatRadio);
    }

    @Override
    public void showLabels(){
        JLabel prdCatLabel = new JLabel("Product Category");
        prdCatLabel.setBounds(25,100,125,30);
        productContainer.add(prdCatLabel);
    }

    @Override
    public void showComboxes(ClassProductList products){
        productsCombo = new JComboBox<String>();
        for (Product product : products){
            if (product.getCategory() == 0)
                productsCombo.addItem(product.getName());
        }
        System.out.println(products);
        productsCombo.setBounds(new Rectangle(50, 250, 200, 20));
        productsCombo.addActionListener(e -> {
            selectedProduct = productsCombo.getSelectedItem().toString();
            System.out.println(selectedProduct);
        });
        productContainer.add(productsCombo);
    }

    public void makeFrameVisible(){
        setVisible(true);
    }



    private void addProduct() throws IOException {
        if (selectedProduct != null){
            JOptionPane.showMessageDialog(this, "Hi" + " "+ selectedProduct);
        }
    }

}
