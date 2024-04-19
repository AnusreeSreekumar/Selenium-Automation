package TestCases;

import PageObjElements.LoginPage;

public class UserLogout extends CommonUtils{
	
	public static void Logout() {
		
		LoginPage.menu.click();
		LoginPage.logoutbtn.click();
	}
}
