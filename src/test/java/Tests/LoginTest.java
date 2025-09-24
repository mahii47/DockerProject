package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // 
        options.addArguments("--no-sandbox"); // Required for Docker
        options.addArguments("--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
     //   driver = new ChromeDriver();
     //   driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void testLogin() {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        System.out.println("Docker & Jenkins is Working fine");
        WebElement message = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(message.getText(), "Logged In Successfully");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
