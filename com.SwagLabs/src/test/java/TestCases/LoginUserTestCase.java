package TestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;

public class LoginUserTestCase {

	public static WebDriver driver;
	String[][] data = null;

	public String[][] getExceldata() throws IOException {
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
	
	@DataProvider(name="loginData")
	public String[][] LoginDataProvider() throws IOException{
		
		data = getExceldata();
		return data;
		
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

	@AfterTest
	public void closebrowser() {
		driver.quit();
	}

}
