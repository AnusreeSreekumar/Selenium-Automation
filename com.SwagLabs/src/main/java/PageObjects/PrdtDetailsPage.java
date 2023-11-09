package PageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class PrdtDetailsPage {

	@FindBy(xpath="//div[@class='inventory_details_name large_size']")
	public static WebElement prdt_name;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	public static WebElement prdt_addtocart;
	
//	@FindBy(xpath="//a[@class='shopping_cart_link']")
//	public static WebElement cart;
}
