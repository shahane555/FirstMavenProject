package sauceDemoTest;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends Main {

    @DataProvider
    public Object[][] username() {
        return new Object[][]{{"standard_user"}, {"locked_out_user"}, {"problem_user"}, {"performance_glitch_user"}};
    }

    @Test(dataProvider = "username")
    public void validUser(String username) {
        getDriver().get("https://saucedemo.com/");
        getDriver().findElement(By.cssSelector("input#user-name")).sendKeys(username);
        getDriver().findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
        getDriver().findElement(By.cssSelector("input#login-button")).click();
        getDriver().findElement(By.cssSelector("div.app_logo"));
    }

    @Test(dataProvider = "username")
    public void lockedOutUser(String username) {
        getDriver().get("https://saucedemo.com/");
        getDriver().findElement(By.cssSelector("input#user-name")).sendKeys(username);
        getDriver().findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
        getDriver().findElement(By.cssSelector("input#login-button")).click();
        getDriver().findElement(By.cssSelector("button.error-button"));
    }

    @Test(dataProvider = "username")
    public void lockedOutUsername(String username) {
        getDriver().get("https://saucedemo.com/");
        getDriver().findElement(By.cssSelector("input#user-name")).sendKeys(username);
        getDriver().findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
        getDriver().findElement(By.cssSelector("input#login-button")).click();
        getDriver().findElement(By.cssSelector("button.error-button"));
    }

    @Test(dataProvider = "username")
    public void problemUser(String username) {
        getDriver().get("https://saucedemo.com/");
        getDriver().findElement(By.cssSelector("input#user-name")).sendKeys(username);
        getDriver().findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
        getDriver().findElement(By.cssSelector("input#login-button")).click();
        getDriver().findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_img"));
    }
}