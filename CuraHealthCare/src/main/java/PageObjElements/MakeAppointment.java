package PageObjElements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.Select;

public class MakeAppointment {
	
	@FindBy(id = "combo_facility")
	public static WebElement facility;
	
	@FindBy(id = "chk_hospotal_readmission")
	public static WebElement readmsn_chkbox;
	
	@FindBy(xpath = "//label[@class='radio-inline']")
	public static List<WebElement> prgm_radio_btn;
		
	@FindBy(id = "txt_visit_date")
	public static WebElement date;
	
	@FindBy(className = "datepicker-switch")
	public static WebElement datetitle;
	
	@FindBy(xpath = "//div//th[@class='next']")
	public static WebElement nextbtn;
	
	@FindBy(xpath = "(//tbody)[1]//td")
	public static List<WebElement> alldates;
	
	@FindBy(id = "txt_comment")
	public static WebElement comment;
	
	@FindBy(id = "btn-book-appointment")
	public static WebElement booked;
	
}
