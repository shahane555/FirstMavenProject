package forU.amTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BasketContentTest {
    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeMethod
    public void testBasketButton() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        driver.get("https://4u.am/en/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, 70);
        WebElement addItem = driver.findElement(By.xpath("//div[@id='offer1']//div[contains(@class, 'swiper-slide-next')]//div[contains(@class, 'item_basket')]//a"));
        js.executeScript("arguments[0].scrollIntoView();", addItem);
        wait.until(ExpectedConditions.elementToBeClickable(addItem));
        addItem.click();
        WebElement basketIcon = driver.findElement(By.xpath("//div[contains(@class, 'desktop_menu')]//div[contains(@id, 'basketIcon')]"));
        wait.until(ExpectedConditions.elementToBeClickable(basketIcon));
        basketIcon.click();
        WebElement orderName = driver.findElement(By.xpath("//div[contains(@class, 'basket_content')]//a//h4"));
        WebElement orderPrice = driver.findElement(By.xpath("//div[contains(@class, 'basket_content_item')]//p/span"));
        WebElement total = driver.findElement(By.xpath("//div[contains(@class, 'basket_content_main')]//span[contains(@id, 'cartTotalPrice')]"));
        Assert.assertTrue(orderName.getText().contains("Blot set «Blot Club»"));
        Assert.assertTrue(orderPrice.getText().contains("19,800"));
        Assert.assertTrue(total.getText().contains("19,800"));
    }
}
