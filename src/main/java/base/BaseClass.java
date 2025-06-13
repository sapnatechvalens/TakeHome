package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import pages.LoginPage;
//@Listeners({io.qameta.allure.testng.AllureTestNg.class})

// Class to perform the before class actions and contain browser driver interaction methods
public class BaseClass {

	 protected WebDriver driver;
	 LoginPage login;
		public BaseClass() {
		
			driver = new ChromeDriver(); 
		}
		
		// Open the browser
		@BeforeClass
		public void BrowserMethod() {
		driver.get("https://qa-takehome.dtxplus.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
	        driver.manage().window().maximize();
		}
		// Perform login
		public void performLogin() throws InterruptedException {
			login = new LoginPage(driver);
			login.enetrUserName("dtxplus");
	        login.enterPasword("dtxplus");
	        login.clickLogin();
	    }
		
		// tear down the browser
		 @AfterClass
		    public void tearDown() {
		        if (driver != null) {
		            driver.quit();
		            System.out.println("Driver closed successfully.");
		        }
		    }
}
