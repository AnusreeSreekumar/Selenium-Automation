package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingAddress {
	
	private static WebDriver gdriver;
	
	public ShippingAddress(WebDriver driver) {
		this.gdriver = driver;
	}

	@FindBy(id="customer-email")
	public static WebElement ctmremail;
	
	@FindBy(id="customer-password")
	public static WebElement ctmrpword;
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	public static WebElement loginbtn;
	
	@FindBy(name="firstname")
	public static WebElement ctmrfirstname;
	
	@FindBy(name="lastname")
	public static WebElement ctmrlastname;
	
	@FindBy(name="company")
	public static WebElement ctmrcompany;
	
	@FindBy(id="V8PK4CF")
	public static WebElement address1;
	
	@FindBy(id="M8DKJWQ")
	public static WebElement address2;
	
	@FindBy(id="DX48D3U")
	public static WebElement address3;
	
	@FindBy(id="UV6OAQC")
	public static WebElement city;
	
	@FindBy(id="FOR1OEN")
	public static WebElement state_dropdown;
	
	@FindBy(id="LUYHWSO")
	public static WebElement zipcode;
	
	@FindBy(id="ANRV0BP")
	public static WebElement country_dropdown;
	
	@FindBy(id="D635W23")
	public static WebElement phoneNumber;
	
	@FindBy(name="ko_unique_1")
	public static WebElement shipmethod_radio1;
	
	@FindBy(name="ko_unique_2")
	public static WebElement shipmethod_radio2;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	public static WebElement nextbutton;
	
	@FindBy(xpath="//*[@id=\"checkout\"]/div[1]/button/span")
	public static WebElement signInbutton;
	
	@FindBy(id="login-email")
	public static WebElement email;
	
	@FindBy(id="login-password")
	public static WebElement pword;
	
	@FindBy(xpath="//*[@id=\"modal-content-7\"]/div/div/div[3]/form/div[2]/div[1]/button")
	public static WebElement submit;
	
}
