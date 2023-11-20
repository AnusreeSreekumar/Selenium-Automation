package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount {
	
	@FindBy(xpath="//*[contains(text(),'Thank you for registering with Main Website Store.')]")
	public static WebElement confirmation;
	
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	public static WebElement account;
		
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
	public static WebElement user_dropdown;
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
	public static WebElement signout;

}
