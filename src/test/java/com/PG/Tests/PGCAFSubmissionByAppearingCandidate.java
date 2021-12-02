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

public class PGCAFSubmissionByAppearingCandidate extends BaseClass implements PGCAFData {

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
	public void SubmissionofPGCAFByAppearingCandidate() throws Exception {

		// logger = report.createTest("Verifying applying of CAF By PG Appearing
		// Applicant");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);
		From.BasicInformationDetails();
		Thread.sleep(400);
		From.AdditionalDetails();
		Thread.sleep(400);

		From.GraduationAppeared().click();
		Thread.sleep(500);

		From.TenthMaxMark().sendKeys("600");
		Thread.sleep(500);
		From.TenthSecuredMarksorCGPA().sendKeys("455");
		Thread.sleep(500);
		From.PlusTwoStream("Science");

		Thread.sleep(500);
		From.PlusTwoMarkType("MARK");

		Thread.sleep(500);
		From.PlusTwoBoard("CHSE, Odisha");

		Thread.sleep(500);
		From.PlusTwoYOP("2018");

		Thread.sleep(500);
		From.PlusTwoRollNo().sendKeys("41TC178");
		Thread.sleep(500);
		From.PlusTwoMaxMark().sendKeys("600");
		Thread.sleep(500);
		From.PlusTwoSecuredMarksorCGPA().sendKeys("455");

		Thread.sleep(500);

		From.GraduationStream("BTech");

		Thread.sleep(500);
		From.GraduationMarkType("MARK");
		Thread.sleep(500);

		From.GraduationBoard("Siksha ‘O’ Anusandhan University, Bhubaneswar");

		Thread.sleep(500);

		From.GraduationYOP("2021");

		Thread.sleep(400);

		From.GraduationStream("BTech");
		Thread.sleep(400);
		From.CoreorHons("Chemical");

		Thread.sleep(400);
		From.PGSubjectofAdmission("Linguistics");

		Thread.sleep(400);

		//From.CollegeorUniversityPreference("Ravenshaw University, Cuttack");

		Thread.sleep(400);
		From.FirstPreference("Berhampur University, Bhanja Vihar, Berhampur");
		Thread.sleep(400);

		From.SecondPreference("Bhadrak (Autonomous) College,Bhadrak");
		Thread.sleep(400);
		From.ThirdPreference("Dharanidhar (Autonomous) College, Keonjhar");
		Thread.sleep(400);

		From.ADD().click();
		Thread.sleep(400);

		From.EducationalQualificationNext1().click();

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 41, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 41, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully checked applying of CAF By PG Appearing Applicant scenario");
	}
}
