package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {
	
	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	public static List<WebElement> itemlists;
	
	@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
	public static WebElement addtocart;
	
	@FindBy(xpath = "//div[@class='inventory_item_name ' and text()='Sauce Labs Bolt T-Shirt']")
	public static WebElement tshirt;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	public static WebElement tshirt_addtocart;
	
	@FindBy(xpath = "//div[@class='inventory_item_name ' and text()='Sauce Labs Onesie']")
	public static WebElement onesie;
	
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	public static WebElement onesie_addtocart;
	
	@FindBy(xpath = "//div[@class='inventory_item_name ' and text()='Sauce Labs Bike Light']")
	public static WebElement bikelight;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	public static WebElement bikelight_addtocart;
		
	@FindBy(xpath = "//div[@class='inventory_item_name ' and text()='Sauce Labs Fleece Jacket']")
	public static WebElement jacket;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	public static WebElement jacket_addtocart;
	
	@FindBy(xpath = "//div[@class='inventory_item_name ' and contains(text(),'T-Shirt (Red)')]")
	public static WebElement redtshirt;
	
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	public static WebElement redshirt_addtocart;
	
}