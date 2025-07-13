package amazonAutomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import com.aventstack.extentreports.*;
import utils.ExtentReportManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchTest {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setupReport() {
        extent = ExtentReportManager.getReport();
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test(groups = "SmokeTest")
    public void searchLaptop() {
        test = extent.createTest("Search Laptop on Amazon").assignCategory("SmokeTest");

        try {
            test.info("Navigating to Amazon");
            driver.get("https://www.amazon.com");
            
            WebElement continueBtn = driver.findElement(By.xpath("//button[contains(text(),'Continue shopping')]"));
            continueBtn.click();

            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("Laptop");
            driver.findElement(By.id("nav-search-submit-button")).click();

            test.info("Searching for 'Laptop'");

            String actualTitle = driver.getTitle();
            assertTrue(actualTitle.contains("Laptop"), "Page title does not contain 'Laptop'");
            test.pass("Page title contains 'Laptop': " + actualTitle);

            List<WebElement> results = driver.findElements(By.cssSelector(".s-result-item"));
            new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.titleContains("Laptop"));

            assertNotNull(results, "Search results list is null");
            assertTrue(results.size() > 0, "No results found!");
            test.pass("Search results found: " + results.size());

        } catch (Exception e) {
            test.fail("Test failed due to: " + e.getMessage());
            test.addScreenCaptureFromPath(takeScreenshot("laptopSearchFail"));
            fail("Test Failed");
        }
    }


    public String takeScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = "test-output/screenshots/" + name + ".png";
        try {
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public void flushReport() {
    	try {
    	    extent.flush();
    	    System.out.println("Report flushed successfully.");
    	} catch (Exception e) {
    	    System.out.println("Report failed: " + e.getMessage());
    	}

    }
}
