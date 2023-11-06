package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
	
	@FindBy(id="remove-sauce-labs-bike-light")
	public static WebElement removebtn;
	
	@FindBy(id="continue-shopping")
	public static WebElement coninuebtn;
	
	@FindBy(id="checkout")
	public static WebElement checkoutbtn;
		
}
