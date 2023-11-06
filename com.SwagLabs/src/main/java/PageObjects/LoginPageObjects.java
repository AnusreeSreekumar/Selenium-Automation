package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	
	@FindBy(id="user-name")
	public static WebElement username;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(id="login-button")
	public static WebElement submit;
	
	@FindBy(xpath="//*[starts-with(text(), 'Epic sadface')]")
	public static WebElement lockedmessage;
	
	

}
