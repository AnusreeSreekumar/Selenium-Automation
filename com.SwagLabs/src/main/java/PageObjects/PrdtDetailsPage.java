package PageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class PrdtDetailsPage {

	@FindBy(xpath="//div[@class='inventory_details_name large_size' and text()='Sauce Labs Backpack']")
	public static WebElement item_backpack;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	public static WebElement backpack_addtocart;
	
	@FindBy(xpath = "//div[@class='inventory_details_name large_size' and contains(text(),'Bolt T-Shirt')]")
	public static WebElement item_tshirt;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	public static WebElement tshirt_addtocart;
	
	@FindBy(xpath = "//div[@class='inventory_details_name large_size' and contains(text(),'Onesie')]")
	public static WebElement item_onesie;
	
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	public static WebElement onesie_addtocart;
	
	@FindBy(xpath = "//div[@class='inventory_details_name large_size' and contains(text(),'Bike Light')]")
	public static WebElement item_bikelight;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	public static WebElement bikelight_addtocart;
		
	@FindBy(xpath = "//div[@class='inventory_details_name large_size' and contains(text(),'Jacket')]")
	public static WebElement item_jacket;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	public static WebElement jacket_addtocart;
	
	@FindBy(xpath = "//div[@class='inventory_details_name large_size' and contains(text(),'T-Shirt (Red)')]")
	public static WebElement item_redtshirt;
	
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	public static WebElement redshirt_addtocart;

	@FindBy(xpath="//a[@class='shopping_cart_link']")
	public static WebElement cart;
}
