package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
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
	int qnty = 3;
	String stringqty = String.valueOf(qnty);
	
	@Test
	public void setup() {
		gdriver= browser.launchbrowser();
		PageFactory.initElements(gdriver, HomePage.class);
		PageFactory.initElements(gdriver, CustomerLogin.class);
		PageFactory.initElements(gdriver, MyAccount.class);
		PageFactory.initElements(gdriver, ProductDetails.class);
		for(WebElement itemlist: HomePage.prdt_name) {
			itemname = itemlist.getText();
			if(prdtname.equals(itemname)) {
				itemlist.click();
				itemfound = true;
				WebDriverWait wait = new WebDriverWait(gdriver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.visibilityOf(ProductDetails.productName));
				break;
			}
		}
		String prdt = ProductDetails.productName.getText();
		if(prdtname.equals(prdt)) {
			for(WebElement sizelist: ProductDetails.productSize) {
				sizename = sizelist.getText();
				if(prdtsize.equals(sizename)) {
					sizelist.click();
				}
			}
			for(WebElement colorlist: ProductDetails.productColor) {
				colorname = colorlist.getAttribute("aria-label");
				if(prdtcolor.equals(colorname)) {
					colorlist.click();
				}
			}
		}
		ProductDetails.quantity.clear();
		ProductDetails.quantity.sendKeys(stringqty);
		ProductDetails.addtocart.click();
		try {
			WebDriverWait wait = new WebDriverWait(gdriver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.visibilityOf(ProductDetails.counter));
		}catch(TimeoutException e) {
			System.out.println("Quantity is not loaded");
	    }
		ProductDetails.showcart.click();
		ProductDetails.checkoutproceed.click();
	}
		
}
