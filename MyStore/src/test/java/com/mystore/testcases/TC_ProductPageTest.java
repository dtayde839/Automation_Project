package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPaymentPage;
import com.mystore.pageobject.OrderShippingPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.SearchResultPage;

public class TC_ProductPageTest extends BaseClass
{
	@Test(enabled=false, priority=1)
	public void verifySearchProduct() throws IOException
	{
		String searchKey = "T-shirt";
		logger.info("\n**************** TestCase Search Product Started ******************");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnSignIn();
		logger.info("sign in button clicked");
		MyAccount ma = new MyAccount(driver);
		ma.enterEmailAddress(emailAddress);
		ma.enterPassword(password);
		logger.info("email and password is entered");
		ma.clickSubmit();
		logger.info("Sign in button clicked");
		
		RegisteredUserAccount ru = new RegisteredUserAccount(driver);
		ru.enterSearchData(searchKey);
		logger.info("Search keyword entered in searchbox");
		ru.clickSearchBtn();
		logger.info("Search  button clicked");
		
		SearchResultPage resultpg = new SearchResultPage(driver);
		
		String SearchResultproductName = resultpg.getsearchResultProductName();
		
		if(SearchResultproductName.contains(searchKey))
		{
			logger.info("Search Product test case - Passed");
			captureScreenShot(driver, "verifySearchProduct");
			Assert.assertTrue(true);
			ru.clickOnSignOutBtn();
			logger.info("Sign out button clicked");
		}
		else
		{
			logger.info("Search Product test case - Failed");
			captureScreenShot(driver, "verifySearchProduct");
			Assert.assertTrue(false);
		}
		
		logger.info("************* TTestCase Search Product Ends ***************");
	}
	
	@Test(priority=2, enabled=true)
	public void verifyBuyProduct() throws IOException
	{
		logger.info("************* TestCase Buy Product Starts ***************");
		HomePage hp = new HomePage(driver);
		hp.clickOnSignIn();
		logger.info("sign in button clicked");
		MyAccount ma = new MyAccount(driver);
		ma.enterEmailAddress(emailAddress);
		ma.enterPassword(password);
		logger.info("email and password is entered");
		ma.clickSubmit();
		logger.info("Sign in button clicked");
		
		RegisteredUserAccount ru = new RegisteredUserAccount(driver);
		ru.clickOnDresses();
		logger.info("Dresses link is clicked");
		ru.clickOnPrintedSummerDress();
		logger.info("clicked on dress");
		ProductPage pg = new ProductPage(driver);
		pg.setSize("2");
		logger.info("Dress size selected");
		pg.setQuantity("2");
		logger.info("Dress quantity selected");
		pg.addToCart();
		logger.info("add to cart button clicked");
		pg.clickOnProceedToCheckOut();
		logger.info("checkout button clicked");	
		OrderSummaryPage os = new OrderSummaryPage(driver);
		os.clickOnProceedToCheckOut();
		logger.info("checkout button clicked");
		os.clickProcess1();
		OrderShippingPage osp = new OrderShippingPage(driver);
		osp.clickAgree();
		logger.info("agree button clicked");
		osp.clickProcess2();
		OrderPaymentPage opm= new OrderPaymentPage(driver);
		opm.clickPay();
		logger.info("payment button clicked");
		OrderConfirmationPage oc = new OrderConfirmationPage(driver);
		oc.clickCnfm();
		
		String successMsg = oc.getOrderSuccessMessage();
		
		if(successMsg.equals("Your order on My Shop is complete."))
		{
			logger.info("VerifyBuyProduct - Passed");;
			Assert.assertTrue(true);
			
			oc.clickOnsignOut();
		}
		else
		{
			logger.info("VerifyBuyProduct - Failed");
			captureScreenShot(driver, "verifyBuyProduct");
			Assert.assertTrue(false);
		}
		logger.info("************* TestCase Buy Product Ends ***************");
	}
}
