package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtils.ExcelRead_Regndtls;
import CommonUtils.LaunchBrowser;
import PageObjects.CreateNew;
import PageObjects.HomePage;
import PageObjects.MyAccount;

public class CreateResgistration {
	
	private static WebDriver gdriver;
	private LaunchBrowser browser = new LaunchBrowser();
	private ExcelRead_Regndtls inputexcel = new ExcelRead_Regndtls();
	
	@DataProvider(name = "regndata")
	public String[][] newuser_regn() throws IOException {

		String[][] data = inputexcel.getregndetails();
		return data;
	}
	
	@BeforeTest
	public void setup() {
		gdriver= browser.launchbrowser();
		PageFactory.initElements(gdriver, HomePage.class);
		PageFactory.initElements(gdriver, CreateNew.class);
		PageFactory.initElements(gdriver, MyAccount.class);
	}
	
	@Test(dataProvider="regndata")
	public void newregistration(String fname, String lname, String email, String pword, String cfm_pword) {
		
		HomePage.create_link.click();
		CreateNew.firstname.sendKeys(fname);
		CreateNew.lastname.sendKeys(lname);
		CreateNew.email.sendKeys(email);
		CreateNew.paswrd.sendKeys(pword);
		WebDriverWait wait = new WebDriverWait(gdriver, Duration.ofSeconds(20));
		if(CreateNew.weak_paswrd.isDisplayed()) {			
			String message1 = CreateNew.weak_paswrd.getText();
			System.out.println(message1);
		}
		else {			
			CreateNew.paswrd_confirm.sendKeys(cfm_pword);
			CreateNew.submit.click();
			try {
		        wait.until(ExpectedConditions.visibilityOf(CreateNew.existinguser));
		        String message2 = CreateNew.existinguser.getText();
		        System.out.println(message2);
		    } catch (TimeoutException e) {
		        // If the existing user element is not found, proceed with the next steps
		        wait.until(ExpectedConditions.visibilityOf(MyAccount.confirmation));
		        String message3 = MyAccount.confirmation.getText();
		        System.out.println(message3);
		        MyAccount.user_dropdown.click();
		        MyAccount.signout.click();
		    }
		}
		
	}

//	@AfterTest
//	public void closebrowser() {
//		
//		driver.close();
//	}
}
