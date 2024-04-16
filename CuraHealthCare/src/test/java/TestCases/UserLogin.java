package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjElements.LoginPage;

public class UserLogin extends CommonUtils {
		
	private static final boolean True = false;

	@Test(singleThreaded = True)
	public static void LoginPageElements() throws InterruptedException{	
		
		PageFactory.initElements(driver, LoginPage.class);
		
		LoginPage.makeappointment.click();
		Thread.sleep(3000);
		
		LoginPage.username.sendKeys("John Doe");
		LoginPage.password.sendKeys("ThisIsNotAPassword");
		LoginPage.loginbtn.click();
   }

}