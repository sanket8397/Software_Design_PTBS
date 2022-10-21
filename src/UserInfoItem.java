/**
 * This class is used to store userType and username after login
 * @author sanketkapse
 */
public class UserInfoItem {
    private String username;
    private int userType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
