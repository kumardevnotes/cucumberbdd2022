package com.page.objects;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.utilities.AutomationBase;
import com.utilities.Utility;

public class CartPage extends Utility {
	
	public static WebDriver driver;
	
	public CartPage(WebDriver driverInstance) {
		driver = driverInstance;
	}

	
	public static void addProductsToCart() {
		try {

			String parentWindow = AutomationBase.getCurrentWindow();
			clickElement(returnElement(PageObjects.FirstProductLink, "clickable"));
			logger.info("Clicked on first item on the product listing page");
			
			AutomationBase.switchToNewWindow(AutomationBase.getCurrentWindow());
			Thread.sleep(2000);
			logger.info("test11");

			scrollToElement(returnElement(PageObjects.PincodeTextField, "visible"));
			sendKeys(returnElement(PageObjects.PincodeTextField, "visible"), "500002");
			Thread.sleep(2000);
			logger.info("test22");

			clickElementJS(returnElement(PageObjects.CheckButton, "clickable"));
			Thread.sleep(2000);
			logger.info("test33");

			scrollToElement(returnElement(PageObjects.AddToCartButton, "visible"));
			hoverOnElement(returnElement(PageObjects.AddToCartButton, "visible"));
			clickElement(returnElement(PageObjects.AddToCartButton, "clickable"));
			Thread.sleep(2000);
			logger.info("test44");
			
			logger.info("Added first item to the cart");

			String secondWindow = AutomationBase.getCurrentWindow();

			AutomationBase.switchToWindow(parentWindow);

			Thread.sleep(2000);
			clickElement(returnElement(PageObjects.SecondProductLink, "clickable"));
			logger.info("Clicked on second item on the product listing page");
			AutomationBase.switchToNewWindow(parentWindow, secondWindow);

			Thread.sleep(2000);
			scrollToElement(returnElement(PageObjects.AddToCartButton, "visible"));
			hoverOnElement(returnElement(PageObjects.AddToCartButton, "visible"));
			clickElement(returnElement(PageObjects.AddToCartButton, "clickable"));

			logger.info("Added second item to the cart");

			AutomationBase.switchToWindow(parentWindow);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void verifyCartCount(String cartCount) {
		try {
			Thread.sleep(2000);
			AutomationBase.refreshPage();
			Thread.sleep(2000);

			String CartValue = getText(returnElement(PageObjects.CartCount, "visible"));
			int actualCartCount = Integer.parseInt(CartValue);
			int expectedCartCount = Integer.parseInt(cartCount);

			Assert.assertEquals(actualCartCount == expectedCartCount, true, "Cart count is not verified");
			Thread.sleep(2000);
			logger.info("Cart count is verified");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteItemFromCart() {
		try {
			hoverOnElement(returnElement(PageObjects.CartCount, "visible"));
			clickElement(returnElement(PageObjects.CartCount, "clickable"));

			Thread.sleep(2000);
			scrollToElement(returnElement(PageObjects.RemoveButtonOnCart, "visible"));
			hoverOnElement(returnElement(PageObjects.RemoveButtonOnCart, "visible"));
			clickElement(returnElement(PageObjects.RemoveButtonOnCart, "clickable"));

			Thread.sleep(2000);
			hoverOnElement(returnElement(PageObjects.RemoveButtonOnPopup, "visible"));
			clickElement(returnElement(PageObjects.RemoveButtonOnPopup, "clickable"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void verifyCartAfterDeletion(int cartCount) {
		try {
			Thread.sleep(2000);
			AutomationBase.launchApp(getAppUrl());

			String CartValue = getText(returnElement(PageObjects.CartCount, "visible"));
			int actualCartCount = Integer.parseInt(CartValue);
			int expectedCartCount = cartCount;

			Assert.assertEquals(actualCartCount == expectedCartCount, true,
					"Cart count is not verified after deleting the cart items");
			Thread.sleep(2000);
			logger.info("Cart count is verified after deleting the cart items");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
