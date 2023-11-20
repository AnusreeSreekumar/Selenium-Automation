package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtils.ExcelRead_Logindtls;
import CommonUtils.LaunchBrowser;
import PageObjects.CustomerLogin;
import PageObjects.HomePage;
import PageObjects.MyAccount;

public class ExistingUserLogin {
	
	private static WebDriver gdriver;
	private LaunchBrowser browser = new LaunchBrowser();
	private ExcelRead_Logindtls inputexcel = new ExcelRead_Logindtls();
	
	@DataProvider(name="logindetails")
	public String[][] existinguser() throws IOException{
		String[][] logindata = inputexcel.getlogindetails();
		return logindata;
	}
	
	@BeforeTest
	public void setup() {
		gdriver= browser.launchbrowser();
		PageFactory.initElements(gdriver, HomePage.class);
		PageFactory.initElements(gdriver, CustomerLogin.class);
		PageFactory.initElements(gdriver, MyAccount.class);
	}
	
	@Test(dataProvider = "logindetails")
	public void userlogin(String email, String pasword) {
		
		HomePage.sign_link.click();
		CustomerLogin.email.sendKeys(email);
		CustomerLogin.password.sendKeys(pasword);
		CustomerLogin.submit.click();
		WebDriverWait wait = new WebDriverWait(gdriver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOf(MyAccount.user_dropdown));
			System.out.println("User logged in successfully");
			MyAccount.user_dropdown.click();
			MyAccount.signout.click();
		}catch(TimeoutException e) {
			//wait.until(ExpectedConditions.stalenessOf(CustomerLogin.password));
			if(CustomerLogin.incorrect_message.isDisplayed()) {
				CustomerLogin.link_forgotpword.click();
				CustomerLogin.forgot_email.sendKeys(email);
				CustomerLogin.reset_link.click();
				wait.until(ExpectedConditions.visibilityOf(CustomerLogin.reset_confmtn));
				String message1 = CustomerLogin.reset_confmtn.getText();
				System.out.println(message1);
			}			
		}		
	}
	
//	@AfterTest
//	public void closebrowser() {
//		
//		driver.close();
//	}
}
