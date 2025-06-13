package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='username']") WebElement userName;
	@FindBy(xpath = "//input[@id='password']") WebElement password;
	@FindBy(xpath ="//button[normalize-space()='Login']") WebElement login;
	
	public void enetrUserName(String uname) {
		userName.sendKeys(uname);
	}
	
	public void enterPasword(String pw) {
		password.sendKeys(pw);
	}
	
	public void clickLogin() {
		login.click();
	}
}

