package Day4;
import Day6.InvalidClientException;

//this is child class Client extends user class
public class Client extends User {
    public Client(String username, String password) throws InvalidClientException {
        super(username, password);
        if (!username.startsWith("Client_")) {
            throw new InvalidClientException("Client username must start with 'Client_'");
        }
    }
}
