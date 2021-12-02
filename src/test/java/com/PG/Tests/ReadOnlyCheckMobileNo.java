package com.PG.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PG.Listener.ExtentFactory;
import com.PG.browser.BrowserFactoryNew;
import com.PG.genericLibrary.constants;
import com.PG.objectRepository.BaseClass;
import com.PG.objectRepository.PGCAFData;
import com.PG.objectRepository.PGCAFNew;

public class ReadOnlyCheckMobileNo extends BaseClass implements PGCAFData {

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
	public void VerifyReadOnlyMobileNo() throws Exception {

		// logger = report.createTest("Verifying ReadOnly MobileNo");

		PGCAFNew From = new PGCAFNew(driver);
		From.ApplicationFormButton().click();
		Thread.sleep(300);

		WebElement MobileNo = From.MobNo();

		if (MobileNo.isEnabled())

		{
			constants.fileone.setCellData(sheetName, "Status", 36, "Fail");

		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 36, "Pass");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(false, MobileNo.isEnabled());

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Read Only MobileNo scenario");
	}
}
