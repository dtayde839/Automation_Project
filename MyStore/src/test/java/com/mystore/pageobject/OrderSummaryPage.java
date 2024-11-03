package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage 
{
	WebDriver ldriver;
	
	public OrderSummaryPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(linkText="Proceed to checkout")
	WebElement proceed;
	
	@FindBy(name="processAddress")
	WebElement process1;
	
	public void clickOnProceedToCheckOut()
	{
		proceed.click();
	}
	
	public void clickProcess1()
	{
		process1.click();
	}
}
