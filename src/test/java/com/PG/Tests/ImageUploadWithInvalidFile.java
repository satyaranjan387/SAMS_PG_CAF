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

public class ImageUploadWithInvalidFile extends BaseClass implements PGCAFData {

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
	public void VerifyUploadingInvalidFile() throws Exception {

		// logger = report.createTest("Verifying Uploading Invalid File");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		From.BasicInformationDetails();
		Thread.sleep(500);

		From.AdditionalDetails();
		Thread.sleep(500);

		From.EducationalDetails();
		Thread.sleep(500);

		From.PDFUploadImage();

		Thread.sleep(500);

		From.UploadButton().click();
		Thread.sleep(500);
		String actualPopup = From.grtmsg();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("Please upload a file with extension of .jpg  .jpeg  .png  .bmp"))

		{
			constants.fileone.setCellData(sheetName, "Status", 249, "Pass");
			Thread.sleep(300);
			From.JavaAcceptalert();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 249, "Fail");
			From.JavaAcceptalert();
		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Please upload a file with extension of .jpg  .jpeg  .png  .bmp",
				"Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked for Uploading Invalid File Scenario");
	}

}
