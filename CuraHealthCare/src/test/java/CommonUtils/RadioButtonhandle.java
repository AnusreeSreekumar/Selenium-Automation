package CommonUtils;

import org.openqa.selenium.WebElement;

import PageObjElements.MakeAppointment;

public class RadioButtonhandle extends DriverSetup {
		
	public static String radiobtn_setup(String prgm) {
		
		for(WebElement ele:MakeAppointment.prgm_radio_btn) {
			String pgm = ele.getText();
			if(ele.isSelected()) {
				if(pgm.equals(prgm)) {
					break;
				}
			}
			else if(pgm.equals(prgm)) {
				ele.click();
				break;
			}
		}
		return prgm;
	}
}
