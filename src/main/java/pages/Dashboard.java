package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	WebDriver driver;
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table[@id='patients-table']//thead//tr") WebElement header;
	@FindBy(xpath = "//table[@id='patients-table']/tbody/tr") WebElement individualRow;
	//Get all the MRN cell
	@FindBy(xpath= "//table[@id='patients-table']/tbody/tr/td[1]") WebElement mrnList;
	//MRN cell for each row
	@FindBy(xpath = "//table[@id='patients-table']/tbody/tr/td[1]\r\n") WebElement mrnCell;

	  // Get all MRNs from the table
    public List<String> getAllMRNs() {
        List<WebElement> mrnCells = driver.findElements(By.xpath("//table[@id='patients-table']/tbody/tr/td[1]"));
        List<String> mrns = new ArrayList<>();
        for (WebElement cell : mrnCells) {
            mrns.add(cell.getText().trim());
        }
        return mrns;
    }

    //  Check if MRN exists
    public boolean isMRNPresent(String mrn) {
        String xpath = "//table[@id='patients-table']/tbody/tr/td[1][text()='" + mrn + "']";
        return !driver.findElements(By.xpath(xpath)).isEmpty();
    }

    //  Get row data by MRN
    public List<String> getRowDataByMRN(String mrn) {
        List<String> rowData = new ArrayList<>();
        String rowXPath = "//table[@id='patients-table']/tbody/tr[td[1][text()='" + mrn + "']]/td";
        List<WebElement> cells = driver.findElements(By.xpath(rowXPath));
        for (WebElement cell : cells) {
            rowData.add(cell.getText().trim());
        }
        return rowData;
    }

    // Count total patients in the table
    public int getPatientCount() {
        return driver.findElements(By.xpath("//table[@id='patients-table']/tbody/tr")).size();
    }
}
