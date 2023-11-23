package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails {

	@FindBy(xpath="//span[@data-ui-id='page-title-wrapper']")
	public static WebElement productName;
	
	@FindBy(xpath="//div[@class='swatch-option text']")
	public static List<WebElement> productSize;
	
	@FindBy(xpath="//div[@class='swatch-option color']")
	public static List<WebElement> productColor;
	
	@FindBy(id="qty")
	public static WebElement quantity;
	
	@FindBy(id="product-addtocart-button")
	public static WebElement addtocart;
	
	@FindBy(xpath="//span[@class='counter-number']")
	public static WebElement counter;
	
	@FindBy(xpath="//a[@class='action showcart']")
	public static WebElement showcart;
	
	@FindBy(id="top-cart-btn-checkout")
	public static WebElement checkoutproceed;
	
}
