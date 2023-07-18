package sauceDemoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Main {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void test() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closePage() throws InterruptedException {
        Thread.sleep(3000);
        getDriver().quit();
    }
}
