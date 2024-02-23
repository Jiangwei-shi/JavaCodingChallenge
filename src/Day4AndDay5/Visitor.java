package Day4AndDay5;

import Day6.InvalidVisitorException;

//this is child class Visitor extends user class
public class Visitor extends User {
    public Visitor(String username, String password) throws InvalidVisitorException {
        super(username, password);
        if (!username.startsWith("Visitor_")) {
            throw new InvalidVisitorException("Visitor username must start with 'Visitor_'");
        }
    }
}
