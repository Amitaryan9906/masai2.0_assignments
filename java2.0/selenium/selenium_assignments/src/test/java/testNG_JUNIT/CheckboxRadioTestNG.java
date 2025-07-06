package testNG_JUNIT;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.DriverUtils;

import org.testng.annotations.*;

public class CheckboxRadioTestNG {

    WebDriver driver;

    @BeforeClass
    public void setup() {
       
        driver = new ChromeDriver();
        String url ="https://rahulshettyacademy.com/AutomationPractice/";
        DriverUtils du = new DriverUtils();
        du.setUp(driver, url);
    }

    @Test(priority = 1)
    public void testSingleCheckbox() {
        WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));
        checkbox1.click();
        assert checkbox1.isSelected();
    }

    @Test(priority = 2)
    public void testMultipleCheckboxes() {
        driver.findElement(By.id("checkBoxOption2")).click();
        driver.findElement(By.id("checkBoxOption3")).click();
    }

    @Test(priority = 3)
    public void testSingleRadioButton() {
        WebElement radio2 = driver.findElement(By.cssSelector("input[value='radio2']"));
        radio2.click();
        assert radio2.isSelected();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
