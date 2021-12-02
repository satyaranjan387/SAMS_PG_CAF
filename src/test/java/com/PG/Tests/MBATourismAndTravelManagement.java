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

public class MBATourismAndTravelManagement extends BaseClass implements PGCAFData{

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
	public void MBATourismAndDevelopmentWithAtleast50Percentage() throws Exception {

		//logger = report.createTest("Verify MBA Tourism And Devlopment Apply Atleast 50 Percentage");

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
		String[] arrData = { "Arts", "Commerce", "Science", "BTech", "BE", "B Pharma", "BBA", "BCA", "Law(LLB)", "BES",
				"BHMS", "BIT", "BSW", "Graduation with 1 yr B.Lib.Sc", "B.Lib and Information Science", "B.Sc. (ITM)",
				"BArch", "B.Sc. (CS)", "B.Sc. (IT)" };

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
			} else if (defaultItem.equals("Law(LLB)")) {
				From.CoreorHons("Law");
			} else if (defaultItem.equals("BES")) {
				From.CoreorHons("Electronics");
			} else if (defaultItem.equals("BHMS")) {
				From.CoreorHons("BHMS");
			} else if (defaultItem.equals("BIT")) {
				From.CoreorHons("Computer Science");
			} else if (defaultItem.equals("BSW")) {
				From.CoreorHons("Social Work");
			} else if (defaultItem.equals("Graduation with 1 yr B.Lib.Sc")) {
				From.CoreorHons("Library Science");
			} else if (defaultItem.equals("B.Lib and Information Science")) {
				From.CoreorHons("Library Science");
			} else if (defaultItem.equals("B.Sc. (ITM)")) {
				From.CoreorHons("B.Sc. (ITM)");
			} else if (defaultItem.equals("B.Sc. (CS)")) {
				From.CoreorHons("B.Sc. (CS)");
			} else if (defaultItem.equals("BArch")) {
				From.CoreorHons("BArch");
			} else if (defaultItem.equals("B.Sc. (IT)")) {
				From.CoreorHons("B.Sc. (IT)");
			} else if (defaultItem.equals("BBA")) {
				From.CoreorHons("BBA");
			} else if (defaultItem.equals("BCA")) {
				From.CoreorHons("BCA");
			} else if (defaultItem.equals("B Pharma")) {
				From.CoreorHons("B Pharma");
			}

			else if (defaultItem.equals("Arts")) {

				Thread.sleep(300);
				From.Hons1().click();

				Thread.sleep(300);

				From.CoreorHons("Sociology");

				Thread.sleep(300);
				From.GraduationElective1("Hindi");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}

			else if (defaultItem.equals("Commerce")) {
				Thread.sleep(300);
				From.Hons1().click();

				From.CoreorHons("Commerce");
				Thread.sleep(300);
				From.GraduationElective1("Commerce");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}

			else if (defaultItem.equals("Science")) {
				Thread.sleep(300);
				From.Hons1().click();

				From.CoreorHons("Animal Science");
				Thread.sleep(300);
				From.GraduationElective1("Botany");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}
			ExtentFactory.getInstance().getExtent().info("Selecting MBA (Tourism & Travel Management)");
			Thread.sleep(400);
			Thread.sleep(400);
			From.PGSubjectofAdmission("MBA (Tourism & Travel Management)");

			Thread.sleep(400);

			// Thread.sleep(500);
			//From.CollegeorUniversityPreference("Khallikote University, Berhampur");

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
				constants.fileone.setCellData(sheetName, "Status", 177, "Pass");
				Thread.sleep(300);
				From.EducationalQualificationCancel().click();
			}

			else {
				constants.fileone.setCellData(sheetName, "Status", 177, "Fail");
			}
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");
			
			softAssert.assertAll();
			
			ExtentFactory.getInstance().getExtent().info("Successfully Checked MBA TourismAndDevlopment PG Department Atleast 50 Percentage scenario");
		}

	}

	@Test(priority = 2)
	public void MBATourismAndDevelopmentWithLessThan50Percentage() throws Exception {

		//logger = report.createTest("Verify MBA Tourism And Devlopment with Less Than 50 Percentage");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		Thread.sleep(500);

		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("298");

		String[] arrData = { "Arts", "Commerce", "Science", "BTech", "BE", "B Pharma", "BBA", "BCA", "Law(LLB)", "BES",
				"BHMS", "BIT", "BSW", "Graduation with 1 yr B.Lib.Sc", "B.Lib and Information Science", "B.Sc. (ITM)",
				"BArch", "B.Sc. (CS)", "B.Sc. (IT)" };

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
			} else if (defaultItem.equals("Law(LLB)")) {
				From.CoreorHons("Law");
			} else if (defaultItem.equals("BES")) {
				From.CoreorHons("Electronics");
			} else if (defaultItem.equals("BHMS")) {
				From.CoreorHons("BHMS");
			} else if (defaultItem.equals("BIT")) {
				From.CoreorHons("Computer Science");
			} else if (defaultItem.equals("BSW")) {
				From.CoreorHons("Social Work");
			} else if (defaultItem.equals("Graduation with 1 yr B.Lib.Sc")) {
				From.CoreorHons("Library Science");
			} else if (defaultItem.equals("B.Lib and Information Science")) {
				From.CoreorHons("Library Science");
			} else if (defaultItem.equals("B.Sc. (ITM)")) {
				From.CoreorHons("B.Sc. (ITM)");
			} else if (defaultItem.equals("B.Sc. (CS)")) {
				From.CoreorHons("B.Sc. (CS)");
			} else if (defaultItem.equals("BArch")) {
				From.CoreorHons("BArch");
			} else if (defaultItem.equals("B.Sc. (IT)")) {
				From.CoreorHons("B.Sc. (IT)");
			} else if (defaultItem.equals("BBA")) {
				From.CoreorHons("BBA");
			} else if (defaultItem.equals("BCA")) {
				From.CoreorHons("BCA");
			} else if (defaultItem.equals("B Pharma")) {
				From.CoreorHons("B Pharma");
			}

			else if (defaultItem.equals("Arts")) {

				Thread.sleep(300);
				From.Hons1().click();

				Thread.sleep(300);

				From.CoreorHons("Sociology");

				Thread.sleep(300);
				From.GraduationElective1("Hindi");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}

			else if (defaultItem.equals("Commerce")) {
				Thread.sleep(300);
				From.Hons1().click();

				From.CoreorHons("Commerce");
				Thread.sleep(300);
				From.GraduationElective1("Commerce");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}

			else if (defaultItem.equals("Science")) {
				Thread.sleep(300);
				From.Hons1().click();

				From.CoreorHons("Animal Science");
				Thread.sleep(300);
				From.GraduationElective1("Botany");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}
			ExtentFactory.getInstance().getExtent().info("Selecting MBATourismAndDevlopment");
			Thread.sleep(400);
			From.PGSubjectofAdmission("MBA (Tourism & Travel Management)");

			Thread.sleep(400);

			// Thread.sleep(500);
			//From.CollegeorUniversityPreference("Khallikote University, Berhampur");

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
				constants.fileone.setCellData(sheetName, "Status", 178, "Pass");
				Thread.sleep(300);
				From.EducationalQualificationOk().click();
			}

			else {
				constants.fileone.setCellData(sheetName, "Status", 178, "Fail");
			}
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualPopup, "Graduation Percentage cannot be less than 50", "Test Failed");
			
			softAssert.assertAll();
			
			ExtentFactory.getInstance().getExtent().info("Successfully Checked MBATourismAndDevlopment PG Department Not Apply Less Than 50 Percentage");
		}

	}
}