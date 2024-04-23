package CommonUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class PageScreenshots extends DriverSetup{
	
	public static void takeScreenshot(String fileName) {
		
		String destination = "E:\\Anusree\\Automation\\Selenium\\Screenshots\\CuraHealthCare\\";
		
        // Cast WebDriver to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture screenshot as File
        File screenshot = ts.getScreenshotAs(OutputType.FILE);

        // Specify destination for screenshot
        String fileformat = destination + fileName + ".png";

        try {
            // Copy screenshot to destination
            FileUtils.copyFile(screenshot, new File(fileformat));
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}