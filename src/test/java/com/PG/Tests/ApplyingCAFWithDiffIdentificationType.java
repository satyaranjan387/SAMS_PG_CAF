package com.PG.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PG.Listener.ExtentFactory;
import com.PG.browser.BrowserFactoryNew;
import com.PG.genericLibrary.constants;
import com.PG.objectRepository.BaseClass;
import com.PG.objectRepository.PGCAFData;
import com.PG.objectRepository.PGCAFNew;

public class ApplyingCAFWithDiffIdentificationType extends BaseClass implements PGCAFData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void LoggingIn() throws Exception {

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber, Password);
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void SubmittingCAFwithValidAadhaarNo() throws Exception {

		// logger = report.createTest("Verifying submitting of CAF with valid Aadhaar
		// Number");

		PGCAFNew From = new PGCAFNew(driver);

		From.ApplicationFormButton().click();
		Thread.sleep(300);
		From.BoardName("BSE, Odisha");
		Thread.sleep(300);
		From.YearofPassing("2015");
		Thread.sleep(300);
		From.ExamTypeAsAnnual().click();
		Thread.sleep(300);
		From.RollNumber().clear();

		Thread.sleep(300);
		From.RollNumber().sendKeys("31TC168");
		Thread.sleep(300);
		From.BloodGroup("A+");
		Thread.sleep(300);
		From.ApplicantName().clear();
		Thread.sleep(1000);
		From.ApplicantName().sendKeys("Milan Singh");
		Thread.sleep(300);
		From.FatherName().clear();
		Thread.sleep(300);
		From.FatherName().sendKeys("Rajendra Kumar Singh");
		Thread.sleep(300);
		From.MotherName().clear();
		Thread.sleep(300);
		From.MotherName().sendKeys("Sarojini Singh");
		Thread.sleep(300);
		From.Gender("MALE");
		Thread.sleep(300);
		From.Religion("HINDU");
		Thread.sleep(300);
		From.BirthDate();
		Thread.sleep(300);
		From.IdentificationType("Aadhaar");
		Thread.sleep(300);
		From.IdentificationNumber().clear();
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering Valid Aadhaar Number");

		From.IdentificationNumber().sendKeys("761490617322");

		Thread.sleep(300);
		From.StateofDomicile("ODISHA");
		Thread.sleep(300);
		From.State("ODISHA");
		Thread.sleep(300);
		From.District("KHURDA");
		Thread.sleep(300);
		From.Block("BHUBANESWAR (MC)");
		Thread.sleep(300);
		From.Pincode().clear();
		Thread.sleep(300);
		From.Pincode().sendKeys("751010");
		Thread.sleep(300);
		From.AlternateMobileNo().sendKeys("9437850045");
		Thread.sleep(300);
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");
		Thread.sleep(1000);
		From.ApplicantName().sendKeys("Milan Singh");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 18, "Pass");
			Thread.sleep(300);
			From.BasicInfoCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 18, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Valid Aadhaar No. scenario");
	}

	@Test(priority = 2)
	public void SubmittingCAFWithInvalidAadhar() throws Exception {

		// logger = report.createTest("Verifying submitting of CAF with Invalid Aadhaar
		// Number");

		PGCAFNew From = new PGCAFNew(driver);

		Thread.sleep(300);
		From.BoardName("BPE, Kerala");
		Thread.sleep(300);
		From.YearofPassing("2015");
		Thread.sleep(300);
		From.ExamTypeAsSupplementary().click();
		Thread.sleep(300);
		From.RollNumber().clear();
		Thread.sleep(300);
		From.RollNumber().sendKeys("31TC168");
		Thread.sleep(300);
		From.BloodGroup("A+");
		Thread.sleep(300);
		From.ApplicantName().clear();
		Thread.sleep(300);
		From.ApplicantName().sendKeys("Milan Singh");
		Thread.sleep(300);
		From.FatherName().clear();
		Thread.sleep(300);
		From.FatherName().sendKeys("Rajendra Kumar Singh");
		Thread.sleep(300);
		From.MotherName().clear();
		Thread.sleep(300);
		From.MotherName().sendKeys("Sarojini Singh");
		Thread.sleep(300);
		From.Gender("FEMALE");
		Thread.sleep(300);
		From.Religion("HINDU");
		Thread.sleep(300);
		From.BirthDate();
		Thread.sleep(300);
		From.IdentificationType("Aadhaar");
		Thread.sleep(300);
		From.IdentificationNumber().clear();
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering Invalid Aadhaar Number");

		From.IdentificationNumber().sendKeys("7614906173");

		Thread.sleep(300);
		From.StateofDomicile("ODISHA");
		Thread.sleep(300);
		From.State("ODISHA");
		Thread.sleep(300);
		From.District("KHURDA");
		Thread.sleep(300);
		From.Block("BHUBANESWAR (MC)");
		Thread.sleep(300);
		From.Pincode().clear();
		Thread.sleep(300);
		From.Pincode().sendKeys("751010");
		Thread.sleep(300);
		From.AlternateMobileNo().sendKeys("9437850045");
		Thread.sleep(300);
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Invalid Aadhaar Number !"))

		{
			constants.fileone.setCellData(sheetName, "Status", 19, "Pass");
			Thread.sleep(300);
			From.BasicInfoOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 19, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Invalid Aadhaar Number !", "Test Passed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Invalid Aadhaar No. scenario");
	}

	@Test(priority = 3)
	public void SubmittingCAFWithValidVoterID() throws Exception {

		// logger = report.createTest("Verifying submitting of CAF with valid Voter
		// ID");

		PGCAFNew From = new PGCAFNew(driver);

		Thread.sleep(300);
		From.BoardName("BPE, Kerala");
		Thread.sleep(300);
		From.YearofPassing("2015");

		Thread.sleep(300);
		From.RollNumber().clear();
		Thread.sleep(300);
		From.RollNumber().sendKeys("31TC168");
		Thread.sleep(300);
		From.BloodGroup("A+");
		Thread.sleep(300);
		From.ApplicantName().clear();
		Thread.sleep(300);
		From.ApplicantName().sendKeys("Milan Singh");
		Thread.sleep(300);
		From.FatherName().clear();
		Thread.sleep(300);
		From.FatherName().sendKeys("Rajendra Kumar Singh");
		Thread.sleep(300);
		From.MotherName().clear();
		Thread.sleep(300);
		From.MotherName().sendKeys("Sarojini Singh");
		Thread.sleep(300);
		From.Gender("MALE");
		Thread.sleep(300);
		From.Religion("HINDU");
		Thread.sleep(300);
		From.BirthDate();
		Thread.sleep(300);
		From.IdentificationType("Voter ID");
		Thread.sleep(300);
		From.IdentificationNumber().clear();
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering Valid Voter ID");

		From.IdentificationNumber().sendKeys("RXL0494039");

		Thread.sleep(300);
		From.StateofDomicile("ODISHA");
		Thread.sleep(300);
		From.State("ODISHA");
		Thread.sleep(300);
		From.District("KHURDA");
		Thread.sleep(300);
		From.Block("BHUBANESWAR (MC)");
		Thread.sleep(300);
		From.Pincode().clear();
		Thread.sleep(300);
		From.Pincode().sendKeys("751010");
		Thread.sleep(300);
		From.AlternateMobileNo().sendKeys("9437850045");
		Thread.sleep(300);
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 20, "Pass");
			Thread.sleep(300);
			From.BasicInfoCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 20, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Valid Voter ID scenario");
	}

	@Test(priority = 4)
	public void SubmittingCAFWithInValidVoterID() throws Exception {

		// logger = report.createTest("Verifying submitting of CAF with invalid Voter
		// ID");

		PGCAFNew From = new PGCAFNew(driver);

		From.ScrollUp();

		Thread.sleep(300);
		From.BoardName("BPE, Kerala");
		Thread.sleep(300);
		From.YearofPassing("2015");

		Thread.sleep(300);
		From.RollNumber().clear();
		Thread.sleep(300);
		From.RollNumber().sendKeys("31TC168");
		Thread.sleep(300);
		From.BloodGroup("A+");
		Thread.sleep(300);
		From.ApplicantName().clear();
		Thread.sleep(300);
		From.ApplicantName().sendKeys("Milan Singh");
		Thread.sleep(300);
		From.FatherName().clear();
		Thread.sleep(300);
		From.FatherName().sendKeys("Rajendra Kumar Singh");
		Thread.sleep(300);
		From.MotherName().clear();
		Thread.sleep(300);
		From.MotherName().sendKeys("Sarojini Singh");
		Thread.sleep(300);
		From.Gender("MALE");
		Thread.sleep(300);
		From.Religion("HINDU");
		Thread.sleep(300);
		From.BirthDate();
		Thread.sleep(300);
		From.IdentificationType("Voter ID");
		Thread.sleep(300);
		From.IdentificationNumber().clear();
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering Invalid Voter ID");

		From.IdentificationNumber().sendKeys("RXL0494");

		Thread.sleep(300);
		From.StateofDomicile("ODISHA");
		Thread.sleep(300);
		From.State("ODISHA");
		Thread.sleep(300);
		From.District("KHURDA");
		Thread.sleep(300);
		From.Block("BHUBANESWAR (MC)");
		Thread.sleep(300);
		From.Pincode().clear();
		Thread.sleep(300);
		From.Pincode().sendKeys("751010");
		Thread.sleep(300);
		From.AlternateMobileNo().sendKeys("9437850045");
		Thread.sleep(300);
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Voter Id is not valid !"))

		{
			constants.fileone.setCellData(sheetName, "Status", 21, "Pass");
			Thread.sleep(300);
			From.BasicInfoOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 21, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Voter Id is not valid !", "Test Passed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Invalid Voter ID scenario");
	}

	@Test(priority = 5)
	public void SubmittingCAFWithValidDL() throws Exception {

		// logger = report.createTest("Verifying submitting of CAF with valid Driving
		// License");

		PGCAFNew From = new PGCAFNew(driver);

		From.ScrollUp();

		Thread.sleep(300);
		From.BoardName("BPE, Kerala");
		Thread.sleep(300);
		From.YearofPassing("2015");

		Thread.sleep(300);
		From.RollNumber().clear();
		Thread.sleep(300);
		From.RollNumber().sendKeys("31TC168");
		Thread.sleep(300);
		From.BloodGroup("A+");
		Thread.sleep(300);
		From.ApplicantName().clear();
		Thread.sleep(300);
		From.ApplicantName().sendKeys("Milan Singh");
		Thread.sleep(300);
		From.FatherName().clear();
		Thread.sleep(300);
		From.FatherName().sendKeys("Rajendra Kumar Singh");
		Thread.sleep(300);
		From.MotherName().clear();
		Thread.sleep(300);
		From.MotherName().sendKeys("Sarojini Singh");
		Thread.sleep(300);
		From.Gender("MALE");
		Thread.sleep(300);
		From.Religion("HINDU");
		Thread.sleep(300);
		From.BirthDate();
		Thread.sleep(300);
		From.IdentificationType("Driving Licence");
		Thread.sleep(300);
		From.IdentificationNumber().clear();
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering Valid DL");

		From.IdentificationNumber().sendKeys("20200014791");

		Thread.sleep(300);
		From.StateofDomicile("ODISHA");
		Thread.sleep(300);
		From.State("ODISHA");
		Thread.sleep(300);
		From.District("KHURDA");
		Thread.sleep(300);
		From.Block("BHUBANESWAR (MC)");
		Thread.sleep(300);
		From.Pincode().clear();
		Thread.sleep(300);
		From.Pincode().sendKeys("751010");
		Thread.sleep(300);
		From.AlternateMobileNo().sendKeys("9437850045");
		Thread.sleep(300);
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 22, "Pass");
			Thread.sleep(300);
			From.BasicInfoCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 22, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Valid DL scenario");
	}

	@Test(priority = 6)
	public void SubmittingCAFWithInValidDL() throws Exception {

		// logger = report.createTest("Verifying submitting of CAF with invalid Driving
		// License");

		PGCAFNew From = new PGCAFNew(driver);

		From.ScrollUp();

		Thread.sleep(300);
		From.BoardName("BPE, Kerala");
		Thread.sleep(300);
		From.YearofPassing("2015");

		Thread.sleep(300);
		From.RollNumber().clear();
		Thread.sleep(300);
		From.RollNumber().sendKeys("31TC168");
		Thread.sleep(300);
		From.BloodGroup("A+");
		Thread.sleep(300);
		From.ApplicantName().clear();
		Thread.sleep(300);
		From.ApplicantName().sendKeys("Milan Singh");
		Thread.sleep(300);
		From.FatherName().clear();
		Thread.sleep(300);
		From.FatherName().sendKeys("Rajendra Kumar Singh");
		Thread.sleep(300);
		From.MotherName().clear();
		Thread.sleep(300);
		From.MotherName().sendKeys("Sarojini Singh");
		Thread.sleep(300);
		From.Gender("MALE");
		Thread.sleep(300);
		From.Religion("HINDU");
		Thread.sleep(300);
		From.BirthDate();
		Thread.sleep(300);
		From.IdentificationType("Driving Licence");
		Thread.sleep(300);
		From.IdentificationNumber().clear();
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering Invalid DL");

		From.IdentificationNumber().sendKeys("123");

		Thread.sleep(300);
		From.StateofDomicile("ODISHA");
		Thread.sleep(300);
		From.State("ODISHA");
		Thread.sleep(300);
		From.District("KHURDA");
		Thread.sleep(300);
		From.Block("BHUBANESWAR (MC)");
		Thread.sleep(300);
		From.Pincode().clear();
		Thread.sleep(300);
		From.Pincode().sendKeys("751010");
		Thread.sleep(300);
		From.AlternateMobileNo().sendKeys("9437850045");
		Thread.sleep(300);
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Invalid Driving Licence Id"))

		{
			constants.fileone.setCellData(sheetName, "Status", 23, "Fail");
			Thread.sleep(300);
			From.BasicInfoCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 23, "Pass");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Invalid Driving Licence Id", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Invalid DL scenario");
	}

	@Test(priority = 7)
	public void SubmittingCAFWithValidPassport() throws Exception {

		// logger = report.createTest("Verifying submitting of CAF with valid
		// Passport");

		PGCAFNew From = new PGCAFNew(driver);

		From.ScrollUp();

		Thread.sleep(300);
		From.BoardName("BPE, Kerala");
		Thread.sleep(300);
		From.YearofPassing("2015");

		Thread.sleep(300);
		From.RollNumber().clear();
		Thread.sleep(300);
		From.RollNumber().sendKeys("31TC168");
		Thread.sleep(300);
		From.BloodGroup("A+");
		Thread.sleep(300);
		From.ApplicantName().clear();
		Thread.sleep(300);
		From.ApplicantName().sendKeys("Milan Singh");
		Thread.sleep(300);
		From.FatherName().clear();
		Thread.sleep(300);
		From.FatherName().sendKeys("Rajendra Kumar Singh");
		Thread.sleep(300);
		From.MotherName().clear();
		Thread.sleep(300);
		From.MotherName().sendKeys("Sarojini Singh");
		Thread.sleep(300);
		From.Gender("MALE");
		Thread.sleep(300);
		From.Religion("HINDU");
		Thread.sleep(300);
		From.BirthDate();
		Thread.sleep(300);
		From.IdentificationType("Passport");
		Thread.sleep(300);
		From.IdentificationNumber().clear();
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering Valid Passport");

		From.IdentificationNumber().sendKeys("H2908283");

		Thread.sleep(300);
		From.StateofDomicile("ODISHA");
		Thread.sleep(300);
		From.State("ODISHA");
		Thread.sleep(300);
		From.District("KHURDA");
		Thread.sleep(300);
		From.Block("BHUBANESWAR (MC)");
		Thread.sleep(300);
		From.Pincode().clear();
		Thread.sleep(300);
		From.Pincode().sendKeys("751010");
		Thread.sleep(300);
		From.AlternateMobileNo().sendKeys("9437850045");
		Thread.sleep(300);
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 24, "Pass");
			Thread.sleep(300);
			From.BasicInfoCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 24, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Valid Passport scenario");
	}

	@Test(priority = 8)
	public void SubmittingCAFwithInValidPassport() throws Exception {

		// logger = report.createTest("Verifying submitting of CAF with invalid
		// Passport");

		PGCAFNew From = new PGCAFNew(driver);

		From.ScrollUp();

		Thread.sleep(300);
		From.BoardName("BPE, Kerala");
		Thread.sleep(300);
		From.YearofPassing("2015");

		Thread.sleep(300);
		From.RollNumber().clear();
		Thread.sleep(300);
		From.RollNumber().sendKeys("31TC168");
		Thread.sleep(300);
		From.BloodGroup("A+");
		Thread.sleep(300);
		From.ApplicantName().clear();
		Thread.sleep(300);
		From.ApplicantName().sendKeys("Milan Singh");
		Thread.sleep(300);
		From.FatherName().clear();
		Thread.sleep(300);
		From.FatherName().sendKeys("Rajendra Kumar Singh");
		Thread.sleep(300);
		From.MotherName().clear();
		Thread.sleep(300);
		From.MotherName().sendKeys("Sarojini Singh");
		Thread.sleep(300);
		From.Gender("MALE");
		Thread.sleep(300);
		From.Religion("HINDU");
		Thread.sleep(300);
		From.BirthDate();
		Thread.sleep(300);
		From.IdentificationType("Passport");
		Thread.sleep(300);
		From.IdentificationNumber().clear();
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering Invalid Passport");

		From.IdentificationNumber().sendKeys("H");

		Thread.sleep(300);
		From.StateofDomicile("ODISHA");
		Thread.sleep(300);
		From.State("ODISHA");
		Thread.sleep(300);
		From.District("KHURDA");
		Thread.sleep(300);
		From.Block("BHUBANESWAR (MC)");
		Thread.sleep(300);
		From.Pincode().clear();
		Thread.sleep(300);
		From.Pincode().sendKeys("751010");
		Thread.sleep(300);
		From.AlternateMobileNo().sendKeys("9437850045");
		Thread.sleep(300);
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(600);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Passport is not valid !"))

		{
			constants.fileone.setCellData(sheetName, "Status", 25, "Pass");
//			Thread.sleep(500);
//			From.BasicInfoNext().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 25, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Passport is not valid !", "Test Passed");

		From.BasicInfoOK().click();

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Invalid Passport scenario");
	}

	@Test(priority = 9)
	public void SubmittingCAFWithValidPAN() throws Exception {

		// logger = report.createTest("Verifying submitting of CAF with valid PAN");

		PGCAFNew From = new PGCAFNew(driver);

		From.ScrollUp();

		Thread.sleep(300);
		From.BoardName("BPE, Kerala");
		Thread.sleep(300);
		From.YearofPassing("2015");

		Thread.sleep(300);
		From.RollNumber().clear();
		Thread.sleep(300);
		From.RollNumber().sendKeys("31TC168");
		Thread.sleep(300);
		From.BloodGroup("A+");
		Thread.sleep(300);
		From.ApplicantName().clear();
		Thread.sleep(300);
		From.ApplicantName().sendKeys("Milan Singh");
		Thread.sleep(300);
		From.FatherName().clear();
		Thread.sleep(300);
		From.FatherName().sendKeys("Rajendra Kumar Singh");
		Thread.sleep(300);
		From.MotherName().clear();
		Thread.sleep(300);
		From.MotherName().sendKeys("Sarojini Singh");
		Thread.sleep(300);
		From.Gender("MALE");
		Thread.sleep(300);
		From.Religion("HINDU");
		Thread.sleep(300);
		From.BirthDate();
		Thread.sleep(300);
		From.IdentificationType("PAN Card");
		Thread.sleep(300);
		From.IdentificationNumber().clear();
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering Valid PAN");

		From.IdentificationNumber().sendKeys("AAECC6548C");

		Thread.sleep(300);
		From.StateofDomicile("ODISHA");
		Thread.sleep(300);
		From.State("ODISHA");
		Thread.sleep(300);
		From.District("KHURDA");
		Thread.sleep(300);
		From.Block("BHUBANESWAR (MC)");
		Thread.sleep(300);
		From.Pincode().clear();
		Thread.sleep(300);
		From.Pincode().sendKeys("751010");
		Thread.sleep(300);
		From.AlternateMobileNo().sendKeys("9437850045");
		Thread.sleep(300);
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 26, "Pass");
			Thread.sleep(300);
			From.BasicInfoCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 26, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked valid PAN scenario");
	}

	@Test(priority = 10)
	public void SubmittingCAFWithInvalidPAN() throws Exception {

		// logger = report.createTest("Verifying submitting of CAF with invalid PAN");

		PGCAFNew From = new PGCAFNew(driver);

		From.ScrollUp();

		Thread.sleep(500);
		From.BoardName("BPE, Kerala");
		Thread.sleep(300);
		From.YearofPassing("2015");

		Thread.sleep(300);
		From.RollNumber().clear();
		Thread.sleep(300);
		From.RollNumber().sendKeys("31TC168");
		Thread.sleep(300);
		From.BloodGroup("A+");
		Thread.sleep(300);
		From.ApplicantName().clear();
		Thread.sleep(300);
		From.ApplicantName().sendKeys("Milan Singh");
		Thread.sleep(300);
		From.FatherName().clear();
		Thread.sleep(300);
		From.FatherName().sendKeys("Rajendra Kumar Singh");
		Thread.sleep(300);
		From.MotherName().clear();
		Thread.sleep(300);
		From.MotherName().sendKeys("Sarojini Singh");
		Thread.sleep(300);
		From.Gender("MALE");
		Thread.sleep(300);
		From.Religion("HINDU");
		Thread.sleep(300);
		From.BirthDate();
		Thread.sleep(300);
		From.IdentificationType("PAN Card");
		Thread.sleep(300);
		From.IdentificationNumber().clear();
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering Invalid PAN");

		From.IdentificationNumber().sendKeys("CC6548C");

		Thread.sleep(300);
		From.StateofDomicile("ODISHA");
		Thread.sleep(300);
		From.State("ODISHA");
		Thread.sleep(300);
		From.District("KHURDA");
		Thread.sleep(300);
		From.Block("BHUBANESWAR (MC)");
		Thread.sleep(300);
		From.Pincode().clear();
		Thread.sleep(300);
		From.Pincode().sendKeys("751010");
		Thread.sleep(300);
		From.AlternateMobileNo().sendKeys("9437850045");
		Thread.sleep(300);
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Please enter valid PAN No.!"))

		{
			constants.fileone.setCellData(sheetName, "Status", 27, "Pass");
//			Thread.sleep(300);
//			From.BasicInfoCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 27, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Please enter valid PAN No.!", "Test Passed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked invalid PAN scenario");
	}

}