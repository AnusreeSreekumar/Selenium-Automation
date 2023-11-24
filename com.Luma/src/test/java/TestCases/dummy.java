package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CommonUtils.AddAddress;
import CommonUtils.AddAddress.addressvalues;
import CommonUtils.LaunchBrowser;
import PageObjects.CustomerLogin;
import PageObjects.HomePage;
import PageObjects.MyAccount;
import PageObjects.ProductDetails;
import PageObjects.ShippingAddress;

public class dummy {
	
	private static WebDriver gdriver;
	private LaunchBrowser browser = new LaunchBrowser();
	private AddAddress address = new AddAddress();
	String itemname = null;
	String sizename = null;
	String colorname = null;
	WebElement counterElement = null;
	boolean itemfound = false;
	String prdtname = "Radiant Tee";
	String prdtsize = "M";
	String prdtcolor = "Purple";
	int qnty = 3;
	String stringqty = String.valueOf(qnty);
	
	public static class addressvalues {
		String email = "lumatest3@gmail.com";
//		String fname = "luma3";
//		String lname = "testuser";
//		String address1 = "teststreet01";
//		String address2 = "testaddress01";
//		String address3 = "testaddress02";
//		String city = "testcity";
//		String state_dropdown = "Colorado";
//		String zipcode = "CRD1234";
//		String country_dropdown = "United States";
//		String phoneNumber = "999-7723";
		String pword = "Secure#123";
	}
	
	@Test
	public void setup() {
		gdriver= browser.launchbrowser();
		PageFactory.initElements(gdriver, HomePage.class);
		PageFactory.initElements(gdriver, CustomerLogin.class);
		PageFactory.initElements(gdriver, MyAccount.class);
		PageFactory.initElements(gdriver, ProductDetails.class);
		PageFactory.initElements(gdriver, ShippingAddress.class);
		
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
			WebDriverWait wait = new WebDriverWait(gdriver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ProductDetails.addedtocart));
		}catch(TimeoutException e) {
			System.out.println("Counter value is not refreshed");
		}	
		ProductDetails.showcart.click();
		ProductDetails.checkoutproceed.click();
		
//		address.addshippingaddress(values);
	}
		
}
