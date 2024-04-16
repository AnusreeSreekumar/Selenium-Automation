package TestCases;

import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Year;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjElements.MakeAppointment;

public class AppointmentBooking extends CommonUtils {
	
	
	@Test
	public void BookingAppointment() throws InterruptedException {
		
		UserLogin.LoginPageElements();
		
		PageFactory.initElements(driver, MakeAppointment.class);
				
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(MakeAppointment.facility));
			
			Select ddown = new Select(MakeAppointment.facility);
			ddown.selectByValue("Tokyo CURA Healthcare Center");
			MakeAppointment.readmsn_chkbox.click();
			MakeAppointment.aidprogram.click();
			MakeAppointment.date.click();

			wait.until(ExpectedConditions.visibilityOf(MakeAppointment.datetitle));
			
			String target_mnthyr = "November 2024";
			String target_date = "15";
			
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
			
			MakeAppointment.comment.sendKeys("Booking a Medical Aid");
			MakeAppointment.booked.click();
	}

}
