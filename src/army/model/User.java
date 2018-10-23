package army.model;

public class User {

    private static User user_instance = null;
    private String username;
    private String password;
    private String usertype;
//        private constuctor 

    private User() {
    }

    public static User getinstance() {
        if (user_instance == null) {
            user_instance = new User();
        }
        return user_instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password
                + ", usertype=" + usertype + "]";
    }

}
