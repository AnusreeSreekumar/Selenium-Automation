package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLogin {
	
	@FindBy(id="email")
	public static WebElement email;
	
	@FindBy(id ="pass")
	public static WebElement password;
	
	@FindBy(id="send2")
	public static WebElement submit;
	
	@FindBy(xpath="//a[@class='action remind']")
	public static WebElement link_forgotpword;
	
	@FindBy(xpath="//a[@class='action create primary']")
	public static WebElement btn_newuser;
	
	@FindBy(xpath="email_address")
	public static WebElement forgot_email;
	
	@FindBy(xpath="//span[contains(text(),'Reset My')]")
	public static WebElement reset_link;
	
	@FindBy(xpath="//div[contains(text(),'The account sign-in was incorrect')]")
	public static WebElement login_error;
}
