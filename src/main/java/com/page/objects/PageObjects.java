package com.page.objects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.Utility;

public class PageObjects extends Utility {

	public static WebDriver driver;
	public static String productName;

	public PageObjects(WebDriver driverInstance) {
		PageFactory.initElements(driverInstance, this);
		driver = driverInstance;
	}

	@FindBy(xpath = "//img[@title='Flipkart']")
	public static WebElement FlipkartLogo;

	@FindBy(xpath = "//a[.='Login']")
	public static WebElement LoginLink;

	@FindBy(xpath = "//span[.='Cart']")
	public static WebElement CartLabel;

	@FindBy(xpath = "(//form//input[@type='text'])[2]")
	public static WebElement userNameField;

	@FindBy(xpath = "//input[@type='password']")
	public static WebElement passwordField;

	@FindBy(xpath = "(//span[.='Login']/../../../..//button)[1]")
	public static WebElement loginPopCloseButton;

	@FindBy(xpath = "(//a[.='VIEW ALL'])[1]")
	public static WebElement ViewAllButton;

	@FindBy(xpath = "//input[@type='text']")
	public static WebElement SearchField;

	@FindBy(xpath = "//form[@action='/search']")
	public static WebElement searchForm;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement SearchSubmitButton;

	@FindBy(xpath = "//span[.='Filters']")
	public static WebElement filterLabel;

	@FindBy(xpath = "(//div[@class='MIXNux']/..//div[contains(text(),'REDMI')])[1]")
	public static WebElement FirstProductLink;

	@FindBy(xpath = "(//div[@class='MIXNux']/..//div[contains(text(),'REDMI')])[2]")
	public static WebElement SecondProductLink;

	@FindBy(xpath = "//div[.='Highlights']/..")
	public static WebElement ProductHighlights;

	@FindBy(xpath = "//div[@id='sellerName']//span//span")
	public static WebElement SellerLink;
	
	@FindBy(xpath = "(//div[.='About the Seller']/..//div)[5]")
	public static WebElement SellerNameOnPopup;
	
	@FindBy(xpath = "(//div[.='About the Seller']/..//div)[6]")
	public static WebElement SellerRatingOnPopup;
	
	
	@FindBy(id = "pincodeInputId")
	public static WebElement PincodeTextField;
	
	@FindBy(xpath = "//span[.='Check']")
	public static WebElement CheckButton;
	

	@FindBy(xpath = "//button//text()[.='ADD TO CART']/..")
	public static WebElement AddToCartButton;

	@FindBy(xpath = "//span[.='Cart']/..//div")
	public static WebElement CartCount;

	@FindBy(xpath = "(//div[.='Remove'])[last()]")
	public static WebElement RemoveButtonOnCart;

	@FindBy(xpath = "//div[.='Remove Item']/..//div[.='Remove']")
	public static WebElement RemoveButtonOnPopup;

	public static void setProductname(String product) {
		productName = product;
	}

	public static String getProductName() {
		return productName;
	}
	
}
