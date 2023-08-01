package amazontest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BooksBarTest {
    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeMethod
    public void testBasketButton() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test() {
        WebElement searchDropdown = driver.findElement(By.xpath("//div[contains(@id, 'search-dropdown')]"));
        searchDropdown.click();

        WebElement preferredSection = driver.findElement(By.xpath("//div[contains(@id, 'nav-search-dropdown-card')]//option[6]"));
        preferredSection.click();

        WebElement searchField = driver.findElement(By.xpath("//div[contains(@class, 'search-field')]/input"));
        searchField.clear();
        searchField.sendKeys("Mark Twain");

        WebElement searchSubmitButton = driver.findElement(By.xpath("//input[contains(@id, 'search-submit-button')]"));
        searchSubmitButton.click();

        List<WebElement> elementsPerSearch = driver.findElements(By.xpath("//div[@id = 'search']//div[contains(@class, 's-desktop-content')]//div[contains(@class, 's-card-container')]"));
        int actualCountOfItems = elementsPerSearch.size();

        WebElement searchResults = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));

        String text = searchResults.getText();
        String firstNumber = null;
        String secondNumber = null;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '-') {
                continue;
            } else {
                firstNumber = text.substring(0, i);
                break;
            }
        }
        for (int i = firstNumber.length() + 1; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                continue;
            } else {
                secondNumber = text.substring(firstNumber.length() + 1, i);
                break;
            }
        }
        int expectedCountOfItems = Integer.parseInt(secondNumber) - Integer.parseInt(firstNumber) + 1;
        Assert.assertEquals(expectedCountOfItems, actualCountOfItems);
    }
}
