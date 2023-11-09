package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import PageObjects.PrdtDetailsPage;
import PageObjects.ProductsPage;
import PageObjects.LoginPageObjects;

public class ProblemUserTestCase {

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
		LoginPageObjects.username.sendKeys("problem_user");
		LoginPageObjects.password.sendKeys("secret_sauce");
		LoginPageObjects.submit.click();
	}

	@Test
	public void purchaseorder() {
		PageFactory.initElements(driver, ProductsPage.class);
		PageFactory.initElements(driver, PrdtDetailsPage.class);

		String prdtname = ProductsPage.backpack.getText();
		ProductsPage.backpack.click();
		String prdt = PrdtDetailsPage.prdt_name.getText();
		if (prdt != prdtname) {
			System.out.println("This is a Problem User");
		}
	}

	@AfterSuite
	public void closebrowser() {
		driver.quit();
	}
}
