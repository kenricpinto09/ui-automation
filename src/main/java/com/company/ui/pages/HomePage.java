package com.company.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.company.ui.utils.DriverManager;

public class HomePage extends DriverManager {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	private static final String SW_LOGO_ID = "nav-sw-logo-bar";
	private static final String NAV_BAR_FILMS_href = "/films";
	private static final String NAV_BAR_VIDEO_href = "/video";
	private static final String LOGIN_CLASS = "disid-login log-in-out";
	private static final String SIGN_UP_CLASS = "disid-signup log-in-out";
	private static final String COPYRIGHT_ID = "copyright";
	
	public void isPageDisplayed() {
		driver.findElement(By.id(SW_LOGO_ID)).isDisplayed();
		LOGGER.debug("home page loaded");
	}
	
	public void navigateToFilms() {
		driver.findElement(By.xpath("//a[@href='"+ NAV_BAR_FILMS_href + "']")).click();
		LOGGER.debug("selected films option from the navbar");
	}
	
	public void navigateToVideo() {
		driver.findElement(By.xpath("//a[@href='"+ NAV_BAR_VIDEO_href + "']")).click();
		LOGGER.debug("selected films option from the navbar");
	}
	
	
	public void navigateToLogin() {
		driver.findElement(By.className(LOGIN_CLASS)).click();
		LOGGER.debug("login option selected");
	}
	
	public void navigateToSignUp() {
		driver.findElement(By.className(SIGN_UP_CLASS)).click();
		LOGGER.debug("sign up option selected");
	}
	
	public String getCopyrightText() {
		return driver.findElement(By.id(COPYRIGHT_ID)).getText();
	}

}
