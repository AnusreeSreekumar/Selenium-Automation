package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
	
	@FindBy(id="finish")
	public static WebElement finishbtn;
	
	@FindBy(id="cancel")
	public static WebElement cancelbtn;
	
	@FindBy(xpath="//h2[@class='complete-header' and contains(text(), 'Thank you')]")
	public static WebElement message1;
	
	@FindBy(xpath="//div[@class='complete-text' and contains(text(), 'order has been dispatched')]")
	public static WebElement message2;
	
	@FindBy(id="back-to-products")
	public static WebElement homepage;	

}
