package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount 
{
	WebDriver ldriver;
	
	public MyAccount(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
//################################# Create New Account ########################
//	identify WebElements
	@FindBy(id = "email_create")
	WebElement createEmailId;
	
	@FindBy(id = "SubmitCreate")
	WebElement submit;
	
//	action on WebElement
	public void enterCreateEmailAddress(String emailAdd)
	{
		createEmailId.sendKeys(emailAdd);
	}
	
	public void clickSubmitCreate()
	{
		submit.click();
	}
	

//################################## Registered Users #########################	
//	identify WebElements
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "passwd")
	WebElement passwd;
	
	@FindBy(id = "SubmitLogin")
	WebElement subLogin;
	
//	action on WebElement
	public void enterEmailAddress(String emailAdd)
	{
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd)
	{
		passwd.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		subLogin.click();
	}
	
}
