package com.company.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.company.ui.utils.DriverManager;

public class LogInPage extends DriverManager {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	private static final String LOG_IN_CLASS_NAME = "ng-isolate-scope";
	
	public void isPageDisplayed() {
		driver.findElement(By.className(LOG_IN_CLASS_NAME)).isDisplayed();
		LOGGER.info("log in page is displayed");
	}
	
	

}
