package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.MyAccountCreation;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageTest extends BaseClass
{
	@Test(enabled=true, priority=2, groups= {"signOut"})
	public void verifyRegistration()
	{
		HomePage pg = new HomePage(driver);
		pg.clickOnSignIn();
		logger.info("clicked on sign in link");
		
		MyAccount ma = new MyAccount(driver);
		ma.enterCreateEmailAddress("tayde654@gmail.com");
		logger.info("Email address entered");
		
		ma.clickSubmitCreate();
		logger.info("clicked on submit button");
		
		MyAccountCreation macp = new MyAccountCreation(driver);
		macp.selectTitle();
		macp.enterCustomerFirstName("Dinesh");
		macp.enterCustomerLastName("Tayde");
		macp.enterPassword("tayde839");
		macp.selectDay("28");
		macp.selectMonth("6");
		macp.selectYear("1997");
		logger.info("entered user details on account creation page");
		macp.clickOnRegister();
		logger.info("clicked on registered button");
		
		RegisteredUserAccount regUser = new RegisteredUserAccount(driver); 
		String userName = regUser.getUserName();
		
		Assert.assertEquals("Dinesh Tayde", userName);
	}
	
	@Test(groups= {"signOut"}, dataProvider = "LoginDataProvider", enabled=true, priority=3)
	public void verifyLogin(String userEmail, String userPwd, String expUserName) throws IOException
	{
		logger.info("verifyLogin test execution started....");
		
		HomePage pg = new HomePage(driver);
		pg.clickOnSignIn();
		logger.info("clicked on sign in link");
		
		MyAccount ma = new MyAccount(driver);
		ma.enterEmailAddress(userEmail);
		logger.info("entered email address");
		ma.enterPassword(userPwd);
		logger.info("entered password");
		
		ma.clickSubmit();
		logger.info("clicked on sign in link");
		
		RegisteredUserAccount regUser = new RegisteredUserAccount(driver); 
		String userName = regUser.getUserName();
		
		if(userName.equals(expUserName))
		{	
			logger.info("VerifyLogin - Passed");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(true);
//			regUser.clickOnSignOutBtn();
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver, "verifyLogin");
			String expError = driver.findElement(By.cssSelector("div#center_column>.alert>ol>li")).getText();
			Assert.assertEquals("Authentication failed.", expError);
		}
	}
	
	@Test(enabled=true, priority=1)
	public void verifySignOut() throws IOException
	{
		logger.info("************** Verify Sign out test execution started *************");
		
		HomePage pg = new HomePage(driver);
		pg.clickOnSignIn();
		logger.info("clicked on sign in link");
		
		MyAccount ma = new MyAccount(driver);
		ma.enterEmailAddress(emailAddress);
		logger.info("entered email address");
		ma.enterPassword(password);
		logger.info("entered password");
		
		ma.clickSubmit();
		logger.info("clicked on sign in link");
		
		RegisteredUserAccount ra = new RegisteredUserAccount(driver);
		ra.clickOnSignOutBtn();
		
		if(pg.getPageTitle().equals("Login - My Shop"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenShot(driver, "verifySignOut");
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="LoginDataProvider")
	public String [][] LoginDataProvider()
	{
		System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreV1TestData.xlsx";
		
		int totalRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int totalColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
		
		String data[][] = new String[totalRows-1][totalColumns];
		
		for(int i=1; i<totalRows; i++)
		{
			for(int j=0; j<totalColumns; j++)
			{
				data[i-1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}
		}
		return data;
	}
	
	@AfterMethod(onlyForGroups="signOut")
	public void signOut()
	{
		WebElement signOut = driver.findElement(By.partialLinkText("Sign out"));
		signOut.click();
	}
}
