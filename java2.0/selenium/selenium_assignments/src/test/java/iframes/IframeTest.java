package iframes;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://v1.training-support.net/selenium/iframes");

        // Switch to first iframe and click button
        driver.switchTo().frame(0);
        WebElement btn1 = driver.findElement(By.xpath("//button[@id='actionButton']"));
        System.out.println("Button Text in Frame 1: " + btn1.getText());
        btn1.click();

        // Switch back to main content
        driver.switchTo().defaultContent();

        // Switch to second iframe and click button
        driver.switchTo().frame(1);
        WebElement btn2 = driver.findElement(By.xpath("//button[@id='actionButton']"));
        System.out.println("Button Text in Frame 2: " + btn2.getText());
        btn2.click();

//        // Back to main content and click Back Button
        driver.switchTo().defaultContent();
        WebElement backBtn = driver.findElement(By.xpath("//button[@class='ui huge green icon button']"));
        backBtn.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
