package TestCases;

import org.openqa.selenium.WebElement;

import PageObjElements.MakeAppointment;

public class RadioButtonhandle extends CommonUtils {
		
	public static String radiobtn_setup() {
		
		String target_prgm = "Medicare";
	
		for(WebElement ele:MakeAppointment.prgm_radio_btn) {
			String pgm = ele.getText();
			if(ele.isSelected()) {
				if(pgm.equals(target_prgm)) {
					break;
				}
			}
			else if(pgm.equals(target_prgm)) {
				ele.click();
				break;
			}
		}
		return target_prgm;
	}
}
