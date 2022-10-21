import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MeatProductMenu extends JFrame implements ProductMenu {

    public Container productContainer = getContentPane();
    JRadioButton meatRadio;
    JRadioButton produceRadio;
    public ButtonGroup prdCatBtnGrp = new ButtonGroup();
    JComboBox<String> productsCombo;
    JButton viewButton;
    JButton addButton;

    private String selectedProduct;
    Facade facade = Facade.getInstance();

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
        addButton.setBounds(50, 50,90,20);
        productContainer.add(addButton);
    }

    @Override
    public void showViewButton(ClassProductList products){
        viewButton = new JButton("View");
        viewButton.setBounds(150, 50,90,20);
        productContainer.add(viewButton);
        viewButton.addActionListener(e -> {
            showProducts(products);
        });
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
    public void showComboxes(){
        productsCombo = new JComboBox<String>();
        ClassProductList products = facade.getTheProductList();
        for (Product product : products){
            if (product.getCategory() == 0)
                productsCombo.addItem(product.getName());
        }
        productsCombo.setBounds(new Rectangle(150, 150, 150, 20));
        productsCombo.addActionListener(e -> {
            selectedProduct = productsCombo.getSelectedItem().toString();
            System.out.println(selectedProduct);
        });
        productContainer.add(productsCombo);
    }


    public void showProducts(ClassProductList products) {
        String productString = "";
        for (Product product : products) {
            if (product.getCategory() == 0) {
                System.out.println(product.getName());
                productString = productString + product.getName() + "\n";
            }
        }
        JOptionPane.showMessageDialog(this, productString);
    }

    public void makeFrameVisible(){
        setVisible(true);
    }



    private void addProduct() throws IOException {
        if (selectedProduct != null){
            Path path = Paths.get("resources/UserProduct.txt");
            String name = facade.getUserName();
            String str = name + ":" + selectedProduct;
            Files.write(path, System.getProperty("line.separator").getBytes(), StandardOpenOption.APPEND);
            Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
            facade.AttachProductToUser();
        }
    }

}
