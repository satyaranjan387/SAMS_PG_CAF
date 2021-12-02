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

public class DisplayingofValidPGSubject extends BaseClass implements PGCAFData{

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
	public void DisplayingValidPGSubjectAsPerGraduationSubject() throws Exception {

		//logger = report.createTest("Verify the Functionality By Displaying Valid PG Subject As Per Graduation Subject");

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

		From.GraduationSecuredMarksorCGPA().sendKeys("275");

		Thread.sleep(500);
		From.GraduationStream("Science");
		Thread.sleep(500);

		Thread.sleep(400);
		From.Hons1().click();

		Thread.sleep(400);
		From.CoreorHons("Agriculture Science");
		Thread.sleep(400);

		From.GraduationElective1("Animal Science");

		Thread.sleep(300);
		From.Credit1("84");
		Thread.sleep(300);
		From.Elective1Credit1("24");

		Thread.sleep(400);
		String[] arrData = { "Applied Psychology", "Environmental Science" };
		Thread.sleep(400);
		for (int i = 0; i < arrData.length; i++) {
			From.PGSubjectofAdmission(arrData[i]);

			Thread.sleep(400);
			Select select = new Select(driver.findElement(By.id("ddlPGEntranceSubject")));
			Thread.sleep(400);
			WebElement option = select.getFirstSelectedOption();
			Thread.sleep(400);
			String defaultItem = option.getText();
			Thread.sleep(400);

			if (defaultItem.equals("Applied Psychology")) {
				
				// Thread.sleep(500);
				//From.CollegeorUniversityPreference("Khallikote University, Berhampur");
				
				From.ADD().click();
				Thread.sleep(400);
			} else if (defaultItem.equals("Environmental Science")) {
				
				//From.CollegeorUniversityPreference("Utkal University, Vanivihar, Bhubaneswar");
				
				From.ADD().click();
				Thread.sleep(400);
			}
		}

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
			constants.fileone.setCellData(sheetName, "Status", 236, "Pass");
			Thread.sleep(300);
			From.EducationalQualificationCancel().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 236, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");
		
		softAssert.assertAll();
		
		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked By Displaying Valid PG Subject As Per Graduation Subject Scenario");
	}

}