package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage
{
	WebDriver ldriver;

	public OrderShippingPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(name="processCarrier")
	WebElement process2;
	
	@FindBy(id="cgv")
	WebElement agree;
	
	public void clickProcess2()
	{
		process2.click();
	}
	
	public void clickAgree()
	{
		agree.click();
	}

}
