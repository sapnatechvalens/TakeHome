package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PatientForm {

	WebDriver driver;
	public PatientForm(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	   Select select;
	@FindBy(xpath = "//button[@id='add-patient-btn']") WebElement addPatientBtn;
	@FindBy(xpath = "//input[@id='mrn']") WebElement mrn;
	@FindBy(xpath ="//input[@id='firstName']") WebElement fname;
	@FindBy(xpath = "//input[@id='lastName']") WebElement lname;
	@FindBy(xpath = "//input[@id='dob']") WebElement dob;
	@FindBy(xpath = "//input[@id='discharge']") WebElement discharge;
	@FindBy(xpath = "//input[@id='phone']") WebElement phone;
	@FindBy(xpath = "//select[@id='language']") WebElement lang;
	@FindBy(xpath = "//select[@id='timezone']") WebElement timeZone;
	@FindBy(xpath = "//button[text()='Submit']") WebElement submit;
	
	
	public void clickAddPatientBtn() {
		addPatientBtn.click();
	}
	
	public String enterMRN(String i) {
		mrn.sendKeys(i);
		return i;
	}
	
	public void patientFName(String name) {
		fname.sendKeys(name);
	}
	
	public void patientLName(String name) {
		lname.sendKeys(name);
	}
	
	public void selectDOB(String date) {
		dob.sendKeys(date);
		
	}
	
    public void selectDischarge(String date) {
		discharge.sendKeys(date);
	}
    
    public void addPhone(String  n) {
    	phone.sendKeys(n);
    }
    
    public void selectLanguage(String language) {
    	 select = new Select(lang);
	     select.selectByVisibleText(language);
//    	lang.click();
    }
    
    public void selectTimeZone(String zone) {
    	 select = new Select(timeZone);
	     select.selectByVisibleText(zone);
//    	timeZone.click();
    }
    
    public void clickSubmit() {
    	submit.click();
    }
}
