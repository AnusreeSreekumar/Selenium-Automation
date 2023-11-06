package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfo {
	
	@FindBy(id="first-name")
	public static WebElement firstname;
	
	@FindBy(id="last-name")
	public static WebElement lastname;
	
	@FindBy(id="postal-code")
	public static WebElement postalcode;
	
	@FindBy(id="continue")
	public static WebElement contbtn;
	
	@FindBy(id="cancel")
	public static WebElement cancelbtn;
}
