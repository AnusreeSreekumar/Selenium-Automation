package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNew {
		
	@FindBy(id="firstname")
	public static WebElement firstname;
	
	@FindBy(id="lastname")
	public static WebElement lastname;
	
	@FindBy(id="email_address")
	public static WebElement email;
	
	@FindBy(id="password")
	public static WebElement paswrd;
	
	@FindBy(id="password-confirmation")
	public static WebElement paswrd_confirm;
	
	@FindBy(id="password-error")
	public static WebElement weak_paswrd;
	
	@FindBy(xpath="//button[@title='Create an Account']")
	public static WebElement submit;
	
	@FindBy(xpath="//*[contains(text(),'Thank you for registering with Main Website Store.')]")
	public static WebElement confirmation;
	
	@FindBy(xpath="//*[contains(text(),'There is already an account with this email')]")
	public static WebElement existinguser;
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button/span")
	public static WebElement user_dropdown;
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
	public static WebElement signout;
	
}
