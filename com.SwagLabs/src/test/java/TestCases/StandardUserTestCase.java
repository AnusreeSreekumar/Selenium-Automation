package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
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
	List<String> datalist = null;

	public String[][] getlogindata() throws IOException {
		FileInputStream excel = new FileInputStream("E:\\Anusree\\Automation\\Selenium\\Java\\Test Data\\SwagLabs\\LoginCredentials.xls");
		
		HSSFWorkbook workbook = new HSSFWorkbook(excel);
		HSSFSheet sheet = workbook.getSheetAt(0);
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
	
//	public List<String> getprdtname() throws IOException {
//		
//		List<String> columnData = new ArrayList<>();
//		
//		FileInputStream excel = new FileInputStream("E:\\Anusree\\Automation\\Selenium\\Java\\Test Data\\SwagLabs\\LoginCredentials.xls");
//		
//		HSSFWorkbook workbook = new HSSFWorkbook(excel);
//		int columnIndex = 0;
//		HSSFSheet sheet = workbook.getSheetAt(1);
//		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//            HSSFRow row = sheet.getRow(i);
//            if (row != null) {
//                Cell cell = row.getCell(columnIndex);
//                if (cell != null) {
//                    String cellValue = cell.toString();
//                    System.out.println("Data from Excel: " + cellValue);
//                    columnData.add(cellValue);
//                }
//            }
//	  }
//		return columnData;
//	}	
	
	
	@DataProvider(name="loginData")
	public String[][] LoginDataProvider() throws IOException{
		
		data = getlogindata();
		return data;
	}
	
	@DataProvider(name="prdctlist")
	public List<String> productlistProvider() throws IOException {
		
		datalist = getprdtname();
		return datalist;
	}

	@BeforeTest
	public void launchbrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		PageFactory.initElements(driver, LoginPageObjects.class);
	}

	@Test(dataProvider="loginData")
	public void loginuser(String uname, String pword) {
		LoginPageObjects.username.sendKeys(uname);
		LoginPageObjects.password.sendKeys(pword);
		LoginPageObjects.submit.click();
			
	}
	
	@Test(dataProvider="prdctlist")
	public void purchaseorder(List<String> prdtlist) {
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

	@AfterTest
	public void closebrowser() {
		driver.quit();
	}

}
