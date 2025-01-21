import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DJDTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String browser = System.getProperty("browser");
        switch (browser) {
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                // The name of the Docker selenium hub service is used as the hostname in the URL to access the Selenium Grid Hub
                driver = new ChromeDriver(options);
                break;
            case "Edge":
                EdgeOptions options2 = new EdgeOptions();
                // The name of the Docker selenium hub service is used as the hostname in the URL to access the Selenium Grid Hub
                driver = new EdgeDriver(options2);
                break;
            case "Firefox":
                FirefoxOptions options3 = new FirefoxOptions();
                // The name of the Docker selenium hub service is used as the hostname in the URL to access the Selenium Grid Hub
                driver = new FirefoxDriver(options3);
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
    }

    @Test
    public void testMethod() {
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("I JUST RAN ON: " + System.getProperty("browser").toUpperCase());
    }
}
