package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.LoginPageObjects;
import PageObjects.PersonalInfo;
import PageObjects.PrdtDetailsPage;
import PageObjects.ProductsPage;

public class StandardUserTestCase {

	public static WebDriver driver;
	String[][] data = null;
	boolean itemFound = false;

	public String[][] getlogindata() throws IOException {
		FileInputStream excel = new FileInputStream("E:\\Anusree\\Automation\\Selenium\\Java\\Test Data\\SwagLabs\\InputData.xls");
		
		HSSFWorkbook workbook = new HSSFWorkbook(excel);
		HSSFSheet sheet = workbook.getSheetAt(1);
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		int cellcount=sheet.getRow(1).getLastCellNum();
		String testdata[][] = new String[rowCount][cellcount];
		for (int i = 0; i < rowCount; i++) {
	        for (int j = 0; j < cellcount; j++) {
	            testdata[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
	        }
	    }
	    return testdata;
	}
	
	@DataProvider(name="inputdata")
	public String[][] LoginDataProvider() throws IOException{
		
		data = getlogindata();
		return data;
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

	@Test(dataProvider="inputdata")
	public void loginuser(String uname, String pword, String prdtname, String fname, String lname, String pstlcode) throws InterruptedException {
		LoginPageObjects.username.sendKeys(uname);
		LoginPageObjects.password.sendKeys(pword);
		LoginPageObjects.submit.click();
		
		for(WebElement itemlist : ProductsPage.itemlists){
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
		if(prdtname.equals(itemname)) {
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
		
		System.out.println(CheckoutPage.message1.getText());
		System.out.println(CheckoutPage.message2.getText());
		
//		CheckoutPage.homepage.click();
	}

	@AfterTest
	public void closebrowser() {
		driver.quit();
	}

}
