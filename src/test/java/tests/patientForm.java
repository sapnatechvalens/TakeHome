package tests;
import base.BaseClass;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.PatientForm;
import utils.UtilClass;

import java.util.List;
import java.util.Map;

public class patientForm extends BaseClass {

    PatientForm form;
    Dashboard dashboard;
	int countBefore;
	  @BeforeClass
	    public void runLogin() throws InterruptedException {
	        BrowserMethod(); // driver setup
	        performLogin();  // login
	        dashboard = new Dashboard(driver);
	        form = new PatientForm(driver);
	    }

    @Test(description = "ATC-006, Fill all the fields with valid data", priority = 6)
    public void addPatient() throws Exception {
		   List<String> existingMRNs = dashboard.getAllMRNs();
	        countBefore = existingMRNs.size();
        Map<String, String> patient = UtilClass.generateRandomPatientData();
        form.clickAddPatientBtn();
        String generatedMRN =  form.enterMRN(patient.get("mrn"));
        form.patientFName(patient.get("firstName"));
        form.patientLName(patient.get("lastName"));
        form.selectDOB(patient.get("dob"));
        form.selectDischarge(patient.get("discharge"));
        form.addPhone(patient.get("phone"));
        form.selectLanguage(patient.get("language"));
        form.selectTimeZone(patient.get("timezone"));
        form.clickSubmit();
	    Assert.assertTrue(dashboard.isMRNPresent(generatedMRN), "MRN not found");

    }
    
    @Test(description = "ATC-007, When submit the form, Table should increased by one", priority = 7)
    public void validateTableEntry() throws Exception {

		   List<String> existingMRNs = dashboard.getAllMRNs();
	        countBefore = existingMRNs.size();
        Map<String, String> patient = UtilClass.generateRandomPatientData();
        
        form.clickAddPatientBtn();
        String generatedMRN =  form.enterMRN(patient.get("mrn"));
        form.patientFName(patient.get("firstName"));
        form.patientLName(patient.get("lastName"));
        form.selectDOB(patient.get("dob"));
        form.selectDischarge(patient.get("discharge"));
        form.addPhone(patient.get("phone"));
        form.selectLanguage(patient.get("language"));
        form.selectTimeZone(patient.get("timezone"));
        form.clickSubmit();
        int countAfter = dashboard.getPatientCount();
        Assert.assertEquals(countAfter, countBefore + 1, "entry not appear in table");   
    }
    
    @Test(description = "ATC-008, Leave all the fields empty and click submit", priority = 8)
    public void clickSubmit() throws Exception {

		   List<String> existingMRNs = dashboard.getAllMRNs();
	        countBefore = existingMRNs.size();
        form = new PatientForm(driver);
        form.clickAddPatientBtn();
        form.clickSubmit();
        int countAfter = dashboard.getPatientCount();
        Assert.assertEquals(countAfter, countBefore, "entry not appear in table");
    }
    
    
    @Test(description = "ATC-009,Enter Invalid DOB formate", priority = 9)
    public void invalidDOB() throws Exception {
		   List<String> existingMRNs = dashboard.getAllMRNs();
	        countBefore = existingMRNs.size();

        Map<String, String> patient = UtilClass.generateRandomPatientData();
        
        form.clickAddPatientBtn();
        String generatedMRN =  form.enterMRN(patient.get("mrn"));
        form.patientFName(patient.get("firstName"));
        form.patientLName(patient.get("lastName"));
        form.selectDOB("99/99/9999");
        form.selectDischarge(patient.get("discharge"));
        form.addPhone(patient.get("phone"));
        form.selectLanguage(patient.get("language"));
        form.selectTimeZone(patient.get("timezone"));
        form.clickSubmit();
        int countAfter = dashboard.getPatientCount();
       Assert.assertEquals(countAfter, countBefore, "entry not appear in table");

    }
    
    
    @Test(description = "ATC-010, Enter future DOB", priority = 10)
    public void testFutureDOB() throws InterruptedException {
		   List<String> existingMRNs = dashboard.getAllMRNs();
	        countBefore = existingMRNs.size();

     Map<String, String> patient = UtilClass.generateRandomPatientData();
     
     form.clickAddPatientBtn();
     String generatedMRN =  form.enterMRN(patient.get("mrn"));
     form.patientFName(patient.get("firstName"));
     form.patientLName(patient.get("lastName"));
     form.selectDOB("12/31/2030");
     form.selectDischarge(patient.get("discharge"));
     form.addPhone(patient.get("phone"));
     form.selectLanguage(patient.get("language"));
     form.selectTimeZone(patient.get("timezone"));
     form.clickSubmit();
     Assert.assertFalse(dashboard.isMRNPresent(generatedMRN));

    }


    @Test(description = "ATC-011, Special characters in MRN", priority = 11)
    public void testSpecialCharInMRN() throws InterruptedException {

		   List<String> existingMRNs = dashboard.getAllMRNs();
	        countBefore = existingMRNs.size();
     Map<String, String> patient = UtilClass.generateRandomPatientData();
     
     form.clickAddPatientBtn();
     form.enterMRN("!@#123");
     form.patientFName(patient.get("firstName"));
     form.patientLName(patient.get("lastName"));
     form.selectDOB("12/31/2030");
     form.selectDischarge(patient.get("discharge"));
     form.addPhone(patient.get("phone"));
     form.selectLanguage(patient.get("language"));
     form.selectTimeZone(patient.get("timezone"));
     form.clickSubmit();
     int countAfter = dashboard.getPatientCount();
     Assert.assertEquals(countAfter, countBefore, "entry not appear in table");
    }

}

