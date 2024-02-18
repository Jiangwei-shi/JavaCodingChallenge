package Day4;

import java.util.ArrayList;
import java.util.Objects;
//this is UserDAO Interface impl class
public class UserDAOImpl implements UserDAO {
    private final ArrayList<User> users = new ArrayList<>();
    User loginUser = null;

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public Boolean loginInUser(String username, String password) {
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username) &&
                    Objects.equals(user.getPassword(), password)) {
                this.loginUser = user;
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean isClient() {
        return loginUser instanceof Client;
    }

    @Override
    public User getLoginUser() {
        return loginUser;
    }

}
