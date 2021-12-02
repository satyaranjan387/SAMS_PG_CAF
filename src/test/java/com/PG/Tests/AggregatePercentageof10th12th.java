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

public class AggregatePercentageof10th12th extends BaseClass implements PGCAFData{

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
	public void LessThan33Percentage() throws Exception {

		//logger = report.createTest("Verifying percentage of 10th with less than 33% aggregate");

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
		From.TenthSecuredMarksorCGPA().sendKeys("56");
		Thread.sleep(500);

		From.EducationalQualificationNext1().click();

		Thread.sleep(700);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("10th Percentage cannot be less than 33"))

		{
			constants.fileone.setCellData(sheetName, "Status", 53, "Pass");
			Thread.sleep(300);
			From.PopUpOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 53, "Fail");
		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "10th Percentage cannot be less than 33", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked for 10th with less than 33% aggregate");
	}

	@Test(priority = 2)
	public void Equalto33Percentage() throws Exception {

		//logger = report.createTest("Verifying percentage of 10th with equal to  33% aggregate");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(1000);

		From.TenthMaxMark().clear();
		Thread.sleep(1000);
		From.TenthMaxMark().sendKeys("600");
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().sendKeys("200");
		Thread.sleep(500);

		From.PopUpOK().click();

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

		From.GraduationStream("BTech");

		Thread.sleep(500);
		From.GraduationMarkType("MARK");
		Thread.sleep(500);

		From.GraduationBoard("Siksha ‘O’ Anusandhan University, Bhubaneswar");

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

		From.GraduationSecuredMarksorCGPA().sendKeys("455");

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
		Thread.sleep(1000);

		From.ADD().click();

		Thread.sleep(400);
		From.EducationalQualificationNext1().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 54, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 54, "Fail");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked for 10th with more than or equal to 33% aggregate");
	}

	@Test(priority = 3)
	public void Morethan33Percentage() throws Exception {

		//logger = report.createTest("Verifying percentage of 10th with Morethan  33% aggregate");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(1000);

		From.TenthMaxMark().clear();
		Thread.sleep(1000);
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
		From.PopUpOK().click();
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

		From.GraduationYOP("2021");

		Thread.sleep(400);
		From.GraduationRollNo().clear();
		Thread.sleep(400);
		From.GraduationRollNo().sendKeys("51TC678");

		Thread.sleep(400);
		From.GraduationMaxMark().clear();
		Thread.sleep(400);
		From.GraduationMaxMark().sendKeys("600");
		From.PopUpOK().click();
		Thread.sleep(400);
		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("455");

		Thread.sleep(400);

		Thread.sleep(400);
		From.GraduationStream("BTech");
		Thread.sleep(400);
		From.CoreorHons("Chemical");

		Thread.sleep(400);
		From.PGSubjectofAdmission("Environmental Economics");

		Thread.sleep(400);

		//From.CollegeorUniversityPreference("Maharaja Purna Chandra (Autonomous) College, Baripada");

		Thread.sleep(400);
		From.FirstPreference("Berhampur University, Bhanja Vihar, Berhampur");
		Thread.sleep(400);

		From.SecondPreference("Bhadrak (Autonomous) College,Bhadrak");
		Thread.sleep(400);
		From.ThirdPreference("Dharanidhar (Autonomous) College, Keonjhar");
		Thread.sleep(1000);

		From.ADD().click();

		Thread.sleep(400);
		From.EducationalQualificationNext1().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 55, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 55, "Fail");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked for 10th with more than  33% aggregate");
	}

	@Test(priority = 4)
	public void Morethan33PercentageofTwelth() throws Exception {

		//logger = report.createTest("Verifying percentage of 12th with Morethan  33% aggregate");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(1000);

		From.TenthMaxMark().clear();
		Thread.sleep(1000);
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
		From.PopUpOK().click();
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

		From.GraduationYOP("2021");

		Thread.sleep(400);
		From.GraduationRollNo().clear();
		Thread.sleep(400);
		From.GraduationRollNo().sendKeys("51TC678");

		Thread.sleep(400);
		From.GraduationMaxMark().clear();
		Thread.sleep(400);
		From.GraduationMaxMark().sendKeys("600");
		From.PopUpOK().click();
		Thread.sleep(400);
		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("455");

		Thread.sleep(400);

		From.GraduationStream("BTech");
		Thread.sleep(400);
		From.CoreorHons("Chemical");

		Thread.sleep(400);
		From.PGSubjectofAdmission("Political Science");

		Thread.sleep(400);

		// Thread.sleep(500);
		//From.CollegeorUniversityPreference("Berhampur University, Bhanja Vihar, Berhampur");

		Thread.sleep(400);
		From.FirstPreference("Berhampur University, Bhanja Vihar, Berhampur");
		Thread.sleep(400);

		From.SecondPreference("Bhadrak (Autonomous) College,Bhadrak");
		Thread.sleep(400);
		From.ThirdPreference("Dharanidhar (Autonomous) College, Keonjhar");
		Thread.sleep(1000);

		From.ADD().click();

		Thread.sleep(400);
		From.EducationalQualificationNext1().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 56, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 56, "Fail");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked for 12th with more than  33% aggregate");
	}

	@Test(priority = 5)
	public void Equalto33PercentageofTwelth() throws Exception {

		//logger = report.createTest("Verifying percentage of 12th with Equalto  33% aggregate");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(1000);

		From.TenthMaxMark().clear();
		Thread.sleep(1000);
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
		From.PopUpOK().click();
		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().sendKeys("200");

		Thread.sleep(500);

		From.GraduationStream("BTech");

		Thread.sleep(500);
		From.GraduationMarkType("MARK");
		Thread.sleep(500);

		From.GraduationBoard("Siksha ‘O’ Anusandhan University, Bhubaneswar");

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
		From.PopUpOK().click();
		Thread.sleep(400);
		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("455");

		Thread.sleep(400);

//		From.GraduationStream("BTech");
//		Thread.sleep(400);
//		From.CoreorHons("Chemical");
//
//		Thread.sleep(400);
//		From.PGSubjectofAdmission("Population Studies");
//
//		Thread.sleep(400);

		//From.CollegeorUniversityPreference("Fakir Mohan University, Vyasa Vihar, Balasore");

//		Thread.sleep(400);
//		From.FirstPreference("Berhampur University, Bhanja Vihar, Berhampur");
//		Thread.sleep(400);
//
//		From.SecondPreference("Bhadrak (Autonomous) College,Bhadrak");
//		Thread.sleep(400);
//		From.ThirdPreference("Dharanidhar (Autonomous) College, Keonjhar");
//		Thread.sleep(1000);
//
//		From.ADD().click();

		Thread.sleep(600);
		From.EducationalQualificationNext1().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 57, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 57, "Fail");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked for 12th with equal to  33% aggregate");
	}

	@Test(priority = 6)
	public void LessThan33PercentageofTwelth() throws Exception {

		//logger = report.createTest("Verifying percentage of 12th with less than 33% aggregate");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		From.TenthMaxMark().clear();
		Thread.sleep(400);
		From.TenthMaxMark().sendKeys("600");
		From.PopUpOK().click();
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().sendKeys("456");
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
		From.PopUpOK().click();
		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().sendKeys("20");
		Thread.sleep(400);
		From.EducationalQualificationNext1().click();

		Thread.sleep(700);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("Plus Two Percentage cannot be less than 33"))

		{
			constants.fileone.setCellData(sheetName, "Status", 58, "Pass");
			Thread.sleep(300);
			From.PopUpOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 58, "Fail");
		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Plus Two Percentage cannot be less than 33", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked for 12th with less than 33% aggregate");
	}

}
