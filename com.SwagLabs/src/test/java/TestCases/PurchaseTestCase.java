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
	
	@Test
	public void purchaseorder() {
		PageFactory.initElements(driver, ProductsPage.class);
		PageFactory.initElements(driver, PrdtDetailsPage.class);
		PageFactory.initElements(driver, CartPage.class);
		PageFactory.initElements(driver, PersonalInfo.class);
		PageFactory.initElements(driver, CheckoutPage.class);
		
		ProductsPage.backpack.click();
		PrdtDetailsPage.prdt_name.click();
		PrdtDetailsPage.prdt_addtocart.click();
		CartPage.checkoutbtn.click();
		PersonalInfo.firstname.sendKeys("testuser1");
		PersonalInfo.lastname.sendKeys("user123");
		PersonalInfo.postalcode.sendKeys("562348");
		PersonalInfo.contbtn.click();
		CheckoutPage.finishbtn.click();
		
		System.out.println(CheckoutPage.message1.getText());
		System.out.println(CheckoutPage.message2.getText());
	}
	
	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}
	
}
