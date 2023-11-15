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
	
	@FindBy(id="//button[@type='submit' and @title='Create an Account']")
	public static WebElement submit;
}
