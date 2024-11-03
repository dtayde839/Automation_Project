package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage
{
	WebDriver ldriver;
	
	public OrderPaymentPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(partialLinkText="Pay by check")
	WebElement pay;
	
	public void clickPay() 
	{
		pay.click();
	}

}
