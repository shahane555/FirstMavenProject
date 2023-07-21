package emails;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class PrintEmail {
    @Test
    public void print() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/tables");
        List<WebElement> e = driver.findElements(By.xpath("//*[@id='table2']/tbody//tr/td[contains(@class, 'email')]"));
        for (int i = 0; i < e.size(); i++) {
            System.out.println(e.get(i).getText());
        }
        driver.findElement(By.xpath("//*[@id='table2']/tbody/tr/td[contains(@class, 'action')]/a[contains(@class, 'btn btn-danger')]"));
    }
}