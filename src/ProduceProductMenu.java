import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

/**
 * @author sanketkapse
 */
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
        selectProduct.setBounds(50, 150,90,20);
        productContainer.add(selectProduct);
    }

    @Override
    public void showComboxes(){
        productsCombo = new JComboBox<String>();
        ClassProductList products = facade.getTheProductList();
        for (Product product : products){
            if (product.getCategory() == 1)
                productsCombo.addItem(product.getName());
        }
        productsCombo.setBounds(new Rectangle(200, 150,150,20));
        productsCombo.addActionListener(e -> {
            selectedProduct = productsCombo.getSelectedItem().toString();
            System.out.println(selectedProduct);
        });
        productContainer.add(productsCombo);
    }

    public void showProducts(ClassProductList products) {
        String productString = "";
        for (Product product : products) {
            if (product.getCategory() == 1) {
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
