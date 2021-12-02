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

public class ImageUploadWithValidFile extends BaseClass implements PGCAFData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void LoggingIn() throws Exception {

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber1, Password1);
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void VerifyUploadingValidFile() throws Exception {

		// logger = report.createTest("Verifying Uploading valid File");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		From.BasicInformationDetails();
		Thread.sleep(500);

		From.AdditionalDetails();
		Thread.sleep(500);

		From.EducationalDetails();
		Thread.sleep(500);

		From.UploadImage();

		Thread.sleep(500);

		From.UploadNextButton().click();
		Thread.sleep(500);

		String actualPopup = From.PopUpMsg().getText();
		Thread.sleep(500);
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			Thread.sleep(500);
			constants.fileone.setCellData(sheetName, "Status", 248, "Pass");

			From.UploadOkButton().click();

			Thread.sleep(300);
			String actualPopup1 = From.PopUpMsg().getText();
			Thread.sleep(500);
			System.out.println(actualPopup1);
			Thread.sleep(500);
			From.UploadOkButton().click();

		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 248, "Fail");
			From.UploadOkButton().click();

		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked for Uploading valid File Scenario");
	}

}
