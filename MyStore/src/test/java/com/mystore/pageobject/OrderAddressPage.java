package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderAddressPage
{
	WebDriver ldriver;
	
	public OrderAddressPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(linkText="Proceed to checkout")
	WebElement proceed;
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state; 
	
	@FindBy(id="postcode")
	WebElement zip;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id="alias")
	WebElement alias;
	
	@FindBy(id="submitAddress")
	WebElement save;
	
	public void clickOnProceedToCheckOut()
	{
		proceed.click();
	}
	
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	
	public void setCity(String City)
	{
		city.sendKeys(City);
	}
	
	public void setState(String State)
	{
		Select st = new Select(state);
		st.selectByValue(State);
	}
	
	public void setPin(String pin)
	{
		zip.sendKeys(pin);
	}
	
	public void setCountry(String Country)
	{
		Select cn = new Select(country);
		cn.selectByValue(Country);
	}
	
	public void setContact(String contact)
	{
		phone.sendKeys(contact);
	}
	
	public void setAdd(String address)
	{
		alias.sendKeys(address);
	}
	
	public void saveInfo()
	{
		save.click();
	}
}
