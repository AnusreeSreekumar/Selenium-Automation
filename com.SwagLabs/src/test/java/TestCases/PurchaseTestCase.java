package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.LoginPageObjects;
import PageObjects.PersonalInfo;
import PageObjects.PrdtDetailsPage;
import PageObjects.ProductsPage;

public class PurchaseTestCase {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void launchbrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
	}
	
	@Test
	public void loginuser() {
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.username.sendKeys("standard_user");
		LoginPageObjects.password.sendKeys("secret_sauce");
		LoginPageObjects.submit.click();
	}
	
	
	
	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}
	
}
