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

public class AddressValidations extends BaseClass implements PGCAFData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void Login() throws Exception {

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber, Password);
		Thread.sleep(3000);

	}

	@Test(priority = 1)
	public void AcceptanceofSameAddressForDiffApplicants() throws Exception {

		// logger = report.createTest("Verifying acceptance of same address for
		// Different Applicants");

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
		Thread.sleep(3000);

		From.FatherName().click();
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
		From.IdentificationNumber().sendKeys("761490617322");
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering same Address Details");
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
		From.AlternateMobileNo().sendKeys("8280711795");
		Thread.sleep(300);

		ExtentFactory.getInstance().getExtent().info("Entering same Address for Correspondence");
		From.Address().clear();
		Thread.sleep(300);
		From.Address().sendKeys("Bhubaneswar");

		From.ApplicantName().clear();
		Thread.sleep(3000);
		From.ApplicantName().sendKeys("Milan Singh");

		Thread.sleep(300);
		From.BasicInfoNext().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 38, "Pass");
			Thread.sleep(300);
			From.BasicInfoCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 38, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully checked acceptance of same address for Different Applicants scenario");
	}

}
