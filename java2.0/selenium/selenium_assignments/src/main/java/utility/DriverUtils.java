package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils{
public void setUp(WebDriver driver,String url) {
	 WebDriverManager.chromedriver().setup();
     driver.manage().window().maximize();

     //  Implicit Wait
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get(url);
}
}