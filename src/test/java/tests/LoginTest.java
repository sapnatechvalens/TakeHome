package tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	LoginPage log;
	   @Test(description = "Login with valid credentials",priority = 1, enabled = true)
  public void logintest() throws IOException, InterruptedException {
      BrowserMethod();
      log = new LoginPage(driver); 
      log.enetrUserName("dtxplus");
      log.enterPasword("dtxplus");
      log.clickLogin();

      String currentUrl = driver.getCurrentUrl();
      Assert.assertEquals(currentUrl, "https://qa-takehome.dtxplus.com/", "Login failed with valid credentials");
  }
	   

	   @Test(description = "Login with Invalid credentials", priority = 2, enabled = true)
	   public void loginWithInvalidCredentials() throws InterruptedException {
	       BrowserMethod();
	       log = new LoginPage(driver);
	       log.enetrUserName("wronguser");
	       log.enterPasword("wrongpass");
	       log.clickLogin();

	       Alert alert = driver.switchTo().alert();
	       String alertText = alert.getText();
	       Assert.assertEquals(alertText, "Invalid login");
	       alert.accept();
	   }
	   
  
	   @Test(description = "Login without username", priority = 3, enabled = true)
	   public void loginWithBlankUsername() throws InterruptedException {
	       BrowserMethod();
	       log = new LoginPage(driver);
	       log.enetrUserName(""); // blank username
	       log.enterPasword("dtxplus");
	       log.clickLogin();


	       Alert alert = driver.switchTo().alert();
	       String alertText = alert.getText();
	       Assert.assertEquals(alertText, "Invalid login", "no text visible");
	       alert.accept();
	   }
	   

	   @Test(description = "Login without password", priority = 4)
	   public void loginWithBlankPassword() throws InterruptedException {
	       BrowserMethod();
	       log = new LoginPage(driver);
	       log.enetrUserName("dtxplus");
	       log.enterPasword(""); // blank password
	       log.clickLogin();

	       Alert alert = driver.switchTo().alert();
	       String alertText = alert.getText();
	       Assert.assertEquals(alertText, "Invalid login");
	       alert.accept();
	   }
	   
	   

	   @Test(description ="Login with blank username and password", priority = 5, enabled = true)
	   public void loginWithBlankUsernameAndPassword() throws InterruptedException {
	       BrowserMethod();
	       log = new LoginPage(driver);
	       log.enetrUserName("");
	       log.enterPasword("");
	       log.clickLogin();

	       Alert alert = driver.switchTo().alert();
	       String alertText = alert.getText();
	       Assert.assertEquals(alertText, "Invalid login", "no text visible");
	       alert.accept();
	       
	   }
	   
}

