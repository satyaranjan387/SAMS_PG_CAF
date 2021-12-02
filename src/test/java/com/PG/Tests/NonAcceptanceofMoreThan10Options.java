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

public class NonAcceptanceofMoreThan10Options extends BaseClass implements PGCAFData{

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
	public void NonAcceptanceMoreThanTenCollegeOptions() throws Exception {

		//logger = report.createTest("Verify the NonAcceptance Of More Than Ten College Options");
		
		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		From.BasicInformationDetails();
		Thread.sleep(500);

		From.AdditionalDetails();
		Thread.sleep(500);

		From.GraduationPassed().click();

		Thread.sleep(500);

		From.GraduationWithDistinction().click();

		From.TenthMaxMark().clear();
		Thread.sleep(400);
		From.TenthMaxMark().sendKeys("600");
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().sendKeys("455");
		Thread.sleep(500);
		From.PlusTwoStream("Science");

		Thread.sleep(500);
		From.PlusTwoMarkType("MARK");

		Thread.sleep(500);
		From.PlusTwoBoard("CHSE, Odisha");

		Thread.sleep(500);
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

		From.GraduationMarkType("MARK");
		Thread.sleep(500);

		From.GraduationBoard("Siksha ‘O’ Anusandhan University, Bhubaneswar");

		Thread.sleep(500);
		From.GraduationStream("Science");
		Thread.sleep(500);
		From.GraduationYOP("2021");

		Thread.sleep(400);
		From.GraduationRollNo().clear();
		Thread.sleep(400);
		From.GraduationRollNo().sendKeys("51TC678");

		Thread.sleep(400);
		From.GraduationMaxMark().clear();
		Thread.sleep(400);
		From.GraduationMaxMark().sendKeys("600");

		Thread.sleep(400);
		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("300");

		Thread.sleep(500);
		From.GraduationStream("Arts");
		Thread.sleep(500);

		Thread.sleep(400);
		From.Hons1().click();

		Thread.sleep(400);
		From.CoreorHons("Economics");
		Thread.sleep(400);

		From.GraduationElective1("Education");

		Thread.sleep(300);
		From.Credit1("84");
		Thread.sleep(300);
		From.Elective1Credit1("24");

		Thread.sleep(400);
		From.PGSubjectofAdmission("Economics");
		Thread.sleep(400);
		String[] arrData = { "Berhampur University, Bhanja Vihar, Berhampur", "Ravenshaw University, Cuttack",
				"Sri Krushna Chandra Gajapati (Autonomous) College, Paralakhemundi",
				"Rayagada (Autonomous) College, Rayagada",
				"Government (Autonomous) College,Bhawanipatna (Kalahandi University)",
				"Government (Autonomous) College, Angul", "Government College, Sundergarh",
				"Bhadrak (Autonomous) College,Bhadrak", "Sambalpur University, Jyoti Vihar, Sambalpur",
				"Khallikote (Autonomous) College, Berhampur", "Panchayat Degree College,Bargarh" };
		Thread.sleep(400);
		for (int i = 0; i < arrData.length; i++) {

			Thread.sleep(400);

			// Thread.sleep(500);
			//From.CollegeorUniversityPreference(arrData[i]);
			From.ADD().click();
			Thread.sleep(400);

		}
		Thread.sleep(400);
		From.FirstPreference("Berhampur University, Bhanja Vihar, Berhampur");
		Thread.sleep(400);

		From.SecondPreference("Bhadrak (Autonomous) College,Bhadrak");
		Thread.sleep(400);
		From.ThirdPreference("Dharanidhar (Autonomous) College, Keonjhar");
		Thread.sleep(1000);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("More than 10 options can not be selected"))

		{
			constants.fileone.setCellData(sheetName, "Status", 243, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationOk().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 243, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "More than 10 options can not be selected", "Test Failed");
		
		softAssert.assertAll();
		
		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked By More than  10 options can not be selected Scenario");
	}

}