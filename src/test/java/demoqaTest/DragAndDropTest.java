package demoqaTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragAndDropTest {
    private WebDriver driver;

    @BeforeMethod
    public void testBasketButton() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dragAndDropTest() {
        WebElement drag = driver.findElement(By.xpath("//div[@id = 'draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id = 'droppable']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drag, drop).build().perform();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'droppable']/p")).isEnabled());
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}
