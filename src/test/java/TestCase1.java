import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This will execute before any method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This will execute after any method");
    }

    @Test
    public void Test1() {
        System.out.println("First test");
    }

    @Test
    public void Test2() {
        System.out.println("Second test");
    }

    @Test
    public void Test3() {
        System.out.println("Third test");
    }
}
