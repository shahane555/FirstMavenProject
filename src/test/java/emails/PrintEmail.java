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
        System.out.println(driver.findElement(By.cssSelector("#table2 > tbody > tr:nth-child(1) > td.email")).getText());
        System.out.println(driver.findElement(By.cssSelector("#table2 > tbody > tr:nth-child(2) > td.email")).getText());
        System.out.println(driver.findElement(By.cssSelector("#table2 > tbody > tr:nth-child(3) > td.email")).getText());
        System.out.println(driver.findElement(By.cssSelector("#table2 > tbody > tr:nth-child(4) > td.email")).getText());
        driver.findElement(By.cssSelector("#table2 > tbody > tr:nth-child(1) > td.action > a.btn.btn-danger")).click();
    }
}