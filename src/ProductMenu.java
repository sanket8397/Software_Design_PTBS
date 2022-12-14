/**
 * This is common product menu interface.
 * @author sanketkapse
 */
public interface ProductMenu {

    void showMenu();
    void showAddButton(String btnText);
    void showViewButton(ClassProductList products);
    void showRadioButton();
    void showLabels();
    void showComboxes();

    void makeFrameVisible();
}
