package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtils;
import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.LoginPageObjects;
import PageObjects.PersonalInfo;
import PageObjects.PrdtDetailsPage;
import PageObjects.ProductsPage;

public class StandardUserTestCase {

	public static WebDriver driver;
	boolean itemFound = false;
	private ExcelUtils inputexcel = new ExcelUtils();

	@DataProvider(name = "logindata")
	public String[][] LoginDataProvider() throws IOException {

		String[][] data = inputexcel.getlogindata();
		return data;
	}

	@DataProvider(name = "inputdata")
	public String[][] TestDataProvider() throws IOException {

		String[][] testdata = inputexcel.getpurchasedata();
		return testdata;
	}

	@BeforeTest
	public void launchbrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, LoginPageObjects.class);
		PageFactory.initElements(driver, ProductsPage.class);
		PageFactory.initElements(driver, PrdtDetailsPage.class);
		PageFactory.initElements(driver, CartPage.class);
		PageFactory.initElements(driver, PersonalInfo.class);
		PageFactory.initElements(driver, CheckoutPage.class);
	}

	@Test(dataProvider = "logindata")
	public void loginuser(String uname, String pword) throws InterruptedException {
		LoginPageObjects.username.sendKeys(uname);
		LoginPageObjects.password.sendKeys(pword);
		LoginPageObjects.submit.click();

	}

	@Test(dataProvider = "inputdata")
	public void purchaseproduct(String prdtname, String fname, String lname, String pstlcode) throws IOException {

		for (WebElement itemlist : ProductsPage.itemlists) {
			String itemText = itemlist.getText();
			if (prdtname.equals(itemText)) {
				itemlist.click();
				itemFound = true;
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(PrdtDetailsPage.prdt_name));
				break;
			}
		}

		String itemname = PrdtDetailsPage.prdt_name.getText();
		System.out.println("Item name after click: " + itemname);
		if (prdtname.equals(itemname)) {
			PrdtDetailsPage.addtocart.click();
			PrdtDetailsPage.cart.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(CartPage.checkoutbtn));
		}

		CartPage.checkoutbtn.click();
		PersonalInfo.firstname.sendKeys(fname);
		PersonalInfo.lastname.sendKeys(lname);
		PersonalInfo.postalcode.sendKeys(pstlcode);
		PersonalInfo.contbtn.click();
		CheckoutPage.finishbtn.click();

		String message1 = CheckoutPage.message1.getText();
		String message2 = CheckoutPage.message2.getText();

		CheckoutPage.homepage.click();
		System.out.println(message1);
		System.out.println(message2);
		//writeDataToExcel(prdtname, message1, message2);
	}

	@AfterTest
	public void closebrowser() {
		driver.close();

		// Reset WebDriver state
		driver.quit();
		driver = null;
	}

}
