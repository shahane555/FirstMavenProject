import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAppRegistration {
    User user = new Application().register("name", "surname", "ema@il.com", "12345678");
    User user2 = new Application().register("Anna", "Poghosyan", "u@sername.com", "55555555");
    User user4 = new Application().register("name", "surname", "username@2.com", "12345678");

    @Test
    public void successRegistration() {
        Assert.assertEquals(new Application().login("ema@il.com", "12345678"), user);
    }

    @Test
    public void loginWithCorrectUsername() {
        Assert.assertEquals(new Application().login("ema@il.com", "12345678"), user);
    }

    @Test
    public void loginWithInvalidUsername() {
        Assert.assertEquals(new Application().login("e@mail.com", "12345678"), user);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void doubleRegistration() {
        User user3 = new Application().register("Anna", "Poghosyan", "us@ername.com", "55555555");
    }

    @DataProvider(name = "symbols")
    public Object[][] suitableSymbols() {
        return new Object[][]{{"email@.com"}, {"emailcom"}, {"email@com"}};
    }

    @Test(dataProvider = "symbols")
    public void usernameValidation(String username) {
        User user = new Application().register("name", "surname", username, "12345678");
        System.out.println(username);
    }

    @Test
    public void validPassword() {
        User user = new Application().register("name", "surname", "User@name", "12345678");
    }

    @Test
    public void invalidPassword() {
        User user = new Application().register("name", "surname", "username", "123");
    }

    public static void main(String[] args) {
        Application.getUsers().clear();
    }
}

