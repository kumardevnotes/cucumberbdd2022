package com.page.objects;

import org.openqa.selenium.WebDriver;

import com.utilities.AutomationBase;
import com.utilities.Utility;

public class HomePage extends Utility {

	public static WebDriver driver;
	public HomePage(WebDriver driverInstance) {
		driver = driverInstance;
	}

	public static void openApp() throws Exception {
		AutomationBase.launchApp(getAppUrl());
		clickElement(returnElement(PageObjects.loginPopCloseButton, "clickable"));
		
		logger.info("Flipkart is launched without issues");
	}

	public static void launchHomePage() {
		isDisplayed(returnElement(PageObjects.FlipkartLogo, "visible"));
		isDisplayed(returnElement(PageObjects.CartLabel, "visible"));
		isDisplayed(returnElement(PageObjects.FlipkartLogo, "visible"));
		logger.info("Flipkart homepage is launched without issues");
	}

	public static void clickViewAllButton() {
		scrollToElement(returnElement(PageObjects.ViewAllButton, "scrollTo"));
		clickElementJS(returnElement(PageObjects.ViewAllButton, "visible"));
		logger.info("Clicked on ViewAll button on the homepage");
	}

}
