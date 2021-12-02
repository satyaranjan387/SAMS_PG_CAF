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

public class Law extends BaseClass implements PGCAFData{

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
	public void LawWithAtleast50percentage() throws Exception {

		//logger = report.createTest("Verifying Law PG Department Apply Minimum 45 Percentage");
		
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

		From.GraduationSecuredMarksorCGPA().sendKeys("300");
		String[] arrData = { "Law(LLB)" };

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

			if (defaultItem.equals("Law(LLB)")) {
				From.CoreorHons("Law");
			}

			ExtentFactory.getInstance().getExtent().info("Law (LLM)");

			Thread.sleep(400);
			From.PGSubjectofAdmission("Law (LLM)");

			Thread.sleep(400);

			//From.CollegeorUniversityPreference("Utkal University, Vanivihar, Bhubaneswar");

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
				constants.fileone.setCellData(sheetName, "Status", 155, "Pass");
				Thread.sleep(300);
				From.EducationalQualificationCancel().click();
			}

			else {
				constants.fileone.setCellData(sheetName, "Status", 155, "Fail");
			}
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");
			
			softAssert.assertAll();
			
			ExtentFactory.getInstance().getExtent().info("Successfully Checked Law Department Apply Minimum 45 percentage Scenario");
		}

	}

	@Test(priority = 2)
	public void LawWithLessThan50percentage() throws Exception {

		//logger = report.createTest("Verifying Law Department Not Apply Less Than 45 Percenatge");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

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

		From.GraduationSecuredMarksorCGPA().sendKeys("290");

		From.EducationalQualificationOk().click();
		String[] arrData = { "Law(LLB)" };

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

			if (defaultItem.equals("Law(LLB)")) {
				From.CoreorHons("Law");
			}

			ExtentFactory.getInstance().getExtent().info("Law (LLM)");

			Thread.sleep(400);
			From.PGSubjectofAdmission("Law (LLM)");
			Thread.sleep(400);

			//From.CollegeorUniversityPreference("Utkal University, Vanivihar, Bhubaneswar");

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
				constants.fileone.setCellData(sheetName, "Status", 156, "Pass");
				Thread.sleep(300);
				From.EducationalQualificationOk().click();
			}

			else {
				constants.fileone.setCellData(sheetName, "Status", 156, "Fail");
			}
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualPopup, "Graduation Percentage cannot be less than 50", "Test Failed");
			
			softAssert.assertAll();
			
			ExtentFactory.getInstance().getExtent()
					.info("Successfully Checked Law Department Not Apply Less Than 45 Percenatge Scenario");
		}

	}
}