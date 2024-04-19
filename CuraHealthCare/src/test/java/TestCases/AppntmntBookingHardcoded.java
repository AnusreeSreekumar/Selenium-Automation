package TestCases;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v119.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjElements.MakeAppointment;

public class AppntmntBookingHardcoded extends CommonUtils {
		
	@Test
	public static void BookingAppointment() throws InterruptedException {
		
		String target_facility = "Tokyo CURA Healthcare Center";
		String filename = null;
		
		UserLogin.Login();
		
		PageFactory.initElements(driver, MakeAppointment.class);
				
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(MakeAppointment.facility));
			
			Select ddown = new Select(MakeAppointment.facility);
			ddown.selectByValue(target_facility);
			String text_facl = "Tokyo";
			MakeAppointment.readmsn_chkbox.click();
			String text = "readmsn";
			
			String pgmname = RadioButtonhandle.radiobtn_setup();
			
			MakeAppointment.date.click();
			wait.until(ExpectedConditions.visibilityOf(MakeAppointment.datetitle));
			
			CalendarDatehandle.dateshandle();
			
			String commentText = "Booking a " + pgmname;
			MakeAppointment.comment.sendKeys(commentText);
			MakeAppointment.booked.click();
			filename = text_facl + "_" + pgmname + "_" + text;
			PageScreenshots.takeScreenshot(filename);
			
			UserLogout.Logout();
	}

}
