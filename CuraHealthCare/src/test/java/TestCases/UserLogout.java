package TestCases;

import CommonUtils.DriverSetup;
import PageObjElements.LoginPage;

public class UserLogout extends DriverSetup{
	
	public static void Logout() {
		
		LoginPage.menu.click();
		LoginPage.logoutbtn.click();
	}
}
