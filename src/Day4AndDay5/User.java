package Day4AndDay5;
//this is parent user class
public abstract class User {
    private static int lastUserId = 0;
    private final int userId;
    private final String username;
    private final String password;

    public User(String username,String password){
        this.userId = ++lastUserId;
        this.username = username;
        this.password = password;
    }

    public int getUserId(){
        return userId;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
