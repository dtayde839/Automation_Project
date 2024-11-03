package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount 
{
	WebDriver ldriver;
	
	public RegisteredUserAccount(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
//	identify WebElements
	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement userName;
	
	@FindBy(linkText="Sign out")
	WebElement signOutBtn;
	
	@FindBy(name = "search_query")
	WebElement searchBox;
	
	@FindBy(name ="submit_search")
	WebElement submitSearch;
	
	@FindBy(partialLinkText="DRESSES")
	WebElement dresses;
	
	@FindBy(linkText="Printed Summer Dress")
	WebElement printedSummerDress;
	
	public String getUserName()
	{
		String uName = userName.getText();
		
		return uName;
	}
	
	public void clickOnSignOutBtn()
	{
		signOutBtn.click();
	}
	
	public void enterSearchData(String searchKey)
	{
		searchBox.sendKeys(searchKey);
	}
	
	public void clickSearchBtn()
	{
		submitSearch.click();
	}
	
	public void clickOnDresses()
	{
		dresses.click();
	}
	
	public void clickOnPrintedSummerDress()
	{
		printedSummerDress.click();
	}
}
 