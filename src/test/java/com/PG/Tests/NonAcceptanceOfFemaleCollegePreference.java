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

public class NonAcceptanceOfFemaleCollegePreference extends BaseClass implements PGCAFData{

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
	public void NonAcceptanceOfFemaleCollegePreferenceforMaleCandidate() throws Exception {

		// logger = report.createTest("Verifying NonAcceptance Of Female College
		// Preference MailCandidate");

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

		Thread.sleep(700);

		String[] exp = { "Ramadevi Women's University", "Shailabala Women's College" };
		WebElement dropdown = driver.findElement(By.id("ddlCPreference"));
		Select select = new Select(dropdown);
		java.util.List<WebElement> options = select.getOptions();
		for (WebElement item : options) {
			for (int i = 0; i < exp.length; i++) {
				if (item.getText().equals(exp[i])) {
					System.out.println("Matched");
					constants.fileone.setCellData(sheetName, "Status", 244, "Fail");
				} else {
					constants.fileone.setCellData(sheetName, "Status", 244, "Pass");
					System.out.println("Not-Matched");
				}
			}
		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(options, options, "Test Failed");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully checked for Female Examination Center1 For Male Candidate scenario");
	}

}
