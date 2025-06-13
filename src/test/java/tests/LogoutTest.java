package tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Dashboard;
import pages.LoginPage;
import pages.Logout;
import pages.PatientForm;
import utils.UtilClass;

public class LogoutTest extends BaseClass {
	Logout log;
	  @Test(description = "ATC-012, Verify successful logout", priority = 12)
	    public void testSpecialCharInMRN() throws InterruptedException {
	           BrowserMethod();
			   performLogin();
			   log = new Logout(driver);
			   log.clickLogout();
	}

}
