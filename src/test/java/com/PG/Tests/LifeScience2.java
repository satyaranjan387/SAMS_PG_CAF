package com.PG.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PG.Listener.ExtentFactory;
import com.PG.browser.BrowserFactoryNew;
import com.PG.genericLibrary.constants;
import com.PG.objectRepository.BaseClass;
import com.PG.objectRepository.PGCAFData;
import com.PG.objectRepository.PGCAFNew;

public class LifeScience2 extends BaseClass implements PGCAFData {

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
	public void LifeScienceWithAtleast45percentage() throws Exception {

		// logger = report.createTest("Verify Life Science Apply Atleast 45
		// Percentage");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		From.BasicInformationDetails();
		Thread.sleep(450);

		From.AdditionalDetails();
		Thread.sleep(450);

		From.GraduationPassed().click();

		Thread.sleep(450);

		From.GraduationWithDistinction().click();

		From.TenthMaxMark().clear();
		Thread.sleep(400);
		From.TenthMaxMark().sendKeys("600");
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().sendKeys("455");
		Thread.sleep(450);
		From.PlusTwoStream("Science");

		Thread.sleep(450);
		From.PlusTwoMarkType("MARK");

		Thread.sleep(450);
		From.PlusTwoBoard("CHSE, Odisha");

		Thread.sleep(450);
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

		Thread.sleep(450);

		From.GraduationMarkType("MARK");
		Thread.sleep(450);

		From.GraduationBoard("Siksha ‘O’ Anusandhan University, Bhubaneswar");

		Thread.sleep(450);

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
		String[] arrData = { "Science" };

		for (int i = 0; i < arrData.length; i++) {

			System.out.println(arrData[i]);

			From.GraduationStream(arrData[i]);

			Thread.sleep(400);
			Select select = new Select(driver.findElement(By.id("ddlGraduationStream")));
			Thread.sleep(400);
			WebElement option = select.getFirstSelectedOption();
			Thread.sleep(400);
			String defaultItem = option.getText();
			Thread.sleep(400);

			System.out.println(defaultItem);

			if (defaultItem.equals("Science")) {
				Thread.sleep(300);
				String[] arrData1 = { "Physics", "Chemistry", "Botany", "Zoology", "Biotechnology", "Mathematics" };
				for (int j = 0; j < arrData1.length; j++) {
					Thread.sleep(450);
					From.GraduationStream("Arts");

					Thread.sleep(450);
					From.GraduationStream("Science");

					Thread.sleep(300);
					From.Hons1().click();

					System.out.println(arrData1[j]);

					From.CoreorHons(arrData1[j]);

					Thread.sleep(300);
					From.GraduationElective1("Biochemistry");

					Thread.sleep(300);
					From.Credit1("84");
					Thread.sleep(300);
					From.Elective1Credit1("24");
					ExtentFactory.getInstance().getExtent().info("Selecting LifeScience");
					Thread.sleep(400);
					From.PGSubjectofAdmission("Life Science");

					Thread.sleep(400);

					// Thread.sleep(450);
					// From.CollegeorUniversityPreference("Government (Autonomous) College,
					// Phulbani");

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
						constants.fileone.setCellData(sheetName, "Status", 149, "Pass");
						Thread.sleep(300);
						From.EducationalQualificationCancel().click();
					}

					else {
						constants.fileone.setCellData(sheetName, "Status", 149, "Fail");
					}
					SoftAssert softAssert = new SoftAssert();
					softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

					softAssert.assertAll();

					ExtentFactory.getInstance().getExtent()
							.info("Successfully Checked LifeScience PG Department Atleast 45 Percentage");
				}
			}
		}
	}

	@Test(priority = 2)
	public void LifeScienceWithLessThan45Percentage() throws Exception {

		// logger = report.createTest("Verify Life Science with Less Than 45
		// Percentage");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		Thread.sleep(450);

		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("260");

		String[] arrData = { "Science" };

		for (int i = 0; i < arrData.length; i++) {

			System.out.println(arrData[i]);

			From.GraduationStream(arrData[i]);

			Thread.sleep(400);
			Select select = new Select(driver.findElement(By.id("ddlGraduationStream")));
			Thread.sleep(400);
			WebElement option = select.getFirstSelectedOption();
			Thread.sleep(400);
			String defaultItem = option.getText();
			Thread.sleep(400);

			System.out.println(defaultItem);

			if (defaultItem.equals("Science")) {
				Thread.sleep(300);
				String[] arrData1 = { "Physics", "Chemistry", "Botany", "Zoology", "Biotechnology", "Mathematics" };
				for (int j = 0; j < arrData1.length; j++) {
					Thread.sleep(450);
					From.GraduationStream("Arts");

					Thread.sleep(450);
					From.GraduationStream("Science");

					Thread.sleep(300);
					From.Hons1().click();

					System.out.println(arrData1[j]);

					From.CoreorHons(arrData1[j]);

					Thread.sleep(300);
					From.GraduationElective1("Biochemistry");

					Thread.sleep(300);
					From.Credit1("84");
					Thread.sleep(300);
					From.Elective1Credit1("24");
					ExtentFactory.getInstance().getExtent().info("Selecting LifeScience");
					Thread.sleep(400);
					From.PGSubjectofAdmission("Life Science");

					Thread.sleep(400);

					// Thread.sleep(450);
					// From.CollegeorUniversityPreference("Government (Autonomous) College,
					// Phulbani");

					Thread.sleep(400);
					From.FirstPreference("Berhampur University, Bhanja Vihar, Berhampur");
					Thread.sleep(400);

					From.SecondPreference("Bhadrak (Autonomous) College,Bhadrak");
					Thread.sleep(400);
					From.ThirdPreference("Dharanidhar (Autonomous) College, Keonjhar");
					Thread.sleep(400);

					From.ADD().click();
					Thread.sleep(400);

					Thread.sleep(400);

					String actualPopup = From.PopUpMsg().getText();
					System.out.println(actualPopup);
					ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
					if (actualPopup.contains("Graduation Percentage cannot be less than 45"))

					{
						constants.fileone.setCellData(sheetName, "Status", 150, "Pass");
						Thread.sleep(300);
						From.EducationalQualificationOk().click();
					}

					else {
						constants.fileone.setCellData(sheetName, "Status", 150, "Fail");
					}
					SoftAssert softAssert = new SoftAssert();
					softAssert.assertEquals(actualPopup, "Graduation Percentage cannot be less than 45", "Test Failed");

					softAssert.assertAll();

					ExtentFactory.getInstance().getExtent()
							.info("Successfully Checked LifeScience Pg Department Not Apply Less Than 45 Percentage");
				}
			}
		}
	}
}