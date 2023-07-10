
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Users {
    @BeforeTest
    public static User register(String login, String password) {
        return new User(login, password);
    }

    @Test
    public static User login(String login, String password) {
        return new User(login, password);
    }
}