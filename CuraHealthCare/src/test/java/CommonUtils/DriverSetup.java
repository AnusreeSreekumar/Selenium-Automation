package CommonUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverSetup {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		
		driver.get("https://katalon-demo-cura.herokuapp.com/");
	}
	
//	@AfterClass
//	 public void tearDown() {
//        // Close the WebDriver instance
//        if (driver != null) {
//            driver.quit();
//        }
//	}
}
