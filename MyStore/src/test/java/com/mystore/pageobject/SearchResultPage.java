package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage 
{
	WebDriver ldriver;
	
	public SearchResultPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
//	Identify Elements
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a")
	WebElement searchResultproduct;
	
	@FindBy(linkText="More")
	WebElement more;
	
//	action methods
	public String getsearchResultProductName()
	{
		return(searchResultproduct.getText());
	}
	 
	public void clickOMore()
	{
		more.click();
	}
}
