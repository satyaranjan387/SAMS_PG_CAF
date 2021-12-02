package com.PG.Tests;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import com.PG.Listener.ExtentFactory;
import com.PG.genericLibrary.constants;
import com.PG.objectRepository.BaseClass;
import com.PG.objectRepository.PGCAFData;
import com.PG.objectRepository.PGLoginNew;

public class LoginScenarios extends BaseClass implements PGCAFData{

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void LoginWithInvalidMobileNoValidPassword(Method method) throws Exception {

		//logger = report.createTest("Verifying login providing Invalid Mobile No & Valid Password");

		PGLoginNew login = new PGLoginNew(driver);

		ExtentFactory.getInstance().getExtent().info("Entering Invalid Mobile No.");

		login.MobileNo().sendKeys("9438669975");
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Valid Password");

		login.Password().sendKeys("Pass@123word");
		Thread.sleep(500);

		File src = driver.findElement(By.id("imgCapcha")).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/test-output/captcha.png";

		try {
			FileHandler.copy(src, new File(path));

			ITesseract image = new Tesseract();

			String imageText = image.doOCR(new File(path));
			System.out.println(imageText);
			login.Captcha().sendKeys(imageText);
			Thread.sleep(1000);
			// login.SignIn().submit();
		} catch (NoSuchElementException e) {
		}

		Thread.sleep(400);

		String actualPopup = login.PopUpMsg().getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Invalid username or Password"))

		{
			constants.fileone.setCellData(sheetName, "Status", 6, "Pass");
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 6, "Fail");
		}

		login.PopUpOK().click();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Invalid username or Password", "Test Failed");
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Login with Invalid Mobile No & Valid Password scenario");
	}

	@Test(priority = 1)
	public void LoginWithValidMobileNoInvalidPassword() throws Exception {
		
		//logger = report.createTest("Verifying login providing Valid Mobile No & Invalid Password");

		PGLoginNew login = new PGLoginNew(driver);

		ExtentFactory.getInstance().getExtent().info("Entering Valid Mobile No.");

		login.MobileNo().clear();

		login.MobileNo().sendKeys("6371664345");
		Thread.sleep(400);

		// ExtentFactory.getInstance().getExtent().info("Entering Invalid Password");

		login.Password().sendKeys("Password@123");
		Thread.sleep(400);

		File src = driver.findElement(By.id("imgCapcha")).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/test-output/captcha.png";

		try {
			FileHandler.copy(src, new File(path));

			ITesseract image = new Tesseract();

			String imageText = image.doOCR(new File(path));
			System.out.println(imageText);
			login.Captcha().sendKeys(imageText);
			Thread.sleep(3000);
			// login.SignIn().click();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(400);

		String actualPopup = driver.findElement(By.id("popup_message")).getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Invalid username or Password"))

		{
			constants.fileone.setCellData(sheetName, "Status", 7, "Pass");
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 7, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Invalid username or Password", "Test Failed");

		driver.findElement(By.id("popup_ok")).click();
		
		softAssert.assertAll();

		 ExtentFactory.getInstance().getExtent().info("Successfully checked Login with Valid Mobile No & InvalidPassword scenario");
	}

	@Test(priority = 2)
	public void LoginWithInvalidMobileNoInvalidPassword() throws Exception {
		
		//logger = report.createTest("Verifying login providing Invalid Mobile No & Invalid Password");

		PGLoginNew login = new PGLoginNew(driver);

		ExtentFactory.getInstance().getExtent().info("Entering Invalid Mobile No.");

		login.MobileNo().clear();

		login.MobileNo().sendKeys("828071179");
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Invalid Password");

		login.Password().sendKeys("Password@1277");
		Thread.sleep(400);

		File src = driver.findElement(By.id("imgCapcha")).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/test-output/captcha.png";

		try {
			FileHandler.copy(src, new File(path));

			ITesseract image = new Tesseract();

			String imageText = image.doOCR(new File(path));
			System.out.println(imageText);
			login.Captcha().sendKeys(imageText);
			Thread.sleep(3000);
			// login.SignIn().click();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(400);

		String actualPopup = driver.findElement(By.id("popup_message")).getText();
		System.out.println(actualPopup);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Invalid username or Password"))

		{
			constants.fileone.setCellData(sheetName, "Status", 8, "Pass");
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 8, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualPopup, "Invalid username or Password", "Test Failed");

		driver.findElement(By.id("popup_ok")).click();
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully checked Login with Invalid Mobile No & Invalid Password scenario");
	}

	@Test(priority = 3)
	public void LoginWithValidMobileNoValidPassword() throws Exception {
		
		//logger = report.createTest("Verifying login providing Valid Mobile No & Valid Password");

		PGLoginNew login = new PGLoginNew(driver);

		ExtentFactory.getInstance().getExtent().info("Entering Valid Mobile No.");

		login.MobileNo().clear();

		login.MobileNo().sendKeys("6371664345");
		Thread.sleep(400);

		ExtentFactory.getInstance().getExtent().info("Entering Valid Password");

		login.Password().sendKeys("Pass@123word");
		Thread.sleep(400);

		File src = driver.findElement(By.id("imgCapcha")).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/test-output/captcha.png";

		try {
			FileHandler.copy(src, new File(path));

			ITesseract image = new Tesseract();

			String imageText = image.doOCR(new File(path));
			System.out.println(imageText);
			login.Captcha().sendKeys(imageText);
			Thread.sleep(3000);
			login.SignIn().click();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(400);

		WebElement Dashboardpage = driver.findElement(By.xpath("//li[@class='active']//a[@class='active']"));// Relative
																												// Xpath

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (Dashboardpage.isDisplayed())

		{
			constants.fileone.setCellData(sheetName, "Status", 5, "Pass");
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 5, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(Dashboardpage, "Page Not Found");
		
		//softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully checked Login with Valid Mobile No & Valid Password scenario");

	}
}
