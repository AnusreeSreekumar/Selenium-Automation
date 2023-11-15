package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
	public static WebElement create_link;
	
	@FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
	public static WebElement sign_link;
	
	@FindBy(id="search")
	public static WebElement search_text;
	
	@FindBy(id="ui-id-3")
	public static WebElement new_link;
	
	@FindBy(id="ui-id-4")
	public static WebElement women_link;
	
	
}
