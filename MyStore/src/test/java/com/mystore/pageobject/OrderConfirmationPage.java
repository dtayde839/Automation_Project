package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage 
{
	WebDriver ldriver;
	
	public OrderConfirmationPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
	WebElement cnfm;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p[1]")
	WebElement successMsg;
	
	@FindBy(linkText="Sign out")
	WebElement signOut;
	
	public void clickCnfm()
	{
		cnfm.click();
	}
	
	public String getOrderSuccessMessage()
	{
		return(successMsg.getText());
	}
	
	public void clickOnsignOut()
	{
		signOut.click();
	}

}
