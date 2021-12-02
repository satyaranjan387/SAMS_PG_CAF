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

public class Zoology extends BaseClass implements PGCAFData {

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
	public void ZoologyWithAtleast45Percentage() throws Exception {

		// logger = report.createTest("Verify Zoology Apply Atleast 45 Percentage");

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

		From.GraduationSecuredMarksorCGPA().sendKeys("275");
		String[] arrData = { "Zoology", "Animal Science" };

		for (int i = 0; i < arrData.length; i++) {

			System.out.println(arrData[i]);

			Thread.sleep(500);
			From.GraduationStream("Arts");

			Thread.sleep(500);
			From.GraduationStream("Science");

			Thread.sleep(400);
			From.Hons1().click();

			Thread.sleep(400);
			From.CoreorHons(arrData[i]);
			Thread.sleep(400);

			Thread.sleep(300);

			From.GraduationElective1("Physics");

			Thread.sleep(300);
			From.Credit1("84");
			Thread.sleep(300);
			From.Elective1Credit1("24");

			ExtentFactory.getInstance().getExtent().info("Selecting Zoology");
			Thread.sleep(400);
			From.PGSubjectofAdmission("Zoology");

			Thread.sleep(400);

			// Thread.sleep(500);
			//From.CollegeUniversity();

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
				constants.fileone.setCellData(sheetName, "Status", 233, "Pass");
				Thread.sleep(300);
				From.EducationalQualificationCancel().click();
			}

			else {
				constants.fileone.setCellData(sheetName, "Status", 233, "Fail");
			}
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

			softAssert.assertAll();

			ExtentFactory.getInstance().getExtent()
					.info("Successfully Checked Zoology Pg Department Atleast 45 Percentage scenario");
		}

	}

	@Test(priority = 2)
	public void ZoologyDepartmentWithLessThan45Percentage() throws Exception {

		// logger = report.createTest("Verify Zoology Department Not Apply Less Than 45
		// Percentage");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		Thread.sleep(500);

		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("260");

		String[] arrData = { "Zoology", "Animal Science" };

		for (int i = 0; i < arrData.length; i++) {

			System.out.println(arrData[i]);

			Thread.sleep(500);
			From.GraduationStream("Arts");

			Thread.sleep(500);
			From.GraduationStream("Science");

			Thread.sleep(400);
			From.Hons1().click();

			Thread.sleep(400);
			From.CoreorHons(arrData[i]);
			Thread.sleep(400);

			Thread.sleep(300);

			From.GraduationElective1("Physics");

			Thread.sleep(300);
			From.Credit1("84");
			Thread.sleep(300);
			From.Elective1Credit1("24");

			ExtentFactory.getInstance().getExtent().info("Selecting Zoology");
			Thread.sleep(400);
			From.PGSubjectofAdmission("Zoology");

			Thread.sleep(400);

			// Thread.sleep(500);
			//From.CollegeUniversity();

			Thread.sleep(400);
			From.FirstPreference("Berhampur University, Bhanja Vihar, Berhampur");
			Thread.sleep(400);

			From.SecondPreference("Bhadrak (Autonomous) College,Bhadrak");
			Thread.sleep(400);
			From.ThirdPreference("Dharanidhar (Autonomous) College, Keonjhar");
			Thread.sleep(400);

			From.ADD().click();
			Thread.sleep(400);

			String actualPopup = From.PopUpMsg().getText();
			System.out.println(actualPopup);
			ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
			if (actualPopup.contains("Graduation Percentage cannot be less than 45"))

			{
				constants.fileone.setCellData(sheetName, "Status", 234, "Pass");
				Thread.sleep(300);
				From.EducationalQualificationOk().click();
			}

			else {
				constants.fileone.setCellData(sheetName, "Status", 234, "Fail");
			}
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualPopup, "Graduation Percentage cannot be less than 45", "Test Failed");

			softAssert.assertAll();

			ExtentFactory.getInstance().getExtent()
					.info("Successfully Checked Zoology Pg Department Not Apply Less Than 45 Percentage scenario");
		}

	}
}