package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import pages.LoginPage;
//@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseClass {

	 protected WebDriver driver;// Use protected so child classes can access it
	 LoginPage login;
		public BaseClass() {
		
			driver = new ChromeDriver(); // Initialize WebDriver properly
		}
		
		@BeforeClass
		public void BrowserMethod() {
		driver.get("https://qa-takehome.dtxplus.com/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
	        driver.manage().window().maximize();
		}
		public void performLogin() throws InterruptedException {
			login = new LoginPage(driver);
			login.enetrUserName("dtxplus");
	        login.enterPasword("dtxplus");
	        login.clickLogin();
	    }
		
		 @AfterClass
		    public void tearDown() {
		        if (driver != null) {
		            driver.quit();
		            System.out.println("Driver closed successfully.");
		        }
		    }
}
