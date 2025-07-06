package waits;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.DriverUtils;

public class SnapdealJSExecutor {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        DriverUtils du = new DriverUtils();
    	String url = "https://www.snapdeal.com";
    	du.setUp(driver, url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //  Wait for search box
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputValEnter")));

        //  Use JavaScriptExecutor to enter text
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='Laptop';", searchBox);

        //  Locate and click Search button using JS
        WebElement searchBtn = driver.findElement(By.cssSelector(".searchformButton.col-xs-4.rippleGrey"));
        js.executeScript("arguments[0].click();", searchBtn);

        // Optional wait for results
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-tuple-image")));

        driver.quit();
    }
}

