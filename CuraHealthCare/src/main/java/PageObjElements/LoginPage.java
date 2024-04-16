package PageObjElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id="btn-make-appointment")
	public static WebElement makeappointment;
	
	@FindBy(id = "txt-username")
	public static WebElement username;
	
	@FindBy(id = "txt-password")
	public static WebElement password;
	
	@FindBy(id = "btn-login")
	public static WebElement loginbtn;
	
	}
	

