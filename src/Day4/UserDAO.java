package Day4;
//this is UserDAO Interface
public interface UserDAO {
    void addUser(User user);
    Boolean loginInUser(String username, String password);
    Boolean isClient();
    User getLoginUser();
}
