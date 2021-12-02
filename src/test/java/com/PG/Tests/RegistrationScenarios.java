package com.PG.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PG.Listener.ExtentFactory;
import com.PG.genericLibrary.constants;
import com.PG.objectRepository.BaseClass;
import com.PG.objectRepository.PGCAFData;
import com.PG.objectRepository.PGRegistrationNew;

public class RegistrationScenarios extends BaseClass implements PGCAFData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void RegistrationThroughInvalidData() throws Exception {

		// logger = report.createTest("Verify Registration through Invalid data");

		driver.get(constants.regurl);

		PGRegistrationNew reg = new PGRegistrationNew(driver);

		ExtentFactory.getInstance().getExtent().info("Registering with invalid data");

		reg.StudentName().sendKeys("Suprita");
		reg.MobileNumber().sendKeys("824981606");
		reg.GenerateOTP().click();
		String actualPopup = driver.findElement(By.id("popup_message")).getText();
		System.out.println(actualPopup);

//    	String actualPopup = ah.ConfirmationAlert();

		if (actualPopup.contains("Please enter valid Mobile No. !"))

		{
			constants.fileone.setCellData(sheetName, "Status", 2, "Pass");
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 2, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Please enter valid Mobile No. !", "Test Failed");

		driver.findElement(By.id("popup_ok")).click();

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Scenario Verified successfully");
	}

	@Test(priority = 1)
	public void RegistrationThroughDuplicateMobileNo() throws Exception {

		// logger = report.createTest("Verify Registration through Duplicate data");

		driver.get(constants.regurl);

		PGRegistrationNew reg = new PGRegistrationNew(driver);

		reg.StudentName().sendKeys("Suprita");
		reg.MobileNumber().sendKeys("8249816063");
		reg.GenerateOTP().click();
		String actualPopup = driver.findElement(By.id("popup_message")).getText();
		System.out.println(actualPopup);

		if (actualPopup.contains("This mobile number is already registered."))

		{
			constants.fileone.setCellData(sheetName, "Status", 3, "Pass");
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 3, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "This mobile number is already registered.", "Test Failed");

		driver.findElement(By.id("popup_ok")).click();

		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void RegistrationThroughDuplicateEmail() throws Exception {

		// logger = report.createTest("Verify Registration through Duplicate Email");

		driver.get(constants.regurl);

		PGRegistrationNew reg = new PGRegistrationNew(driver);

		reg.StudentName().sendKeys("Sarat");
		reg.MobileNumber().sendKeys("9437230940");
		reg.eMail().sendKeys("suprita75@gmail.com");
		reg.GenerateOTP().click();
		Thread.sleep(3000);
		reg.Submit().click();

		String actualPopup = driver.findElement(By.id("popup_message")).getText();
		System.out.println(actualPopup);

		if (actualPopup.contains("OTP can not be left blank"))

		{
			constants.fileone.setCellData(sheetName, "Status", 4, "Pass");
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 4, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "OTP can not be left blank", "Test Failed");

		driver.findElement(By.id("popup_ok")).click();

		softAssert.assertAll();
	}
}
