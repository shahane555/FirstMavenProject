package webParkTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParkingCostCalcTest {
    private WebDriver driver;

    @BeforeMethod
    public void testBasketButton() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/webpark");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public double calculateCost(double hours) {
        if (hours == 24) {
            return 24;
        }
        return 2 + 2 * (hours - 1);
    }

    @Test
    public void costTest() throws InterruptedException {
        WebElement parkingLot = driver.findElement(By.xpath("//select[@id = 'parkingLot']"));
        Select select = new Select(parkingLot);
        select.selectByVisibleText("Short-Term Parking");
        WebElement entryDate = driver.findElement(By.xpath("//input[@id = 'entryDate']"));
        entryDate.clear();
        entryDate.sendKeys("2023-08-05");

        WebElement entryTime = driver.findElement(By.xpath("//input[@id = 'entryTime']"));
        entryTime.clear();
        entryTime.sendKeys("12:00");

        WebElement exitDate = driver.findElement(By.xpath("//input[@id = 'exitDate']"));
        exitDate.clear();
        exitDate.sendKeys("2023-08-05");

        WebElement exitTime = driver.findElement(By.xpath("//input[@id = 'exitTime']"));
        exitTime.clear();
        exitTime.sendKeys("13:30");

        WebElement calculateCostButton = driver.findElement(By.xpath("//div[@id = 'actions']/button"));
        calculateCostButton.click();

        String expectedResultValue = calculateCost(1.5) + "0" + "€";
        String actualResultValue = driver.findElement(By.xpath("//div[@id = 'result']//b")).getText();
        Assert.assertEquals(expectedResultValue, actualResultValue);
        Thread.sleep(5000);
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}

