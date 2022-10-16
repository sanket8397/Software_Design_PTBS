import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login extends JFrame {

    private String user;
    private int userType;
    public boolean isLoggedIn = false;


    private final Container loginContainer = getContentPane();
    private final JLabel userTypeLabel = new JLabel("User Type");
    private final JRadioButton buyerRadio = new JRadioButton("Buyer");
    private final JRadioButton sellerRadio = new JRadioButton("Seller");
    private final ButtonGroup userTypeBtnGrp = new ButtonGroup();
    private final JLabel userLabel = new JLabel("Username");
    private final JLabel passwordLabel = new JLabel("Password");
    private final JTextField userField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JButton loginButton = new JButton("Login");
    Login(){
        setContentPane(loginContainer);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setComponents();
        addComponents();
    }

    private void setComponents(){
        userTypeLabel.setBounds(25,100,100,30);
        buyerRadio.setBounds(150,100,100,30);
        userTypeBtnGrp.add(buyerRadio);
        sellerRadio.setBounds(275,100,100,30);
        userTypeBtnGrp.add(sellerRadio);
        buyerRadio.setSelected(true);
        userLabel.setBounds(25,150,100,30);
        userField.setBounds(150,150,200,30);

        passwordLabel.setBounds(25,200,100,30);
        passwordField.setBounds(150,200,200,30);

        loginButton.setBounds(200,250,100,30);
        loginButton.addActionListener(e -> {
            try {
                loginMethod();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    private void addComponents(){
        loginContainer.add(userTypeLabel);
        loginContainer.add(buyerRadio);
        loginContainer.add(sellerRadio);
        loginContainer.add(userLabel);
        loginContainer.add(userField);
        loginContainer.add(passwordLabel);
        loginContainer.add(passwordField);
        loginContainer.add(loginButton);
    }

    private void loginMethod() throws FileNotFoundException {
        Scanner scanner;
        if (buyerRadio.isSelected()){
            userType = 0;
            scanner = new Scanner(new File("resources/BuyerInfo.txt"));
        }
        else {
            userType = 1;
            scanner = new Scanner(new File("resources/SellerInfo.txt"));
        }
        String username = userField.getText();
        String password = new String(passwordField.getPassword());

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(":");
            if (username.equals(tokens[0])){
                if (password.equals(tokens[1])){
                    user = username;
                    System.out.println("Login Successful");
                    isLoggedIn = true;
                }
            }
        }
        if (!isLoggedIn) {
            JOptionPane.showMessageDialog(this, "Invalid Username or password");
            userField.setText("");
            passwordField.setText("");
        }
        scanner.close();
    }

    public String getUser() {
        return user;
    }

    public int getUserType() {
        return userType;
    }

}
