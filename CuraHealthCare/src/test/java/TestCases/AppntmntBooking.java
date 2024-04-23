package TestCases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import CommonUtils.CalendarDatehandle;
import CommonUtils.DriverSetup;
import CommonUtils.ExcelRead;
import CommonUtils.PageScreenshots;
import CommonUtils.RadioButtonhandle;
import PageObjElements.MakeAppointment;

public class AppntmntBooking extends DriverSetup {
	
	private ExcelRead inputexcel = new ExcelRead();
	
	@DataProvider(name = "inputdata")
	public Object[][] TestDataProvider() throws IOException {

		Object[][] testdata = (Object[][]) inputexcel.getappointmentdata();
		return testdata;
	}
	
	@Test(dataProvider = "inputdata")
	public static void appointmentbooking(String facility, String facilitytxt,  String readmsn, String prgm, String monthyear, String date) throws InterruptedException {
		
		String text = null;
		
		UserLogin.Login();
		
		PageFactory.initElements(driver, MakeAppointment.class);
				
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(MakeAppointment.facility));
			
			Select ddown = new Select(MakeAppointment.facility);
			ddown.selectByValue(facility);
			if(readmsn.equals("Yes")) {
				MakeAppointment.readmsn_chkbox.click();
				text = "readmission";
			}
			else if(readmsn.equals("No")) {
				text = "No_readmission";
			}
			
			String pgmname = RadioButtonhandle.radiobtn_setup(prgm);
			
			MakeAppointment.date.click();
			wait.until(ExpectedConditions.visibilityOf(MakeAppointment.datetitle));
			
			CalendarDatehandle.dateshandle(monthyear, date);
			
			String commentText = "Booking a " + pgmname;
			MakeAppointment.comment.sendKeys(commentText);
			MakeAppointment.booked.click();
			String filename = facilitytxt + "_" + pgmname + "_" + text;
			PageScreenshots.takeScreenshot(filename);
			
			UserLogout.Logout();
	}
	

}
