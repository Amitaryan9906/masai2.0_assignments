package form;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class NewTabAndLogin {
    public static void main(String[] args) throws InterruptedException  {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        // Click on Elemental Selenium link (opens in new tab)
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Thread.sleep(2000);

        // Switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Enter Email and Select Python
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("test@example.com");
//
        WebElement dropdown = driver.findElement(By.name("language"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Python");
//
        driver.findElement(By.xpath("//button")).click(); // Click Join button
        Thread.sleep(2000);

        // Switch back to original tab (Login Page)
        driver.switchTo().window(tabs.get(0));
//
//        // Enter credentials
       driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
;
//
        Thread.sleep(2000);
        driver.quit();
    }
}
