package swagLab_automation;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*Task 1: UI AUTOMATION TASK

*/

public class SwagLabTest {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	private void setUp() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-blink-features=AutomatioControlled");
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		option.setExperimentalOption("prefs", new java.util.HashMap<String, Object>(){{
			put("credentials_enable_service",false);
			put("profile.password_manager_enabled",false);
			}});
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.get("https://www.saucedemo.com/");
//		Navigate to the URL: https://www.saucedemo.com/
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
	}
	
	@Test
	private void swagTests() {
		
//		Log in using the available username and password from the login page.
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
//		Apply the Price (Low to High) filter from the product sort dropdown.
		WebElement sortDropDown = driver.findElement(By.className("product_sort_container"));
		sortDropDown.sendKeys("lohi");
		
//		Add any two products to the cart.
		List<WebElement> addButtons= driver.findElements(By.xpath("//button[text()='Add to cart']"));
		addButtons.get(0).click();
		addButtons.get(1).click();
		
//		Go to the cart page.
		driver.findElement(By.id("shopping_cart_container")).click();
		
//		Assert and validate the name, description, and price for both selected products in the cart.
		List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		String item1 = cartItems.get(0).getText();
		String item2 = cartItems.get(1).getText();
	
//		Remove one of the two products from the cart.
		List<WebElement> removeBtns = driver.findElements(By.xpath("//button[text()='Remove']"));
		removeBtns.get(0).click();
		
////		Navigate back to the products list page.
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
//		
////		Re-add the previously removed product to the cart.
		WebElement reAdd = driver.findElement(By.xpath("//div[text()='"+item1+"']/ancestor::div[@class='inventory_item']//button"));
		reAdd.click();
//		
////		Return to the cart page & Click on Checkout.
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
////		Enter a random First Name, Last Name, and Zip Code (ensure data is dynamically generated and not hardcoded).
		Random random = new Random();
		driver.findElement(By.id("first-name")).sendKeys("Amit"+random.nextInt(1000));
		driver.findElement(By.id("last-name")).sendKeys("Kumar"+random.nextInt(1000));
		driver.findElement(By.id("postal-=code")).sendKeys("12345");
		driver.findElement(By.id("continue")).click();
//		
////		On the Checkout Overview page, assert and validate the total amount - it should match the sum of the selected product prices.
		String total = driver.findElement(By.className("summary_subtotal_label")).getText();
//		
		Assert.assertTrue(total.contains("39.98"),"Amount not matching...");
//		
////		Click on Finish.
		driver.findElement(By.id("finish")).click();
//	
////		Assert the success message displayed on the final confirmation page.
		Assert.assertTrue(driver.getPageSource().contains("Thank you for your order!"));
//		
////		Click on Back to Home.
		driver.findElement(By.id("back-to-products")).click();
//		
////		Open the menu and log out.
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.id("logout_sidebar_link")).click();
		
		

		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

}
