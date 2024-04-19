package TestCases;

import org.openqa.selenium.WebElement;

import PageObjElements.MakeAppointment;

public class CalendarDatehandle {
	
	public static void dateshandle() {
		
		String target_mnthyr = "January 2025";
		String target_date = "2";
		
		while(true) {
			String monthyear = MakeAppointment.datetitle.getText();
			if(monthyear.equals(target_mnthyr))
				break;
			else
				MakeAppointment.nextbtn.click();
		}
			
		for(WebElement ele:MakeAppointment.alldates) {
			
			String date = ele.getText();
			if(date.equals(target_date)) {
				
				ele.click();
				break;
			}
				
		}
	}

}
