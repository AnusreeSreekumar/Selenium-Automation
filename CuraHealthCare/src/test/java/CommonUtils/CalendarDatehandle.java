package CommonUtils;

import org.openqa.selenium.WebElement;

import PageObjElements.MakeAppointment;

public class CalendarDatehandle {
	
	public static void dateshandle(String monthyear, String date) {
		
		while(true) {
			String monthyeartxt = MakeAppointment.datetitle.getText();
			if(monthyeartxt.equals(monthyear))
				break;
			else
				MakeAppointment.nextbtn.click();
		}
			
		for(WebElement ele:MakeAppointment.alldates) {
			
			String datetext = ele.getText();
			if(datetext.equals(date)) {
				
				ele.click();
				break;
			}
				
		}
	}

}
