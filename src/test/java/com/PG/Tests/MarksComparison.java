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

public class MarksComparison extends BaseClass implements PGCAFData{

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
	public void MaximumMarkcannotbelessthanMarkObtained() throws Exception {

		//logger = report.createTest("Verifying Maximum Mark cannot be less than mark obtained!");

		PGCAFNew From = new PGCAFNew(driver);

		Thread.sleep(400);
		From.BasicInformationDetails();
		Thread.sleep(400);
		From.AdditionalDetails();
		Thread.sleep(400);

		From.GraduationPassed().click();
		Thread.sleep(500);

		From.GraduationWithDistinction().click();
		Thread.sleep(500);

		ExtentFactory.getInstance().getExtent().info("Entering Maximum Mark which is less than Obtained Mark");

		From.TenthMaxMark().sendKeys("600");
		Thread.sleep(500);

		ExtentFactory.getInstance().getExtent().info("Entering Obtained Mark which is greater than Maximum Mark");

		From.TenthSecuredMarksorCGPA().sendKeys("786");
		Thread.sleep(400);

		From.EducationalQualificationNext1().click();

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Maximum Mark cannot be less than mark obtained!"))

		{
			constants.fileone.setCellData(sheetName, "Status", 43, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationOk().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 43, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Maximum Mark cannot be less than mark obtained!", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Maximum Mark cannot be less than mark obtained scenario");
	}

	@Test(priority = 2)
	public void ObtainedMarkIslessthanMaxMark() throws Exception {

		//logger = report.createTest("Verifying Obtained Mark is less than Maximum Mark");

		PGCAFNew From = new PGCAFNew(driver);

		Thread.sleep(400);
		From.TenthMaxMark().clear();
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Maximum Mark which is greater than Obtained Mark for 10th");
		From.TenthMaxMark().sendKeys("600");
		Thread.sleep(400);

		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Obtained Mark which is less than Maximum Mark for 10th");
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

		ExtentFactory.getInstance().getExtent().info("Entering Maximum Mark which is greater than Obtained Mark for 12th");
		From.PlusTwoMaxMark().sendKeys("600");
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Obtained Mark which is less than Maximum Mark for 12th");
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

		ExtentFactory.getInstance().getExtent().info("Entering Maximum Mark which is greater than Obtained Mark for Graduation");
		From.GraduationMaxMark().sendKeys("600");
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Obtained Mark which is less than Maximum Mark for Graduation");
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
		Thread.sleep(400);

		From.ADD().click();
		Thread.sleep(400);

		From.EducationalQualificationNext1().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 44, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 44, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Obtained Mark is less than Maximum Mark scenario");

	}

	@Test(priority = 3)
	public void ObtainedMarkIsEqualtoMaxMark() throws Exception {

		//logger = report.createTest("Verifying Obtained Mark is equal to Maximum Mark");

		PGCAFNew From = new PGCAFNew(driver);

		Thread.sleep(400);
		From.TenthMaxMark().clear();
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Maximum Mark which is equal to Obtained Mark for 10th");
		From.TenthMaxMark().sendKeys("600");
		Thread.sleep(400);

		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Obtained Mark which is equal to Maximum Mark for 10th");
		From.TenthSecuredMarksorCGPA().sendKeys("600");
		Thread.sleep(500);

		Thread.sleep(500);
		From.EducationalQualificationOk().click();
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

		ExtentFactory.getInstance().getExtent().info("Entering Maximum Mark which is equal to Obtained Mark for 12th");
		From.PlusTwoMaxMark().sendKeys("600");
		Thread.sleep(400);

		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Obtained Mark which is equal to Maximum Mark for 12th");
		From.PlusTwoSecuredMarksorCGPA().sendKeys("600");
		Thread.sleep(500);

		From.EducationalQualificationOk().click();
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

		Thread.sleep(4000);
		From.GraduationMaxMark().clear();
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Maximum Mark which is equal to Obtained Mark for Graduation");
		From.GraduationMaxMark().sendKeys("600");
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Obtained Mark which is equal to Maximum Mark for Graduation");
		From.GraduationSecuredMarksorCGPA().sendKeys("600");

		Thread.sleep(500);
		From.EducationalQualificationOk().click();
		Thread.sleep(500);

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

		From.EducationalQualificationNext1().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Are you sure want to proceed ?"))

		{
			constants.fileone.setCellData(sheetName, "Status", 45, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 45, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Obtained Mark can be equal to Maximum Mark scenario");
	}

	@Test(priority = 4)
	public void TwelthMaximumMarkcannotbelessthanMarkObtained() throws Exception {

		//logger = report.createTest("Verifying Twelth Maximum Mark cannot be less than mark obtained!");

		PGCAFNew From = new PGCAFNew(driver);

		Thread.sleep(400);

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
		//logger = report.createTest("Entering Twelth Maximum Mark");
		From.PlusTwoMaxMark().sendKeys("600");
		Thread.sleep(400);
		From.EducationalQualificationOk().click();
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		//logger = report.createTest("Entering Twelth Secured Mark");
		From.PlusTwoSecuredMarksorCGPA().sendKeys("786");
		Thread.sleep(600);
		From.EducationalQualificationNext1().click();

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Maximum Mark cannot be less than mark obtained!"))

		{
			constants.fileone.setCellData(sheetName, "Status", 46, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationOk().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 46, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Maximum Mark cannot be less than mark obtained!", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Twelth Maximum Mark cannot be less than mark obtained scenario");
	}

	@Test(priority = 5)
	public void GraduateMaximumMarkcannotbelessthanMarkObtained() throws Exception {

		//logger = report.createTest("Verifying Graduate Maximum Mark cannot be less than mark obtained!");

		PGCAFNew From = new PGCAFNew(driver);

		Thread.sleep(400);

		Thread.sleep(500);
		From.GraduationStream("BTech");

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
		ExtentFactory.getInstance().getExtent().info("Entering Graduate MaxMark");
		From.GraduationMaxMark().sendKeys("600");

		Thread.sleep(400);
		From.EducationalQualificationOk().click();
		Thread.sleep(400);
		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		ExtentFactory.getInstance().getExtent().info("Entering Graduate SecuredMark");
		From.GraduationSecuredMarksorCGPA().sendKeys("786");
		Thread.sleep(400);

		From.GraduationStream("BTech");

		Thread.sleep(600);
		From.EducationalQualificationNext1().click();
		Thread.sleep(600);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Maximum Mark cannot be less than mark obtained!"))

		{
			constants.fileone.setCellData(sheetName, "Status", 47, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationOk().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 47, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Maximum Mark cannot be less than mark obtained!", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Graduate Maximum Mark cannot be less than mark obtained scenario");
	}

}
