package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage 
{
	WebDriver ldriver;
	
	public ProductPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(css="button[type=submit][name=Submit]")
	WebElement addToCart;
	
	@FindBy(partialLinkText="Proceed to checkout")
	WebElement proceed;
	
	public void setSize(String sizeType)
	{
		Select sz = new Select(size);
		sz.selectByValue(sizeType);
	}
	
	public void setQuantity(String qty)
	{
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public void addToCart()
	{
		addToCart.click();
	}
	
	public void clickOnProceedToCheckOut()
	{
		proceed.click();
	}
}
