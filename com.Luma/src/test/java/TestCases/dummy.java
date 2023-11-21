package TestCases;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CommonUtils.LaunchBrowser;
import PageObjects.CustomerLogin;
import PageObjects.HomePage;
import PageObjects.MyAccount;
import PageObjects.ProductDetails;

public class dummy {
	
	private static WebDriver gdriver;
	private LaunchBrowser browser = new LaunchBrowser();
	String itemname = null;
	String sizename = null;
	String colorname = null;
	boolean itemfound = false;
	String prdtname = "Radiant Tee";
	String prdtsize = "M";
	String prdtcolor = "Purple";
	
	@Test
	public void setup() {
		gdriver= browser.launchbrowser();
		PageFactory.initElements(gdriver, HomePage.class);
		PageFactory.initElements(gdriver, CustomerLogin.class);
		PageFactory.initElements(gdriver, MyAccount.class);
		for(WebElement itemlist: HomePage.prdt_name) {
			itemname = itemlist.getText();
			if(prdtname.equals(itemname)) {
				itemlist.click();
				itemfound = true;
				System.out.println(itemname);
				WebDriverWait wait = new WebDriverWait(gdriver, Duration.ofSeconds(30));
				 try {
			            wait.until(ExpectedConditions.visibilityOf(ProductDetails.productName));
			     } catch (TimeoutException e) {
			            // Handle timeout or log an error if the element is not found
			            System.out.println("Product name element not found within the specified time.");
			            e.printStackTrace();
			     }
				 if (ProductDetails.productName != null && ProductDetails.productName.isDisplayed()) {
			            break;
			     } else {
			            System.out.println("Product name element is null or not displayed.");
			     }
			}
		}
//		System.out.println("Hi");
//		String prdt = ProductDetails.productName.getText();
//		System.out.println(prdt);
//		if(prdtname.equals(prdt)) {
//			for(WebElement sizelist: ProductDetails.productSize) {
//				sizename = sizelist.getText();
//				if(prdtsize.equals(sizename)) {
//					sizelist.click();
//				}
//			}
//			for(WebElement colorlist: ProductDetails.productColor) {
//				colorname = colorlist.getText();
//				if(prdtcolor.equals(colorname)) {
//					colorlist.click();
//				}
//			}
//		}
		
	}
}
