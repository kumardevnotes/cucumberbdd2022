package com.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import com.utilities.AutomationBase;
import com.utilities.Utility;

public class ProductsListingPage extends Utility {
	public static WebDriver driver;

	public ProductsListingPage(WebDriver driverInstance) {
		driver = driverInstance;
	}

	public static void verifyProductsPage() {
		isDisplayed(returnElement(PageObjects.SearchField, "visible"));
		logger.info("Product list page verified");
	}

	public static void searchItem(String searchItem) {
		sendKeys(returnElement(PageObjects.SearchField, "visible"), searchItem);
		clickToRightOf("button", returnElement(PageObjects.SearchSubmitButton,"visible"));
		//clickElement(returnElement(PageObjects.SearchSubmitButton,"visible"));
		logger.info("Searched an item::");
	}


	public static void verifyProductsPageOnSearch(String string) {
		try {
			isDisplayed(returnElement(PageObjects.FirstProductLink,"visible"));
			isDisplayed(returnElement(PageObjects.SecondProductLink,"visible"));
			logger.info("Products loaded based on the search");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyFilter() {
		isDisplayed(returnElement(PageObjects.filterLabel, "visible"));
		logger.info("Filter label verified on the page");
	}

	public static void clickOnProduct() {
		try {
			PageObjects.setProductname(getText(returnElement(PageObjects.FirstProductLink, "visible")));
			scrollToElement(returnElement(PageObjects.FirstProductLink, "visible"));
			hoverOnElement(returnElement(PageObjects.FirstProductLink, "visible"));
			clickElement(returnElement(PageObjects.FirstProductLink, "visible"));
			logger.info("Clicked on first item on the product listing page");
			Thread.sleep(2000);
			AutomationBase.switchToNewWindow(AutomationBase.getCurrentWindow());
			logger.info("Switched to new window");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyProductDescription() {
		try {
			logger.info("producName:" + PageObjects.getProductName());
			isDisplayed(returnElement(driver.findElement(By.xpath("//img[@alt='" + PageObjects.getProductName() + "']")), "visible"));
			logger.info("verified product image");
			
			scrollToElement(returnElement(driver
					.findElement(By.xpath("//h1//span[contains(text(),'" + PageObjects.getProductName() + "')]")), "visible"));
			
			isDisplayed(returnElement(driver
					.findElement(By.xpath("//h1//span[contains(text(),'" + PageObjects.getProductName() + "')]")), "visible"));
			logger.info("Verified product name");

			
			scrollToElement(returnElement(PageObjects.ProductHighlights, "visible"));
			isDisplayed(returnElement(PageObjects.ProductHighlights, "visible"));
			logger.info("Verified product highlights");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifySeller() {
		try {
			scrollToElement(returnElement(PageObjects.SellerLink, "visible"));
			isDisplayed(returnElement(PageObjects.SellerLink, "visible"));
			String sellerName = getText(returnElement(PageObjects.SellerLink, "visible")).trim();
			Assert.assertEquals(!sellerName.isEmpty(), true);
			logger.info("Seller name verified on product details page");

			hoverOnElement(returnElement(PageObjects.SellerLink, "visible"));
			clickElementJS(returnElement(PageObjects.SellerLink, "visible"));

			isDisplayed(returnElement(PageObjects.SellerNameOnPopup, "visible"));
			Assert.assertEquals(getText(returnElement(PageObjects.SellerNameOnPopup, "visible")).trim(), sellerName);
			logger.info("Seller name verified on popup");

			isDisplayed(returnElement(PageObjects.SellerRatingOnPopup, "visible"));

			String ratingOnPage = getText(returnElement(PageObjects.SellerRatingOnPopup, "visible"));
			double ratingInDecimal = Double.parseDouble(ratingOnPage);
			int actualRating = (int) ratingInDecimal;

			Assert.assertEquals(actualRating > 1, true);
			logger.info("Seller rating verified");

			Thread.sleep(2000);

			AutomationBase.sendEscapeKey();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
