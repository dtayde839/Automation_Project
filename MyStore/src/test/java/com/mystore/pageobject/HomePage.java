package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
//	identify WebElements
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	
//	action on WebElement
	public void clickOnSignIn()
	{
		signIn.click();
	}
	
	public String getPageTitle()
	{
		return(ldriver.getTitle());
	}
}
