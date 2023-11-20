package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
	public static WebElement create_link;
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
	public static WebElement sign_link;
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[1]/span/html/body/div[2]/header/div[1]/div/ul/li[1]/span")
	public static WebElement welcome_link;
	
	@FindBy(id="search")
	public static WebElement search_text;
	
	@FindBy(id="ui-id-3")
	public static WebElement link_new;
	
	@FindBy(id="ui-id-4")
	public static WebElement link_women;
	
	@FindBy(id="ui-id-5")
	public static WebElement link_men;
	
	@FindBy(id="ui-id-6")
	public static WebElement link_gear;
	
	@FindBy(id="ui-id-7")
	public static WebElement link_training;
	
	@FindBy(id="ui-id-8")
	public static WebElement link_sale;
	
	@FindBy(xpath="//a[@class='block-promo home-main']")
	public static WebElement image_yogacolxn;
	
	@FindBy(xpath="//span[contains(text(),'New Yoga')]")
	public static WebElement link_newyoga;
	
	@FindBy(xpath="//a[@class='block-promo home-pants']")
	public static WebElement image_lumapants;
	
	@FindBy(xpath="//strong[contains(text(), '20% OFF')]")
	public static WebElement link_Offtext;
	
	@FindBy(xpath="//span[contains(text(), 'Buy 3 Luma')]")
	public static WebElement link_teestext;
	
	@FindBy(xpath="//span[contains(text(), 'Shop Erin')]")
	public static WebElement link_Erinrecommends;
	
	@FindBy(xpath="//strong[contains(text(), 'Science meets performance')]")
	public static WebElement link_sciencemeets;
	
	@FindBy(xpath="//a[@class='block-promo home-eco']")
	public static WebElement link_ecofriendly;
}
