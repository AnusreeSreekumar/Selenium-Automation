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

import CommonUtils.ExcelRead;
import PageObjects.CreateNew;
import PageObjects.HomePage;

public class CreateResgistration {
	
	public static WebDriver driver;
	private ExcelRead inputexcel = new ExcelRead();
	
	@DataProvider(name = "regndata")
	public String[][] newuser_regn() throws IOException {

		String[][] data = inputexcel.getregndetails();
		return data;
	}
	
	@BeforeTest
	public void launchbrowser() {
		
		driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, CreateNew.class);
	}
	
	@Test(dataProvider="regndata")
	public void newregistration(String fname, String lname, String email, String pword, String cfm_pword) {
		
		HomePage.create_link.click();
		CreateNew.firstname.sendKeys(fname);
		CreateNew.lastname.sendKeys(lname);
		CreateNew.email.sendKeys(email);
		CreateNew.paswrd.sendKeys(pword);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
		        wait.until(ExpectedConditions.visibilityOf(CreateNew.confirmation));
		        String message3 = CreateNew.confirmation.getText();
		        System.out.println(message3);
		        CreateNew.user_dropdown.click();
		        CreateNew.signout.click();
		    }
		}
		
	}

//	@AfterTest
//	public void closebrowser() {
//		
//		driver.close();
//	}
}
