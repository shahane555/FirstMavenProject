package emails;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintEmail {
    @Test
    public void print() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/tables");
        System.out.println(driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[1]/td[3]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[2]/td[3]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[3]/td[3]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[4]/td[3]")).getText());
        driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[1]/td[6]/a[2]")).click();
        driver.quit();
    }
}