package testNG_JUNIT;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class GroupedTests {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1, groups = "checkbox")
    public void testCheckbox1() {
        WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));
        checkbox1.click();
        assert checkbox1.isSelected();
    }

    @Test(priority = 2, groups = "checkbox", dependsOnMethods = "testCheckbox1")
    public void testCheckbox2() {
        WebElement checkbox2 = driver.findElement(By.id("checkBoxOption2"));
        checkbox2.click();
        assert checkbox2.isSelected();
    }

    @Test(priority = 3, groups = "radio")
    public void testRadio1() {
        WebElement radio1 = driver.findElement(By.cssSelector("input[value='radio1']"));
        radio1.click();
        assert radio1.isSelected();
    }

    @Test(priority = 4, groups = "radio")
    public void testRadio2() {
        WebElement radio2 = driver.findElement(By.cssSelector("input[value='radio2']"));
        radio2.click();
        assert radio2.isSelected();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

