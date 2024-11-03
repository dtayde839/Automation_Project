package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyAccountCreation 
{
	WebDriver ldriver;
	
	public MyAccountCreation(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
//	identify WebElements
	@FindBy(id = "id_gender1")
	WebElement titleMr;
	
	@FindBy(id = "customer_firstname")
	WebElement cust_fname;
	
	@FindBy(id = "customer_lastname")
	WebElement cust_lname;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "days")
	WebElement birthDay;
	
	@FindBy(id = "months")
	WebElement birthMonth;
	
	@FindBy(id = "years")
	WebElement birthYear;
	
	@FindBy(id = "submitAccount")
	WebElement register;
	
//	action on WebElement
	public void selectTitle()
	{
		titleMr.click();;
	}
	
	public void enterCustomerFirstName(String fname)
	{
		cust_fname.sendKeys(fname);;
	}
	
	public void enterCustomerLastName(String lname)
	{
		cust_lname.sendKeys(lname);;
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);;
	}
	
	public void selectDay(String day)
	{
		Select d = new Select(birthDay);
		d.selectByValue(day);
	}
	
	public void selectMonth(String month)
	{
		Select m = new Select(birthMonth);
		m.selectByValue(month);
	}
	
	public void selectYear(String year)
	{
		Select y = new Select(birthYear);
		y.selectByValue(year);
	}
	
	public void clickOnRegister()
	{
		register.click();
	}
}
