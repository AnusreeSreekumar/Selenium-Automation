package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;

public class LoginTestCase {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void launchbrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		PageFactory.initElements(driver, LoginPageObjects.class);
	}
	
	@Test
	public void loginuser() {
		LoginPageObjects.username.sendKeys("standard_user");
		LoginPageObjects.password.sendKeys("secret_sauce");
		LoginPageObjects.submit.click();
	}
	
	public void lockeduser() {
		LoginPageObjects.username.sendKeys("locked_out_user");
		LoginPageObjects.password.sendKeys("secret_sauce");
		LoginPageObjects.submit.click();
		System.out.println(LoginPageObjects.lockedmessage.getText());
	}
		
	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}

}
