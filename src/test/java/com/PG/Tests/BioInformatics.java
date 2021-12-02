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

public class BioInformatics extends BaseClass implements PGCAFData {

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
	public void BioInformaticsWithAtleast50Percentage() throws Exception {

		// logger = report.createTest("VerifyBioInformaticsApplyAtleast50Percentage");

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
		From.TenthSecuredMarksorCGPA().sendKeys("505");
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
		From.PlusTwoSecuredMarksorCGPA().sendKeys("505");

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

		From.GraduationSecuredMarksorCGPA().sendKeys("300");
		String[] arrData = { "Science", "BTech", "BE" };

		for (int i = 0; i < arrData.length; i++) {

			System.out.println(arrData[i]);

			From.GraduationStream(arrData[i]);

			Thread.sleep(400);

			From.GraduationStream(arrData[i]);
			Thread.sleep(400);
			Select select = new Select(driver.findElement(By.id("ddlGraduationStream")));
			Thread.sleep(400);
			WebElement option = select.getFirstSelectedOption();
			Thread.sleep(400);
			String defaultItem = option.getText();
			Thread.sleep(400);

			System.out.println(defaultItem);

			if (defaultItem.equals("BTech")) {

				From.CoreorHons("BTech");

			} else if (defaultItem.equals("BE")) {
				From.CoreorHons("BE");
			}

			else if (defaultItem.equals("Science")) {
				Thread.sleep(300);
				String[] arrData1 = { "Physics", "Chemistry", "Botany", "Zoology", "Mathematics" };
				for (int j = 0; j < arrData1.length; j++) {
					Thread.sleep(500);
					From.GraduationStream("Arts");

					Thread.sleep(500);
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
					ExtentFactory.getInstance().getExtent().info("Selecting BioInformatics");
					Thread.sleep(400);
					From.PGSubjectofAdmission("Bio Informatics");

					Thread.sleep(400);

					// From.CollegeorUniversityPreference("Sambalpur University, Jyoti Vihar,
					// Sambalpur");
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

					Thread.sleep(300);
					From.EducationalQualificationCancel().click();
				}
			}

			if (defaultItem.equals("BTech") || defaultItem.equals("BE")) {

				ExtentFactory.getInstance().getExtent().info("Selecting BioInformatics");
				Thread.sleep(400);
				From.PGSubjectofAdmission("Bio Informatics");

				Thread.sleep(400);

				// From.CollegeorUniversityPreference("Sambalpur University, Jyoti Vihar,
				// Sambalpur");

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
					constants.fileone.setCellData(sheetName, "Status", 93, "Pass");
					Thread.sleep(300);
					From.EducationalQualificationCancel().click();
				}

				else {
					constants.fileone.setCellData(sheetName, "Status", 93, "Fail");
				}
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

				softAssert.assertAll();

				ExtentFactory.getInstance().getExtent()
						.info("Successfully Checked Bio-Informatics PG Department Atleast 50 Percentage");
			}
		}
	}

	@Test(priority = 2)
	public void BioInformaticsWithLessThan50Percentage() throws Exception {

		// logger = report.createTest("Verify Bio-Informatics with Less Than 50
		// Percentage");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		Thread.sleep(500);

		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("298");

		String[] arrData = { "Science", "BTech", "BE" };

		for (int i = 0; i < arrData.length; i++) {

			System.out.println(arrData[i]);

			From.GraduationStream(arrData[i]);

			Thread.sleep(400);

			From.GraduationStream(arrData[i]);
			Thread.sleep(400);
			Select select = new Select(driver.findElement(By.id("ddlGraduationStream")));
			Thread.sleep(400);
			WebElement option = select.getFirstSelectedOption();
			Thread.sleep(400);
			String defaultItem = option.getText();
			Thread.sleep(400);

			System.out.println(defaultItem);

			if (defaultItem.equals("BTech")) {

				From.CoreorHons("BTech");

			} else if (defaultItem.equals("BE")) {
				From.CoreorHons("BE");
			}

			else if (defaultItem.equals("Science")) {
				Thread.sleep(300);
				String[] arrData1 = { "Physics", "Chemistry", "Botany", "Zoology", "Mathematics" };
				for (int j = 0; j < arrData1.length; j++) {
					Thread.sleep(500);
					From.GraduationStream("Arts");

					Thread.sleep(500);
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
					ExtentFactory.getInstance().getExtent().info("Selecting BioInformatics");
					Thread.sleep(400);
					From.PGSubjectofAdmission("Bio Informatics");

					Thread.sleep(400);

					// From.CollegeorUniversityPreference("Sambalpur University, Jyoti Vihar,
					// Sambalpur");

					Thread.sleep(400);
					From.FirstPreference("Berhampur University, Bhanja Vihar, Berhampur");
					Thread.sleep(400);

					From.SecondPreference("Bhadrak (Autonomous) College,Bhadrak");
					Thread.sleep(400);
					From.ThirdPreference("Dharanidhar (Autonomous) College, Keonjhar");
					Thread.sleep(400);

					From.ADD().click();
					Thread.sleep(400);

					From.EducationalQualificationOk().click();
				}
			}

			if (defaultItem.equals("BTech") || defaultItem.equals("BE")) {

				ExtentFactory.getInstance().getExtent().info("Selecting BioInformatics");
				Thread.sleep(400);
				From.PGSubjectofAdmission("Bio Informatics");

				Thread.sleep(400);

				// From.CollegeorUniversityPreference("Sambalpur University, Jyoti Vihar,
				// Sambalpur");

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
				if (actualPopup.contains("Graduation Percentage cannot be less than 50"))

				{
					constants.fileone.setCellData(sheetName, "Status", 94, "Pass");
					Thread.sleep(300);
					From.EducationalQualificationOk().click();
				}

				else {
					constants.fileone.setCellData(sheetName, "Status", 94, "Fail");
				}
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertEquals(actualPopup, "Graduation Percentage cannot be less than 50", "Test Failed");

				softAssert.assertAll();

				ExtentFactory.getInstance().getExtent()
						.info("Successfully Checked Bio-Informatics PG Department with Less Than 50 Percentage");
			}
		}
	}
}