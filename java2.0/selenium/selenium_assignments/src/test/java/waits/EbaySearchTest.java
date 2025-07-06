package waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import utility.DriverUtils;

import java.net.URL;
import java.time.Duration;

public class EbaySearchTest {

    public static void main(String[] args) throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
    	DriverUtils du = new DriverUtils();
    	String url = "https://www.ebay.com";
    	du.setUp(driver, url);

        //  Explicit Wait for Search Box
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));

        searchBox.sendKeys("Shoes");
        driver.findElement(By.xpath("//span[@class='gh-search-button__label']")).click();

        //  Scroll down using JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);

        //  Scroll back up
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(1000);

        //  Clear the search box
        WebElement searchAgain = driver.findElement(By.id("gh-ac"));
        searchAgain.clear();

        Thread.sleep(2000);
        driver.quit();
    }
}
