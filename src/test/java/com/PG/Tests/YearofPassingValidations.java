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

public class YearofPassingValidations extends BaseClass implements PGCAFData{

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
	public void YOPComparisonBetween10th_12th() throws Exception {

		//logger = report.createTest("Verifying Year of Passing between 10th and 12th ");

		PGCAFNew From = new PGCAFNew(driver);

		Thread.sleep(400);
		From.BasicInformationDetails();
		Thread.sleep(400);
		From.AdditionalDetails();
		Thread.sleep(400);

		From.GraduationAppeared().click();
		Thread.sleep(500);
		From.GraduationWithDistinction().click();
		Thread.sleep(500);

		From.TenthMaxMark().sendKeys("600");
		Thread.sleep(500);
		From.TenthSecuredMarksorCGPA().sendKeys("455");

		Thread.sleep(400);

		From.PlusTwoStream("Science");

		Thread.sleep(500);
		From.PlusTwoMarkType("MARK");

		Thread.sleep(500);
		From.PlusTwoBoard("CHSE, Odisha");

		ExtentFactory.getInstance().getExtent().info("Entering 12th Year of Passing");

		Thread.sleep(500);
		From.PlusTwoYOP("2017");

		Thread.sleep(400);

		From.EducationalQualificationNext1().click();

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		if (actualPopup.contains("Plus two Year Of Passing should be 2years after Matric Year Of Passing!"))

		{
			constants.fileone.setCellData(sheetName, "Status", 62, "Pass");
			Thread.sleep(300);
			From.PopUpOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 62, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Plus two Year Of Passing should be 2years after Matric Year Of Passing!",
				"Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Comparison of Year of Passing between 10th & 12th scenario");
	}

	@Test(priority = 2)
	public void YOPComparisonBetween12th_Graduation() throws Exception {

		//logger = report.createTest("Verifying Year of Passing between 12th and Graduation ");

		PGCAFNew From = new PGCAFNew(driver);

		Thread.sleep(400);
		From.TenthMaxMark().clear();
		Thread.sleep(400);
		From.TenthMaxMark().sendKeys("600");
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().sendKeys("455");
		Thread.sleep(500);

		From.PopUpOK().click();
		From.PlusTwoStream("Science");

		Thread.sleep(500);
		From.PlusTwoMarkType("MARK");

		Thread.sleep(500);
		From.PlusTwoBoard("CHSE, Odisha");

		Thread.sleep(500);

		ExtentFactory.getInstance().getExtent().info("Entering 12th Year of Passing");
		From.PlusTwoYOP("2018");

		Thread.sleep(400);
		From.PlusTwoRollNo().clear();
		Thread.sleep(400);
		From.PlusTwoRollNo().sendKeys("41TC178");
		Thread.sleep(400);
		From.PlusTwoMaxMark().clear();
		Thread.sleep(400);
		From.PlusTwoMaxMark().sendKeys("600");
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().sendKeys("455");

		Thread.sleep(500);

		From.GraduationStream("BTech");

		Thread.sleep(500);
		From.GraduationMarkType("MARK");
		Thread.sleep(500);

		From.GraduationBoard("Siksha ‘O’ Anusandhan University, Bhubaneswar");

		Thread.sleep(500);

		ExtentFactory.getInstance().getExtent().info("Entering Graduation Year of Passing");
		From.GraduationYOP("2020");

		From.EducationalQualificationNext1().click();

		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		if (actualPopup.contains("Graduation Year Of Passing should be 3 years after Plus Two Year Of Passing!"))

		{
			constants.fileone.setCellData(sheetName, "Status", 63, "Pass");
			Thread.sleep(300);
			From.PopUpOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 63, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup,
				"Graduation Year Of Passing should be 3 years after Plus Two Year Of Passing!", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully checked Comparison of Year of Passing between 12th & Graduation scenario ");
	}

}
