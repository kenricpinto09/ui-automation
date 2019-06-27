package com.company.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.company.ui.utils.DriverManager;

public class HomePage extends DriverManager {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	private static final String SW_LOGO_ID = "nav-sw-logo-bar";
	private static final String NAV_BAR_FILMS_href = "/films";
	
	public void isPageLoaded() {
		driver.findElement(By.id(SW_LOGO_ID)).isDisplayed();
		LOGGER.debug("home page loaded");
	}
	
	public void navigateToFilms() {
		driver.findElement(By.xpath("//a[@href='"+ NAV_BAR_FILMS_href + "']")).click();
		LOGGER.debug("selected films option from the navbar");
	}

}
