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

public class CGPAComparision extends BaseClass implements PGCAFData {

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
	public void TenthObtainedCGPAMarkShouldNotBeGreaterThanMaximumMark() throws Exception {

		// logger = report.createTest("Verifying Tenth Maximum CGPA cannot be less than
		// Obtained CGPA");

		PGCAFNew From = new PGCAFNew(driver);

		Thread.sleep(400);
		From.BasicInformationDetails();
		Thread.sleep(500);

		From.AdditionalDetails();
		Thread.sleep(500);

		From.GraduationPassed().click();

		Thread.sleep(500);

		From.GraduationWithDistinction().click();

		From.TenthMarkType("CGPA");
		Thread.sleep(400);

		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		// logger = report.createTest("Entering Tenth CGPA Secured Mark");
		From.TenthSecuredMarksorCGPA().sendKeys("12");
		Thread.sleep(500);

		From.EducationalQualificationNext1().click();

		Thread.sleep(400);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("Maximum Mark cannot be less than mark obtained!"))

		{
			constants.fileone.setCellData(sheetName, "Status", 48, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationOk().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 48, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Maximum Mark cannot be less than mark obtained!", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Tenth CGPA Mark cannot be less than mark obtained scenario");
	}

	@Test(priority = 2)
	public void TwelthObtainedCGPAShouldNotBeGreaterThanMaxCGPA() throws Exception {

		// logger = report.createTest("Verifying Twelth Maximum CGPA cannot be less than
		// Obtained CGPA");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		From.TenthMarkType("CGPA");
		Thread.sleep(400);

		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.TenthSecuredMarksorCGPA().sendKeys("10");
		Thread.sleep(500);
		From.PlusTwoStream("Science");

		Thread.sleep(500);
		From.PlusTwoMarkType("CGPA");

		Thread.sleep(500);
		From.PlusTwoBoard("CHSE, Odisha");

		Thread.sleep(500);
		From.PlusTwoYOP("2018");

		Thread.sleep(400);
		From.PlusTwoRollNo().clear();
		Thread.sleep(400);
		From.PlusTwoRollNo().sendKeys("41TC178");
		Thread.sleep(400);

		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		// logger = report.createTest("Entering Plus Two CGPA Secured");
		From.PlusTwoSecuredMarksorCGPA().sendKeys("12");

		Thread.sleep(500);

		From.EducationalQualificationNext1().click();

		Thread.sleep(500);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("Maximum Mark cannot be less than mark obtained!"))

		{
			constants.fileone.setCellData(sheetName, "Status", 49, "Pass");
			Thread.sleep(300);
			From.PopUpOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 49, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Maximum Mark cannot be less than mark obtained!", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Twelth CGPA Mark cannot be less than mark obtained scenario");
	}

	@Test(priority = 3)
	public void GraduateObtainedCGPAShouldNotBeGreaterThanMaxCGPA() throws Exception {

		// logger = report.createTest("Verifying Graduate Maximum CGPA cannot be less
		// than Obtained CGPA");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		From.PlusTwoStream("Science");

		Thread.sleep(500);
		From.PlusTwoMarkType("CGPA");

		Thread.sleep(500);
		From.PlusTwoBoard("CHSE, Odisha");

		Thread.sleep(500);
		From.PlusTwoYOP("2018");

		Thread.sleep(400);
		From.PlusTwoRollNo().clear();
		Thread.sleep(400);
		From.PlusTwoRollNo().sendKeys("41TC178");
		Thread.sleep(400);

		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.PlusTwoSecuredMarksorCGPA().sendKeys("7.5");

		Thread.sleep(500);

		From.GraduationStream("BTech");
		Thread.sleep(500);
		From.GraduationMarkType("CGPA");
		Thread.sleep(500);

		From.GraduationBoard("Siksha ‘O’ Anusandhan University, Bhubaneswar");

		Thread.sleep(500);
		From.GraduationYOP("2021");

		Thread.sleep(400);
		From.GraduationRollNo().clear();
		Thread.sleep(400);
		From.GraduationRollNo().sendKeys("51TC678");

		Thread.sleep(400);
		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		// logger = report.createTest("Entering Graduate CGPA Secured Mark");
		From.GraduationSecuredMarksorCGPA().sendKeys("12");
		Thread.sleep(400);
		From.EducationalQualificationNext1().click();

		Thread.sleep(500);

		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (actualPopup.contains("Maximum Mark cannot be less than mark obtained!"))

		{
			constants.fileone.setCellData(sheetName, "Status", 50, "Pass");
			Thread.sleep(300);
			From.PopUpOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 50, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Maximum Mark cannot be less than mark obtained!", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Graduate CGPA Mark cannot be less than mark obtained scenario");
	}

	@Test(priority = 4)
	public void ObtainedCGPAShouldBeLessThanMaxCGPA() throws Exception {

		// logger = report.createTest("Verifying Obtained CGPA Should Be Less Than Max
		// CGPA");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);
		From.TenthMarkType("CGPA");
		Thread.sleep(400);

		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().sendKeys("7.5");
		Thread.sleep(500);
		From.PlusTwoStream("Science");

		Thread.sleep(500);
		From.PlusTwoMarkType("CGPA");

		Thread.sleep(500);
		From.PlusTwoBoard("CHSE, Odisha");

		Thread.sleep(500);
		From.PlusTwoYOP("2018");

		Thread.sleep(400);
		From.PlusTwoRollNo().clear();
		Thread.sleep(400);
		From.PlusTwoRollNo().sendKeys("41TC178");
		Thread.sleep(400);

		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().sendKeys("7.5");

		Thread.sleep(500);

		From.GraduationStream("BTech");
		Thread.sleep(500);
		From.GraduationMarkType("CGPA");
		Thread.sleep(500);

		From.GraduationBoard("Siksha ‘O’ Anusandhan University, Bhubaneswar");

		Thread.sleep(500);

		From.GraduationYOP("2021");

		Thread.sleep(400);
		From.GraduationRollNo().clear();
		Thread.sleep(400);
		From.GraduationRollNo().sendKeys("51TC678");

		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("7.5");

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
			constants.fileone.setCellData(sheetName, "Status", 51, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 51, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Obtained CGPA Mark Less Than Maximum Mark");
	}

	@Test(priority = 5)
	public void ObtainedCGPAIsEqualToMaxCGPA() throws Exception {

		// logger = report.createTest("Verifying Obtained CGPA Should Be Equal Than Max
		// CGPA");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		From.TenthMarkType("CGPA");
		Thread.sleep(400);

		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().sendKeys("10");
		Thread.sleep(500);
		From.PlusTwoStream("Science");

		Thread.sleep(500);
		From.PlusTwoMarkType("CGPA");

		Thread.sleep(500);
		From.PlusTwoBoard("CHSE, Odisha");

		Thread.sleep(500);
		From.PlusTwoYOP("2018");

		Thread.sleep(400);
		From.PlusTwoRollNo().clear();
		Thread.sleep(400);
		From.PlusTwoRollNo().sendKeys("41TC178");
		Thread.sleep(400);

		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().sendKeys("10");

		Thread.sleep(500);

		From.GraduationStream("BTech");
		Thread.sleep(500);
		From.GraduationMarkType("CGPA");
		Thread.sleep(500);

		From.GraduationBoard("Siksha ‘O’ Anusandhan University, Bhubaneswar");

		Thread.sleep(500);

		From.GraduationYOP("2021");

		Thread.sleep(400);
		From.GraduationRollNo().clear();
		Thread.sleep(400);
		From.GraduationRollNo().sendKeys("51TC678");

		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("10");

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
			constants.fileone.setCellData(sheetName, "Status", 52, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 52, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Obtained CGPA Mark Equal To Maximum Mark");
	}

}