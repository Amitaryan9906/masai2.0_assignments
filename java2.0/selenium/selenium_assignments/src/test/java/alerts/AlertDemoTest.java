package alerts;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemoTest {

    public static void main(String[] args) throws InterruptedException {
  
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

        // 1. Simple Alert
        WebElement simpleAlertBtn = driver.findElement(By.id("alertBox"));
        simpleAlertBtn.click();

        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        simpleAlert.accept(); // Click OK

        // 2. Confirm Alert
        WebElement confirmAlertBtn = driver.findElement(By.id("confirmBox"));
        confirmAlertBtn.click();

        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirm Alert Text: " + confirmAlert.getText());
        confirmAlert.dismiss(); // Click Cancel

        // 3. Prompt Alert
        WebElement promptAlertBtn = driver.findElement(By.id("promptBox"));
        promptAlertBtn.click();

        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Alert Text: " + promptAlert.getText());
        promptAlert.sendKeys("Amit");
        Thread.sleep(1000); // Just to see input
        promptAlert.accept(); // Click OK

        Thread.sleep(2000);
        driver.quit();
    }
}
