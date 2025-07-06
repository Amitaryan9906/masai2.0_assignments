package testNG_JUNIT;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.DriverUtils;

public class CheckboxRadioJUnit {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        DriverUtils du = new DriverUtils();
        String url= "https://rahulshettyacademy.com/AutomationPractice/";
		du.setUp(driver, url);
    }

    @Test
    public void testSingleCheckbox() {
        WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
    }

    @Test
    public void testMultipleCheckboxes() {
        driver.findElement(By.id("checkBoxOption2")).click();
        driver.findElement(By.id("checkBoxOption3")).click();
    }

    @Test
    public void testSingleRadioButton() {
        WebElement radio1 = driver.findElement(By.cssSelector("input[value='radio1']"));
        radio1.click();
        Assert.assertTrue(radio1.isSelected());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
