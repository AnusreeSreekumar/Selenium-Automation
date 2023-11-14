package TestCases;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtils;
import PageObjects.LoginPageObjects;
import PageObjects.PrdtDetailsPage;
import PageObjects.ProductsPage;

public class ProblemUserTestCase {

	public static WebDriver driver;
	private ExcelUtils excelinput = new ExcelUtils();

	
	public String[][] getpurchasedata() throws IOException {

		ClassLoader classLoader = getClass().getClassLoader();
		InputStream excel = classLoader.getResourceAsStream("TestData/InputData.xls");
//		FileInputStream excel = new FileInputStream("TestData.InputData.xls");

		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(excel);
		HSSFSheet sheet = workbook.getSheetAt(1);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int cellcount = sheet.getRow(1).getLastCellNum();
		String purchasedata[][] = new String[rowCount][cellcount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellcount; j++) {
				purchasedata[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return purchasedata;
	}
	
	@DataProvider(name = "logindata")
	public String[][] LoginDataProvider() throws IOException {

		String[][] data = excelinput.getproblemuser();
		return data;
	}

	@DataProvider(name = "inputdata")
	public String[][] TestDataProvider() throws IOException {

		String[][] testdata = excelinput.getpurchasedata();
		return testdata;
	}
	
	@BeforeTest()
	public void launchbrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, LoginPageObjects.class);
		PageFactory.initElements(driver, ProductsPage.class);
		PageFactory.initElements(driver, PrdtDetailsPage.class);		
	}

	@Test(dataProvider="logindata")
	public void loginuser(String uname, String pword) {
		
		LoginPageObjects.username.sendKeys(uname);
		LoginPageObjects.password.sendKeys(pword);
		LoginPageObjects.submit.click();
	}

	@Test(dataProvider="inputdata")
	public void purchaseorder(String prdtname, String fname, String lname, String pstlcode) {		

		for (WebElement itemlist : ProductsPage.itemlists) {
			String itemText = itemlist.getText();
			if (prdtname.equals(itemText)) {
				itemlist.click();
				break;
			}
		}
		String prdt = PrdtDetailsPage.prdt_name.getText();
		if (prdtname != prdt) {
			System.out.println("This is a Problem User");
		}
	}

	@AfterTest
	public void closebrowser() {
		driver.quit();
	}
}
