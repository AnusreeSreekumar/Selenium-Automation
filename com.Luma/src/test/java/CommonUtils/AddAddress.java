package CommonUtils;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v115.browser.Browser;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.ProductDetails;
import PageObjects.ShippingAddress;

public class AddAddress {
	
	private static WebDriver driver;
	private static LaunchBrowser browser = new LaunchBrowser();
	ShippingAddress address = new ShippingAddress(driver);
	
	
	
	public static void addshippingaddress(addressvalues param) {

		PageFactory.initElements(driver, ShippingAddress.class);

		ShippingAddress.ctmremail.sendKeys(param.email);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ShippingAddress.ctmrpword));
			ShippingAddress.ctmrpword.sendKeys(param.pword);
			ShippingAddress.loginbtn.click();

			wait.until(ExpectedConditions.visibilityOf(ShippingAddress.ctmrfirstname));
		} catch (TimeoutException e) {
			System.out.println("Timeout exception occurred");
		}
		String fname = ShippingAddress.ctmrfirstname.getAttribute("value");
		System.out.println(fname);

		// ShippingAddress.ctmremail.sendKeys(null);

	}
}
